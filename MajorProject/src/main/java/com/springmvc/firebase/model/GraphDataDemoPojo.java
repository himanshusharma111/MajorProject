package com.springmvc.firebase.model;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class GraphDataDemoPojo 
{
	
	public String keyName;
	public Object value;
	public Set<String> keySet;
	public String valueSet;

	

	@Override
	public String toString() {
		return "GraphDataPojo [valueSet=" + valueSet + "]";
	}

	public GraphDataDemoPojo() {
		
	}

	public GraphDataDemoPojo(String keyName, Object value, Set<String> keySet, String valueSet) {
		super();
		this.keyName = keyName;
		this.value = value;
		this.keySet = keySet;
		this.valueSet = valueSet;
	}
	
	
	public Object getValue() {
		return value;
	}
	
	public Object getValueSet() {
		return valueSet;
	}

	public void setValueSet(String object) {
		this.valueSet = object;
	}

	public Object getKeySet() {
		return keySet;
	}

	public void setKeySet(Set<String> set) {
		this.keySet = set;
	}



	public void setValue(Object value) {
		this.value = value;
	}


	// String
	public String getKeyName() {
		return keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	// List
//	public List<String> getKey() {
//		return key;
//	}
//	public void setKey(List<String> key) {
//		this.key = key;
//	}
//	public List<Object> getValue() {
//		return Value;
//	}
//	@SuppressWarnings("unchecked")
//	public void setValue(Object object) {
//		Value =  (List<Object>) object;
//	}
//	
	
	
	
	
	
//	public String maplistname;
//	public Object objectdata;
	
//	public Map<String, Object> mapkeynval = new HashMap<String, Object>();
//
//	public GraphDataPojo()
//	{
//		
//	}
//
//	public Map<String, Object> getMapkeynval() {
//		return mapkeynval;
//	}
//
//	public void setMapkeynval(Map<String, Object> mapkeynval) {
//		this.mapkeynval = mapkeynval;
//	}
//	
	
	
	
///
	
//	public List<String> listofkeys = new ArrayList<String>();
//
//	public List<String> getListofkeys() {
//		return listofkeys;
//	}
//
//	public void setListofkeys(List<String> listofkeys) {
//		this.listofkeys = listofkeys;
//	}


}
