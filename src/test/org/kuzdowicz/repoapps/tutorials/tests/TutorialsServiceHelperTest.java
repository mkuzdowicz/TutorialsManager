package org.kuzdowicz.repoapps.tutorials.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;
import org.kuzdowicz.repoapps.tutorials.constants.AppFromatters;
import org.kuzdowicz.repoapps.tutorials.services.TutorialsServiceHelper;

public class TutorialsServiceHelperTest {

	@Test
	public void extractDomainAddresFromFullUrlMethodTest1() {

		String url = "https://www.youtube.com/watch?v=_H0h4QXjAOw";

		String extractedDomain = TutorialsServiceHelper.extractDomainAddresFromFullUrl(url);

		String expectedResult = "www.youtube.com";

		assertThat(extractedDomain, equalTo(expectedResult));

	}

	@Test
	public void extractDomainAddresFromFullUrlMethodTest2() {

		String url = "https://code.google.com/archive/p/hamcrest/wikis/Tutorial.wiki";

		String extractedDomain = TutorialsServiceHelper.extractDomainAddresFromFullUrl(url);

		String expectedResult = "code.google.com";

		assertThat(extractedDomain, equalTo(expectedResult));

	}

	@Test
	public void prepareStartDateToDoTest1() {

		String input = "";

		Date startDateToDoResult = TutorialsServiceHelper.prepareStartDateToDo(input);

		String defaultStartDate = DateTime.now().toString(AppFromatters.DATE_TIME_FORMATTER);
		Date expectedResult = AppFromatters.DATE_TIME_FORMATTER.parseDateTime(defaultStartDate).toDate();

		assertThat(startDateToDoResult, equalTo(expectedResult));

	}

	@Test
	public void prepareStartDateToDoTest2() {

		String input = "01-01-2016";

		Date startDateToDoResult = TutorialsServiceHelper.prepareStartDateToDo(input);

		Date expectedResult = AppFromatters.DATE_TIME_FORMATTER.parseDateTime("01-01-2016").toDate();

		assertThat(startDateToDoResult, equalTo(expectedResult));

	}

	@Test
	public void prepareEndDateToDoTest1() {

		String input = "";

		Date startDateToDoResult = TutorialsServiceHelper.prepareEndDateToDo(input);

		String defaultEndDateToDo = DateTime.now().plusWeeks(1).toString(AppFromatters.DATE_TIME_FORMATTER);
		Date expectedResult = AppFromatters.DATE_TIME_FORMATTER.parseDateTime(defaultEndDateToDo).toDate();

		assertThat(startDateToDoResult, equalTo(expectedResult));

	}

	@Test
	public void prepareEndDateToDoTest2() {

		String input = "08-01-2016";

		Date endDateToDoResult = TutorialsServiceHelper.prepareEndDateToDo(input);

		Date expectedResult = AppFromatters.DATE_TIME_FORMATTER.parseDateTime("08-01-2016").toDate();

		assertThat(endDateToDoResult, equalTo(expectedResult));

	}

}
