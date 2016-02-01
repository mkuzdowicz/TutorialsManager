package org.kuzdowicz.repoapps.tutorials.service;

import java.util.ArrayList;

import org.kuzdowicz.repoapps.tutorials.dao.TutorialsCategoriesDao;
import org.kuzdowicz.repoapps.tutorials.dao.TutorialsDao;
import org.kuzdowicz.repoapps.tutorials.model.Tutorial;
import org.kuzdowicz.repoapps.tutorials.model.TutorialCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitForTestService {

	@Autowired
	private TutorialsCategoriesDao tutorialsCategoriesDao;

	@Autowired
	private TutorialsDao tutorialsDao;

	public void initSomeData() {

		Tutorial tut1 = new Tutorial();
		tut1.setAuthor("JavaBrains");
		tut1.setTitle("hibernate tutorial");
		tut1.setUrl("https://www.youtube.com/watch?v=Yv2xctJxE-w&list=PL4AFF701184976B25");
		tut1.setServiceDomain("youtube");
		tut1.setRating(3L);
		tut1.setReworkedInPercents(0);

		tutorialsDao.saveOrUpdateTutorial(tut1);

		Tutorial tut2 = new Tutorial();
		tut2.setAuthor("Artur Owczarek");
		tut2.setTitle("Jpa Kurs");
		tut2.setUrl("https://www.youtube.com/watch?v=bUpOL_b7g6k&index=23&list=PLU2dl_1LV_SQWZI2R_RSEeYm1tfueszOc");
		tut2.setServiceDomain("youtube");
		tut2.setRating(4L);
		tut2.setReworkedInPercents(0);

		tutorialsDao.saveOrUpdateTutorial(tut2);

		Tutorial tut3 = new Tutorial();
		tut3.setAuthor("Mykong");
		tut3.setTitle("Spring MVC tutorial");
		tut3.setUrl("http://www.mkyong.com/spring3/spring-3-mvc-hello-world-example-annotation/");
		tut3.setServiceDomain("www.mkyong.com");
		tut3.setRating(5L);
		tut3.setReworkedInPercents(0);

		tutorialsDao.saveOrUpdateTutorial(tut3);

		TutorialCategory cat1 = new TutorialCategory();
		cat1.setCategoryName("Java");

		cat1.setTutorials(new ArrayList<>());
		cat1.getTutorials().add(tut1);
		cat1.getTutorials().add(tut2);
		cat1.getTutorials().add(tut3);

		tutorialsCategoriesDao.saveOrUpdateTutorialCategory(cat1);

		TutorialCategory cat2 = new TutorialCategory();
		cat2.setCategoryName("asp");

		cat2.setTutorials(new ArrayList<>());

		Tutorial tut4 = new Tutorial();
		tut4.setAuthor("MSDN");
		tut4.setTitle("c# tutorial");
		tut4.setUrl("https://msdn.microsoft.com/en-us/library/aa288436(v=vs.71).aspx");
		tut4.setServiceDomain("msdn.microsoft");
		tut4.setRating(5L);

		tutorialsDao.saveOrUpdateTutorial(tut4);

		cat2.getTutorials().add(tut4);

		tutorialsCategoriesDao.saveOrUpdateTutorialCategory(cat2);

	}

}
