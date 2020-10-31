package com.springmvc.firebase.model;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class TraverseGraphDataPojo {

	public Set<String> keySet;
	public String valueSet;
	
	public TraverseGraphDataPojo() {

	}

	public TraverseGraphDataPojo(Set<String> keySet, String valueSet) {
		super();
		this.keySet = keySet;
		this.valueSet = valueSet;
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

	
	@Override
	public String toString() {
		return "GraphDataPojo [valueSet=" + valueSet + "]";
	}
}
