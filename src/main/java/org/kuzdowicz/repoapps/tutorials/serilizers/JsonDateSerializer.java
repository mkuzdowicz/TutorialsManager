package org.kuzdowicz.repoapps.tutorials.serilizers;

import java.io.IOException;
import java.util.Date;

import org.joda.time.DateTime;
import org.kuzdowicz.repoapps.tutorials.constants.AppFromatters;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@Component
public class JsonDateSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator generator, SerializerProvider provider)
			throws IOException, JsonProcessingException {

		String formattedDate = AppFromatters.DATE_TIME_FORMATTER.print(new DateTime(date));

		generator.writeString(formattedDate);

	}

}
