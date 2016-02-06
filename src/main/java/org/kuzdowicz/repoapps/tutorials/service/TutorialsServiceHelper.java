package org.kuzdowicz.repoapps.tutorials.service;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.kuzdowicz.repoapps.tutorials.constants.AppFromatters;

public class TutorialsServiceHelper {

	public static String extractDomainAddresFromFullUrl(String urlStr) {
		String urlStrSanitized = urlStr.replace("http://", "").replace("https://", "");

		int beginIndex = urlStrSanitized.indexOf("www");

		if (beginIndex == -1) {
			beginIndex = 0;
		}

		return urlStrSanitized.substring(beginIndex, urlStrSanitized.indexOf("/", beginIndex));
	}

	public static Date prepareStartDateToDo(String startDateStr) {

		// DEFAULT TODAY
		String defaultStartDate = DateTime.now().toString(AppFromatters.DATE_TIME_FORMATTER);

		String startDateToDoStrSanitized = Optional.ofNullable(startDateStr)
				.filter(startDate -> StringUtils.isNoneBlank(startDate)).orElse(defaultStartDate);

		Date start = AppFromatters.DATE_TIME_FORMATTER.parseDateTime(startDateToDoStrSanitized).toDate();

		return start;

	}

	public static Date prepareEndDateToDo(String endDateStr) {

		// DEFALUT PLUS ONE WEEK
		String defaultEndDateToDo = DateTime.now().plusWeeks(1).toString(AppFromatters.DATE_TIME_FORMATTER);

		String endDateToDoStrSanitized = Optional.ofNullable(endDateStr)
				.filter(endDate -> StringUtils.isNoneBlank(endDate)).orElse(defaultEndDateToDo);

		Date end = AppFromatters.DATE_TIME_FORMATTER.parseDateTime(endDateToDoStrSanitized).toDate();

		return end;

	}

}
