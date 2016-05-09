package org.kuzdowicz.repoapps.tutorials.service;

import java.util.ArrayList;

import org.joda.time.DateTime;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsCategoriesDao;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsDao;
import org.kuzdowicz.repoapps.tutorials.dao.UsersDao;
import org.kuzdowicz.repoapps.tutorials.models.AppUser;
import org.kuzdowicz.repoapps.tutorials.models.UserTutorial;
import org.kuzdowicz.repoapps.tutorials.models.UserTutorialsCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitStartDataForTestService {

	private TutorialsCategoriesDao tutorialsCategoriesDao;

	private TutorialsDao tutorialsDao;

	private UsersDao usersDao;

	@Autowired
	public InitStartDataForTestService(TutorialsCategoriesDao tutorialsCategoriesDao, TutorialsDao tutorialsDao,
			UsersDao usersDao) {
		this.tutorialsCategoriesDao = tutorialsCategoriesDao;
		this.tutorialsDao = tutorialsDao;
		this.usersDao = usersDao;
	}

	public void initSomeData() {

		// USERS
		AppUser user = new AppUser();
		user.setUsername("user");
		user.setPassword("$2a$10$Q.1ZPyA01dhdglv8PjjReOP.4DKAAd5JTUobIlsjnh7dRzfrwq.Uu");
		user.setType("ROLE_USER");
		user.setEmail("user@user");

		AppUser admin = new AppUser();
		admin.setUsername("admin");
		admin.setPassword("$2a$10$2MLaGiTNvYLBHoKaRGbIy.AFoPBB03uyKmby.xupUoifICoFhjIFq");
		admin.setType("ROLE_USER");
		admin.setEmail("admin@admin");

		usersDao.saveOrUpdateUser(user);
		usersDao.saveOrUpdateUser(admin);

		UserTutorial tut1 = new UserTutorial();
		tut1.setAuthor("JavaBrains");
		tut1.setTitle("hibernate tutorial");
		tut1.setUrl("https://www.youtube.com/watch?v=Yv2xctJxE-w&list=PL4AFF701184976B25");
		tut1.setServiceDomain("youtube");
		tut1.setRating(3L);
		tut1.setProgress(0);
		tut1.setStartDateToDo(DateTime.now().toDate());
		tut1.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut1.setUserId(admin.getUserid());

		tutorialsDao.saveOrUpdateTutorial(tut1);

		UserTutorial tut2 = new UserTutorial();
		tut2.setAuthor("Artur Owczarek");
		tut2.setTitle("Jpa Kurs");
		tut2.setUrl("https://www.youtube.com/watch?v=bUpOL_b7g6k&index=23&list=PLU2dl_1LV_SQWZI2R_RSEeYm1tfueszOc");
		tut2.setServiceDomain("youtube");
		tut2.setRating(4L);
		tut2.setProgress(0);
		tut2.setStartDateToDo(DateTime.now().toDate());
		tut2.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut2.setUserId(admin.getUserid());

		tutorialsDao.saveOrUpdateTutorial(tut2);

		UserTutorial tut3 = new UserTutorial();
		tut3.setAuthor("Mykong");
		tut3.setTitle("Spring MVC tutorial");
		tut3.setUrl("http://www.mkyong.com/spring3/spring-3-mvc-hello-world-example-annotation/");
		tut3.setServiceDomain("www.mkyong.com");
		tut3.setRating(5L);
		tut3.setProgress(0);
		tut3.setStartDateToDo(DateTime.now().toDate());
		tut3.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut3.setUserId(admin.getUserid());

		tutorialsDao.saveOrUpdateTutorial(tut3);

		UserTutorialsCategory cat1 = new UserTutorialsCategory();
		cat1.setCategoryName("Java");

		cat1.setTutorials(new ArrayList<>());
		cat1.getTutorials().add(tut1);
		cat1.getTutorials().add(tut2);
		cat1.getTutorials().add(tut3);
		cat1.setUserId(tut1.getUserId());

		tutorialsCategoriesDao.saveOrUpdateTutorialCategory(cat1);

		UserTutorialsCategory cat2 = new UserTutorialsCategory();
		cat2.setCategoryName("asp");

		cat2.setTutorials(new ArrayList<>());

		UserTutorial tut4 = new UserTutorial();
		tut4.setAuthor("MSDN");
		tut4.setTitle("c# tutorial");
		tut4.setUrl("https://msdn.microsoft.com/en-us/library/aa288436(v=vs.71).aspx");
		tut4.setServiceDomain("msdn.microsoft");
		tut4.setRating(5L);
		tut4.setStartDateToDo(DateTime.now().toDate());
		tut4.setEndDateToDo(DateTime.now().plusWeeks(1).toDate());
		tut4.setProgress(0);
		tut4.setUserId(user.getUserid());

		tutorialsDao.saveOrUpdateTutorial(tut4);

		cat2.getTutorials().add(tut4);
		cat2.setUserId(tut4.getUserId());

		tutorialsCategoriesDao.saveOrUpdateTutorialCategory(cat2);

	}

}
