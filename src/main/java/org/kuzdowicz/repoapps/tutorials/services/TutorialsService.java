package org.kuzdowicz.repoapps.tutorials.services;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsDao;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.Category;
import org.kuzdowicz.repoapps.tutorials.models.NoEmbedApiResponse;
import org.kuzdowicz.repoapps.tutorials.models.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Range;

@Service
public class TutorialsService {

	private TutorialsDao tutorialsDao;
	private CategoriesService categoriesService;
	private UsersDao usersDao;
	private NoEmbedApiClientService noEmbedApi;

	@Autowired
	public TutorialsService(TutorialsDao tutorialsDao, CategoriesService categoriesService, UsersDao usersDao,
			NoEmbedApiClientService noEmbedApi) {
		this.tutorialsDao = tutorialsDao;
		this.categoriesService = categoriesService;
		this.usersDao = usersDao;
		this.noEmbedApi = noEmbedApi;
	}

	private final static Range<Integer> rangeForProgressIncrementation = Range.closed(0, 95);
	private final static Range<Integer> rangeForProgressDecrementation = Range.closed(5, 100);
	private final static Long ratingStarVal = 0L;
	private final static Integer progressStartVal = 0;

	public List<Tutorial> selectAll() {
		return tutorialsDao.findAll();
	}

	public Tutorial getOneById(Long id) {
		return tutorialsDao.findOne(id);
	}

	public void removeOneById(Long id) {
		tutorialsDao.delete(getOneById(id));
	}

	public Tutorial incremetRatingAndReturnChangedObject(Long pk) {

		Tutorial tutorial = getOneById(pk);
		Long actualRating = tutorial.getRating();
		Optional.of(actualRating).filter(val -> val < Long.MAX_VALUE).ifPresent(presentVal -> {
			presentVal++;
			tutorial.setRating(presentVal);
			tutorialsDao.saveOrUpdate(tutorial);
		});
		return tutorial;
	}

	public Tutorial decrementRatingAndReturnChangedObject(Long pk) {

		Tutorial tutorial = getOneById(pk);
		Long actualRating = tutorial.getRating();
		Optional.of(actualRating).filter(val -> val > 0).ifPresent(presentVal -> {
			presentVal--;
			tutorial.setRating(presentVal);
			tutorialsDao.saveOrUpdate(tutorial);
		});
		return tutorial;
	}

	public Tutorial incremetTutorialProgressAndReturnChangedObject(Long pk) {

		Tutorial tutorial = getOneById(pk);
		Integer actualProgress = tutorial.getProgress();
		Optional.of(actualProgress).filter(val -> rangeForProgressIncrementation.contains(val))
				.ifPresent(presentValue -> {
					presentValue += 5;
					tutorial.setProgress(presentValue);
					tutorialsDao.saveOrUpdate(tutorial);
				});
		return tutorial;
	}

	public Tutorial decremetTutorialProgressAndReturnChangedObject(Long pk) {

		Tutorial tutorial = getOneById(pk);
		Integer actualProgress = tutorial.getProgress();
		Optional.of(actualProgress).filter(val -> rangeForProgressDecrementation.contains(val))
				.ifPresent(presentValue -> {
					presentValue -= 5;
					tutorial.setProgress(presentValue);
					tutorialsDao.saveOrUpdate(tutorial);
				});
		return tutorial;
	}

	public List<Tutorial> getTutorialsToDoForCurrentWeekWithDaysLeftFiled() {

		Date firstDayOfCurrentWeek = DateTime.now().withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date weekLater = DateTime.now().plusWeeks(1).toDate();
		List<Tutorial> allTutorialsBeetwenGivenDates = tutorialsDao
				.getAllTutorialsBeetwenGivenDates(firstDayOfCurrentWeek, weekLater);
		allTutorialsBeetwenGivenDates.forEach(tutorial -> {
			DateTime tutorialEndDateJodaVar = new DateTime(tutorial.getEndDateToDo());
			DateTime today = DateTime.now();
			Days days = Days.daysBetween(today.minusDays(1), tutorialEndDateJodaVar.plusDays(1));
			Integer daysLeft = Optional.of(days.getDays()).filter(d -> d > 0).orElse(0);
			tutorial.setDaysLeft(new Long(daysLeft));
		});
		return allTutorialsBeetwenGivenDates;
	}

