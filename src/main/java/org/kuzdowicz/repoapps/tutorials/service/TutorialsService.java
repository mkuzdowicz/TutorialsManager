package org.kuzdowicz.repoapps.tutorials.service;

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
import org.kuzdowicz.repoapps.tutorials.models.UserTutorial;
import org.kuzdowicz.repoapps.tutorials.models.UserTutorialsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Range;

@Service
public class TutorialsService {

	private TutorialsDao tutorialsDao;

	private TutorialsCategoriesService tutorialsCategoriesService;

	private UsersDao usersDao;

	@Autowired
	public TutorialsService(TutorialsDao tutorialsDao, TutorialsCategoriesService tutorialsCategoriesService,
			UsersDao usersDao) {
		this.tutorialsDao = tutorialsDao;
		this.tutorialsCategoriesService = tutorialsCategoriesService;
		this.usersDao = usersDao;
	}

	private final static Range<Integer> rangeForProgressIncrementation = Range.closed(0, 95);

	private final static Range<Integer> rangeForProgressDecrementation = Range.closed(5, 100);

	private final static Long ratingStarVal = 0L;

	private final static Integer progressStartVal = 0;

	public List<UserTutorial> selectAll() {

		return tutorialsDao.getAllTutorials();

	}

	public UserTutorial getOneById(Long id) {

		return tutorialsDao.getOneById(id);

	}

	public void removeOneById(Long id) {

		tutorialsDao.deleteTutorial(getOneById(id));

	}

	public UserTutorial incremetRatingAndReturnChangedObject(Long pk) {

		UserTutorial tutorial = getOneById(pk);
		Long actualRating = tutorial.getRating();

		Optional.of(actualRating).filter(val -> val < Long.MAX_VALUE).ifPresent(presentVal -> {

			presentVal++;
			tutorial.setRating(presentVal);
			tutorialsDao.saveOrUpdateTutorial(tutorial);

		});

		return tutorial;

	}

	public UserTutorial decrementRatingAndReturnChangedObject(Long pk) {

		UserTutorial tutorial = getOneById(pk);
		Long actualRating = tutorial.getRating();

		Optional.of(actualRating).filter(val -> val > 0).ifPresent(presentVal -> {

			presentVal--;
			tutorial.setRating(presentVal);
			tutorialsDao.saveOrUpdateTutorial(tutorial);

		});

		return tutorial;

	}

	public UserTutorial incremetTutorialProgressAndReturnChangedObject(Long pk) {

		UserTutorial tutorial = getOneById(pk);
		Integer actualProgress = tutorial.getProgress();

		Optional.of(actualProgress).filter(val -> rangeForProgressIncrementation.contains(val))
				.ifPresent(presentValue -> {

					presentValue += 5;
					tutorial.setProgress(presentValue);
					tutorialsDao.saveOrUpdateTutorial(tutorial);

				});

		return tutorial;

	}

	public UserTutorial decremetTutorialProgressAndReturnChangedObject(Long pk) {

		UserTutorial tutorial = getOneById(pk);
		Integer actualProgress = tutorial.getProgress();

		Optional.of(actualProgress).filter(val -> rangeForProgressDecrementation.contains(val))
				.ifPresent(presentValue -> {

					presentValue -= 5;
					tutorial.setProgress(presentValue);
					tutorialsDao.saveOrUpdateTutorial(tutorial);

				});

		return tutorial;

	}

	public List<UserTutorial> getTutorialsToDoForCurrentWeekWithDaysLeftFiled() {

		Date firstDayOfCurrentWeek = DateTime.now().withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date weekLater = DateTime.now().plusWeeks(1).toDate();

		List<UserTutorial> allTutorialsBeetwenGivenDates = tutorialsDao
				.getAllTutorialsBeetwenGivenDates(firstDayOfCurrentWeek, weekLater);

		allTutorialsBeetwenGivenDates.forEach(tutorial -> {

			DateTime tutorialEndDateJodaVar = new DateTime(tutorial.getEndDateToDo());
			DateTime today = DateTime.now();

			// MINUS 1 DAY FROM TODAY AND PLUS 1 DAY TO END DATE
			// BEACOUSE THIS IS 2 DAYS OF DIFERENCE
			// JODA FUNCTION RETURN DAYS BEETWEN EXLUDE GIVEN DAYS

			Days days = Days.daysBetween(today.minusDays(1), tutorialEndDateJodaVar.plusDays(1));

			Integer daysLeft = Optional.of(days.getDays()).filter(d -> d > 0).orElse(0);

			tutorial.setDaysLeft(new Long(daysLeft));

		});

		return allTutorialsBeetwenGivenDates;
	}

