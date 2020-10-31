package com.springmvc.firebase.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CounterPojo
{

	private int id;
	private String name;
	private int age;
	
	public Map<String, Object> map;
	
	
	
	public Map<String, Object> getMap() {
		
		map.put(name, getName());
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	
	public List<String> stringlist;
	
	public List<String> getStringlist() {
		return stringlist;
	}

	public void setStringlist(List<String> stringlist) {
		this.stringlist = stringlist;
	}


	public List<CounterPojo> strlist; 
	
	
	public List<CounterPojo> getStrlist() {
		return strlist;
	}

	public void setStrlist(List<CounterPojo> strlist) 
	{
		this.strlist = strlist;
	}

	@Override
	public String toString() {
		return "CounterPojo [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