	public List<Tutorial> getUserTutorialsToDoForCurrentWeekWithDaysLeftFiled(String currentUsername) {

		Date firstDayOfCurrentWeek = DateTime.now().withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date weekLater = DateTime.now().plusWeeks(1).toDate();

		List<Tutorial> allTutorialsBeetwenGivenDates = tutorialsDao.getAllTutorialsBeetwenGivenDatesAndUserId(
				firstDayOfCurrentWeek, weekLater, usersDao.findOneUserByUsername(currentUsername).getUserid());

		allTutorialsBeetwenGivenDates.forEach(tutorial -> {
			DateTime tutorialEndDateJodaVar = new DateTime(tutorial.getEndDateToDo());
			DateTime today = DateTime.now();

			Days days = Days.daysBetween(today.minusDays(1), tutorialEndDateJodaVar.plusDays(1));
			Integer daysLeft = Optional.of(days.getDays()).filter(d -> d > 0).orElse(0);

			tutorial.setDaysLeft(new Long(daysLeft));
		});

		return allTutorialsBeetwenGivenDates;
	}

	@Transactional
	public void editTutorialByPostReq(Map<String, String> reqParamsMap) {

		String idFromReq = reqParamsMap.get("id");

		Tutorial tutorialToEdit = tutorialsDao.findOne(Long.parseLong(idFromReq));

		// BASIC DATA
		tutorialToEdit.setAuthor(reqParamsMap.get("author"));
		tutorialToEdit.setTitle(reqParamsMap.get("title"));
		tutorialToEdit.setUrl(reqParamsMap.get("url"));

		Optional.ofNullable(reqParamsMap.get("url")).filter(url -> StringUtils.isNoneBlank(url)).ifPresent(url -> {
			String serviceWebAddres = TutorialsServiceHelper.extractDomainAddresFromFullUrl(reqParamsMap.get("url"));
			tutorialToEdit.setServiceDomain(serviceWebAddres);
		});

		// WHEN TO DO
		String startDateToDoStr = reqParamsMap.get("startDateToDo");
		Date start = TutorialsServiceHelper.prepareStartDateToDo(startDateToDoStr);
		String endDateToDoStr = reqParamsMap.get("endDateToDo");
		Date endDate = TutorialsServiceHelper.prepareEndDateToDo(endDateToDoStr);

		tutorialToEdit.setStartDateToDo(start);
		tutorialToEdit.setEndDateToDo(endDate);

		Category cat = categoriesService.getOneById(Long.parseLong(reqParamsMap.get("categoryId")));
		tutorialToEdit.setTutorialCategory(cat);

		// SAVE OR UPDATE
		tutorialsDao.saveOrUpdate(tutorialToEdit);

	}

	@Transactional
	public void saveNewTutorialByPostReq(Map<String, String> reqParamsMap, Principal principal) {

		Tutorial newTutorial = new Tutorial();
		String videoLink = reqParamsMap.get("url");

		NoEmbedApiResponse videoData = noEmbedApi.getDataByLink(videoLink);

		if (StringUtils.isBlank(videoData.getError())) {
			newTutorial.setAuthor(videoData.getAuthorName());
			newTutorial.setTitle(videoData.getTitle());
			newTutorial.setUrl(videoData.getUrl());
			newTutorial.setServiceDomain(videoData.getProviderUrl());
		}

		newTutorial.setRating(ratingStarVal);
		newTutorial.setProgress(progressStartVal);
		newTutorial.setUserId(usersDao.findOneUserByUsername(principal.getName()).getUserid());

		// WHEN TO DO
		Date start = TutorialsServiceHelper.prepareStartDateToDo(reqParamsMap.get("startDateToDo"));
		Date endDate = TutorialsServiceHelper.prepareEndDateToDo(reqParamsMap.get("endDateToDo"));

		newTutorial.setStartDateToDo(start);
		newTutorial.setEndDateToDo(endDate);

		Category cat = categoriesService.getOneById(Long.parseLong(reqParamsMap.get("categoryId")));
		cat.getTutorials().add(newTutorial);
		newTutorial.setTutorialCategory(cat);

		// SAVE OR UPDATE
		tutorialsDao.saveOrUpdate(newTutorial);
	}

}
