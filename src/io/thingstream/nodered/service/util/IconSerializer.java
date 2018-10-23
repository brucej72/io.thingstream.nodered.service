package io.thingstream.nodered.service.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.thingstream.nodered.service.NodeDefinition;

public class IconSerializer extends JsonSerializer<NodeDefinition.Icon> {
	
	private static final String[] defaultIcons  = {
		"alert.png",
		"arrow-in.png",
		"bridge-dash.png",
		"bridge.png",
		"db.png",
		"debug.png",
		"envelope.png",
		"feed.png",
		"file.png",
		"function.png",
		"hash.png",
		"inject.png",
		"light.png",
		"serial.png",
		"template.png",
		"white-globe.png"
	};
	
	public void serialize(NodeDefinition.Icon in, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		
		if(in == NodeDefinition.Icon.custom) {}
		jgen.writeObject(defaultIcons[in.ordinal()]);
		
	}
	
}