	public List<UserTutorial> getUserTutorialsToDoForCurrentWeekWithDaysLeftFiled(String currentUsername) {

		Date firstDayOfCurrentWeek = DateTime.now().withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date weekLater = DateTime.now().plusWeeks(1).toDate();

		List<UserTutorial> allTutorialsBeetwenGivenDates = tutorialsDao.getAllTutorialsBeetwenGivenDatesAndUserId(
				firstDayOfCurrentWeek, weekLater, usersDao.findOneUserByUsername(currentUsername).getUserid());

		allTutorialsBeetwenGivenDates.forEach(tutorial -> {

			DateTime tutorialEndDateJodaVar = new DateTime(tutorial.getEndDateToDo());
			DateTime today = DateTime.now();

			// MINUS 1 DAY FROM TODAY AND PLUS 1 DAY TO END DATE
			// BEACOUSE THIS IS 2 DAYS OF DIFERENCE
			// JODA FUNCTION RETURN DAYS BEETWEN EXLUDE GIVEN DAYS

			Days days = Days.daysBetween(today.minusDays(1), tutorialEndDateJodaVar.plusDays(1));

			Integer daysLeft = Optional.of(days.getDays()).filter(d -> d > 0).orElse(0);

			tutorial.setDaysLeft(new Long(daysLeft));

		});

		return allTutorialsBeetwenGivenDates;
	}

	public void editTutorialByPostReq(Map<String, String> reqParamsMap) {

		String idFromReq = reqParamsMap.get("id");

		UserTutorial tutorialToEdit = tutorialsDao.getOneById(Long.parseLong(idFromReq));

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

		UserTutorialsCategory cat = tutorialsCategoriesService.getOneByName(reqParamsMap.get("category"));

		tutorialToEdit.setTutorialCategory(cat);

		// SAVE OR UPDATE
		tutorialsDao.saveOrUpdateTutorial(tutorialToEdit);

	}

	public void saveNewTutorialByPostReq(Map<String, String> reqParamsMap) {

		UserTutorial newTutorial = new UserTutorial();

		// BASIC DATA
		newTutorial.setAuthor(reqParamsMap.get("author"));
		newTutorial.setTitle(reqParamsMap.get("title"));
		newTutorial.setUrl(reqParamsMap.get("url"));

		newTutorial.setRating(ratingStarVal);
		newTutorial.setProgress(progressStartVal);

		Optional.ofNullable(reqParamsMap.get("url")).filter(url -> StringUtils.isNoneBlank(url)).ifPresent(url -> {

			String serviceWebAddres = TutorialsServiceHelper.extractDomainAddresFromFullUrl(reqParamsMap.get("url"));
			newTutorial.setServiceDomain(serviceWebAddres);

		});

		// WHEN TO DO
		Date start = TutorialsServiceHelper.prepareStartDateToDo(reqParamsMap.get("startDateToDo"));
		Date endDate = TutorialsServiceHelper.prepareEndDateToDo(reqParamsMap.get("endDateToDo"));

		newTutorial.setStartDateToDo(start);
		newTutorial.setEndDateToDo(endDate);

		UserTutorialsCategory cat = tutorialsCategoriesService.getOneByName(reqParamsMap.get("category"));

		Optional.ofNullable(cat).ifPresent(c -> {
			c.getTutorials().add(newTutorial);
			newTutorial.setTutorialCategory(c);
		});

		// SAVE OR UPDATE
		tutorialsDao.saveOrUpdateTutorial(newTutorial);
	}

}
