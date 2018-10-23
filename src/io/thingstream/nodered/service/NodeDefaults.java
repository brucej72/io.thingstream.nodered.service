package io.thingstream.nodered.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class NodeDefaults {
	
	public enum EditDialogType {
		
		text,
		checkbox,
		select
		
	}

	
	/**
	
	From the Node-red documentation https://nodered.org/docs/creating-nodes/properties
	
	The entries in the defaults array can have the following attributes:

	value : (any type) the default value the property takes
	required : (boolean) optional whether the property is required. If set to true, the property will be invalid if its value is null or an empty string.
	validate : (function) optional a function that can be used to validate the value of the property.
	type : (string) optional if this property is a pointer to a configuration node, this identifies the type of the node.

	 **/
	
	private Object value;
	private boolean required;
	// validate is postponed for now
	private String type;
	@JsonIgnore
	private EditDialogType editDialogType;
	@JsonIgnore
	private String[] selectOptions;
	@JsonIgnore 
	private String editDialogLabel;
	
	public NodeDefaults() {
		
		value = new String("");
		required = false;
		editDialogType = EditDialogType.text;
		
	}
	
	public NodeDefaults(String label) {
		
		this();
		this.setEditDialogLabel(label);
		
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EditDialogType getEditDialogType() {
		return editDialogType;
	}

	public void setEditDialogType(EditDialogType editDialogType) {
		this.editDialogType = editDialogType;
	}

	public String[] getSelectOptions() {
		return selectOptions;
	}

	public void setSelectOptions(String[] selectOptions) {
		this.selectOptions = selectOptions;
	}

	public String getEditDialogLabel() {
		return editDialogLabel;
	}

	public void setEditDialogLabel(String editDialogLabel) {
		this.editDialogLabel = editDialogLabel;
	}


}
