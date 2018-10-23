package io.thingstream.nodered.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.thingstream.nodered.service.util.IconSerializer;
import io.thingstream.nodered.service.util.LabelDeserializer;
import io.thingstream.nodered.service.util.LabelSerializer;

@JsonInclude(Include.NON_NULL)
public class NodeDefinition {
	
	public enum Icon {
		
		alert,
		arrow_in,
		bridge_dash,
		bridge,
		db,
		debug,
		envelope,
		feed,
		file,
		function,
		hash,
		inject,
		light,
		serial,
		template,
		white_globe,
		custom
		
	}
	
	/**
	
	From the Node-red documentation https://nodered.org/docs/creating-nodes/node-html
	
	category: (string) the palette category the node appears in
	defaults: (object) the editable properties for the node.
	credentials: (object) the credential properties for the node.
	inputs: (number) how many inputs the node has, either 0 or 1.
	outputs: (number) how many outputs the node has. Can be 0 or more.
	color: (string) the background colour to use.
	paletteLabel: (string|function) the label to use in the palette.
	label: (string|function) the label to use in the workspace.
	labelStyle: (string|function) the style to apply to the label.
	inputLabels: (string|function) optional label to add on hover to the input port of a node.
	outputLabels: (string|function) optional labels to add on hover to the output ports of a node.
	icon: (string) the icon to use.
	align: (string) the alignment of the icon and label.
	
	**/
	
	public static final String ALIGN_LEFT = "left";
	public static final String ALIGN_RIGHT = "right";
	
	public static final String CATEGORY_FUNCTION = "function";
	public static final String CATEGORY_INPUT = "input";
	public static final String CATEGORY_OUTPUT = "output";
	public static final String CATEGORY_SOCIAL = "social";
	public static final String CATEGORY_STORAGE = "storage";
	public static final String CATEGORY_CONFIG = "config";
	
//	@JsonIgnore
//	private String type;
	@JsonIgnore
	private String name;
	private String category;
	private Map<String, NodeDefaults> defaults;
	private NodeCredentials credentials;
	private int inputs;
	private int outputs;
	private String color;
	private String paletteLabel; // note: only allowing String for now
	@JsonSerialize(using = LabelSerializer.class, as=String.class)
	@JsonDeserialize(using = LabelDeserializer.class)
	private String label;
	private String labelStyle;
	private String[] inputLabels;
	private String[] outputLabels;
	@JsonSerialize(using = IconSerializer.class)
	private Icon icon;
	private URL customIconUrl;
	private String align;
	@JsonIgnore
	private String helpText;
	@JsonIgnore
	private String version;
	
	private static final String DEFAULT_LABEL = "mynode";
		
	public NodeDefinition() {
		
		category = CATEGORY_FUNCTION;
		defaults = new LinkedHashMap<String, NodeDefaults>();
		defaults.put("name", new NodeDefaults("Name"));
		inputs = 1;
		outputs = 1;
		color = "#dac4b4";
		label = DEFAULT_LABEL;
		icon = Icon.function;
		align = ALIGN_LEFT;
		version = "0.0.1";
		
	}
	
	public NodeDefinition(String category) {
		
		this();
		this.category = category;
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public NodeDefinition addDefaults(String name, NodeDefaults defaults) {
		
		this.defaults.put(name, defaults);
		return this;
		
	}
	
	public NodeDefaults getNodeDefaults(String name) {
		
		return this.defaults.get(name);
		
	}
	
	public NodeDefinition removeDefaults(String name) {
		
		this.defaults.remove(name);
		return this;
		
	}

	public Map<String, NodeDefaults> getDefaults() {
		return defaults;
	}

	public void setDefaults(Map<String, NodeDefaults> defaults) {
		this.defaults = defaults;
	}	

	public NodeCredentials getCredentials() {
		return credentials;
	}

	public void setCredentials(NodeCredentials credentials) {
		this.credentials = credentials;
	}

	public int getInputs() {
		return inputs;
	}

	public void setInputs(int inputs) {
		this.inputs = inputs;
	}

	public int getOutputs() {
		return outputs;
	}

	public void setOutputs(int outputs) {
		this.outputs = outputs;
		if(outputs == 0) {
			
			this.setAlign(ALIGN_RIGHT);
			
		}
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPaletteLabel() {
		return paletteLabel;
	}

	public void setPaletteLabel(String paletteLabel) {
		this.paletteLabel = paletteLabel;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelStyle() {
		return labelStyle;
	}

	public void setLabelStyle(String labelStyle) {
		this.labelStyle = labelStyle;
	}

	public String[] getInputLabels() {
		return inputLabels;
	}

	public void setInputLabels(String[] inputLabels) {
		this.inputLabels = inputLabels;
	}

	public String[] getOutputLabels() {
		return outputLabels;
	}

	public void setOutputLabels(String[] outputLabels) {
		this.outputLabels = outputLabels;
	}

	public NodeDefinition.Icon getIcon() {
		return icon;
	}

	public void setIcon(NodeDefinition.Icon icon) {
		this.icon = icon;
	}

	public URL getCustomIconUrl() {
		return customIconUrl;
	}

	public void setCustomIconUrl(URL customIconUrl) {
		this.customIconUrl = customIconUrl;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

//	public String getType() {
////		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	public static NodeDefinition fromStream(InputStream is) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(is, NodeDefinition.class);
		
	}
	
	public static void toStream(OutputStream os, NodeDefinition nd) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(os, nd);
		
	}

}
