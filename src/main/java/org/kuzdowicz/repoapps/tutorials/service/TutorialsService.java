package org.kuzdowicz.repoapps.tutorials.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsDao;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.kuzdowicz.repoapps.tutorials.model.TutorialCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialsService {

	@Autowired
	private TutorialsDao tutorialsDao;

	@Autowired
	private TutorialsCategoriesService tutorialsCategoriesService;

	public List<Tutorial> selectAll() {

		return tutorialsDao.getAllTutorials();

	}

	public void addTutorialByPostReq(Map<String, String> reqParamsMap) {

		String categoryName = reqParamsMap.get("category");

		Tutorial newTutorial = new Tutorial();
		newTutorial.setAuthor(reqParamsMap.get("author"));
		newTutorial.setTitle(reqParamsMap.get("title"));
		newTutorial.setUrl(reqParamsMap.get("url"));
		newTutorial.setUrl(reqParamsMap.get("serviceDomain"));

		String rating = reqParamsMap.get("rating");
		if (StringUtils.isNoneBlank(rating)) {
			newTutorial.setRating(Long.parseLong(rating));
		}

		String reworkedInPercents = reqParamsMap.get("reworkedInPercents");
		if (StringUtils.isNoneBlank(reworkedInPercents)) {
			newTutorial.setReworkedInPercents(Integer.parseInt(reworkedInPercents));
		}

		tutorialsDao.saveOrUpdateTutorial(newTutorial);

		TutorialCategory cat = tutorialsCategoriesService.getOneByName(categoryName);
		if (cat == null) {
			cat = new TutorialCategory();
			cat.setCategoryName(categoryName);
			cat.setTutorials(new ArrayList<>());
			cat.getTutorials().add(newTutorial);

		} else {
			cat.getTutorials().add(newTutorial);
		}

		tutorialsCategoriesService.insertOrUpdate(cat);

	}

}
