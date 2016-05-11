package org.kuzdowicz.repoapps.tutorials.service;

import java.util.List;

import org.kuzdowicz.repoapps.tutorials.dao.TutorialsCategoriesDao;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.UserTutorialsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialsCategoriesService {

	private TutorialsCategoriesDao tutorialsCategoriesDao;
	
	private UsersDao usersDao;

	@Autowired
	public TutorialsCategoriesService(TutorialsCategoriesDao tutorialsCategoriesDao, UsersDao usersDao) {
		this.tutorialsCategoriesDao = tutorialsCategoriesDao;
		this.usersDao = usersDao;
	}

	public List<UserTutorialsCategory> selectAll() {
		return tutorialsCategoriesDao.getAllCategories();
	}

	public UserTutorialsCategory getOneByName(String categoryName) {
		return tutorialsCategoriesDao.getOneById(categoryName);
	}


	public void insertOrUpdate(UserTutorialsCategory category) {
		tutorialsCategoriesDao.saveOrUpdateTutorialCategory(category);
	}

	public void removeOneByPk(String categoryPK) {
		UserTutorialsCategory tutorialToRemove = tutorialsCategoriesDao.getOneById(categoryPK);
		if (tutorialsCategoriesDao != null) {
			tutorialsCategoriesDao.deleteTutorialCategory(tutorialToRemove);
		}
	}
	
	public List<String> getUserCategoriesNames(String username){
		Long userid = usersDao.findOneUserByUsername(username).getUserid();
		return tutorialsCategoriesDao.getAllUserCategoriesNames(userid);
	}

	public void insertOrUpdateWithGivenName(String categoryName) {
		UserTutorialsCategory category = getOneByName(categoryName);
		if (category == null) {
			category = new UserTutorialsCategory();
			category.setCategoryName(categoryName);
			insertOrUpdate(category);
		}
	}

}
