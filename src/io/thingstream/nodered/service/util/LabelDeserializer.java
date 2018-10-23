package io.thingstream.nodered.service.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class LabelDeserializer extends JsonDeserializer<String> {

	public String deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
		
		return "";
		
	}

}
