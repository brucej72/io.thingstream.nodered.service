package io.thingstream.nodered.service.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LabelSerializer extends JsonSerializer<String> {
	
	private static final String TEMPLATE = "function() {return this.name||\"%s\";}";

	public void serialize(String in, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		String s = String.format(TEMPLATE, in);
		jgen.writeRawValue(s);
		
	}
	
}
