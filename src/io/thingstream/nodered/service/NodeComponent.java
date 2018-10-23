package io.thingstream.nodered.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeComponent {
	
	public static final String COMPONENT_DESCRIPTION = "node.component.description";
			
	// configuration properties
	
	public NodeDefinition getDefinition();
	
	// lifecycle
	
	public void onCreate(String nodeId, JsonNode config);
			
	public void onClose(String nodeId);
	
	// runtime
		
	public JsonNode[] onMessage(String nodeId, JsonNode msg);

}
