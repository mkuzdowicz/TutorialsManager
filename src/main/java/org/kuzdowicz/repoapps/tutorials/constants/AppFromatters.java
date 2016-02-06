package org.kuzdowicz.repoapps.tutorials.constants;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class AppFromatters {

	public final static String INPUT_DATE_FORMAT = "dd-MM-yyyy";
	public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern(INPUT_DATE_FORMAT);

}
