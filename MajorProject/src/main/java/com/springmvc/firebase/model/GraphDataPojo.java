package com.springmvc.firebase.model;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class GraphDataPojo {
	
	public String keyName;
	public Object value;
	public Set<String> keySet;
	public String valueSet;
	
	@Override
	public String toString() {
		return "GraphDataPojo [valueSet=" + valueSet + "]";
	}
	
	public GraphDataPojo() {
		
	}
	
	public GraphDataPojo(String keyName, Object value, Set<String> keySet, String valueSet) {
		super();
		this.keyName = keyName;
		this.value = value;
		this.keySet = keySet;
		this.valueSet = valueSet;
	}
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Set<String> getKeySet() {
		return keySet;
	}
	public void setKeySet(Set<String> keySet) {
		this.keySet = keySet;
	}
	public String getValueSet() {
		return valueSet;
	}
	public void setValueSet(String valueSet) {
		this.valueSet = valueSet;
	}
	

}
