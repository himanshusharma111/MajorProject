package com.springmvc.firebase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets.SetView;
import com.google.firebase.database.DataSnapshot;
import com.google.gson.JsonArray;
import com.springmvc.firebase.dao.FirebaseDao;
import com.springmvc.firebase.dao.FirebaseDaoImpl;
import com.springmvc.firebase.model.CounterPojo;
import com.springmvc.firebase.model.FirebasePojo;
import com.springmvc.firebase.model.GraphDataDemoPojo;
import com.springmvc.firebase.model.GraphDataPojo;
import com.springmvc.firebase.model.TraverseGraphDataPojo;

import io.opencensus.tags.propagation.TagContextTextFormat.Getter;

@Controller
@RequestMapping("/firebaseGetData")
public class FirebaseController {

	@Autowired
	private FirebaseDao firebaseDao;
	
// GET POST PUT DELETE UPDATE
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getEmployee(Model model) throws InterruptedException, ExecutionException {
		
		FirebasePojo h = new FirebasePojo();
		String name = h.getName();

		FirebasePojo ssss = firebaseDao.getEmployeeName(name);
		model.addAttribute("Sent", ssss.getName());
		

		System.out.println(name);
		System.out.println(ssss);
		System.out.println(firebaseDao.getEmployeeName(name));

		return "firstIndex";
	}

	@RequestMapping(value = "/dataReadingList", method = RequestMethod.GET)
	public String getMachineReadings(Model model) throws InterruptedException, ExecutionException {
		
		List<CounterPojo> aas = new ArrayList<CounterPojo>();

		aas = firebaseDao.getAlltheReadings();

		for (CounterPojo temp : aas) {

			System.out.println(temp.getAge());
			System.out.println(temp.getId());
			System.out.println(temp.getName());
			
			System.out.println(temp.getStrlist());
			// output - [CounterPojo [id=1, name=himanshu, age=22]]
		}
		
		
		System.out.println("aas :" + aas);

		for (CounterPojo tm : aas) {
			System.out.println("tm.toString() : " + tm.toString());

		}
		
			List<CounterPojo> aswq = new ArrayList<CounterPojo>();
			aswq = firebaseDao.getAlltheReadings(); 
			aswq.get(0);
			System.out.println(aswq.get(0));
			
		return "datashow";
	}
	
	

	// new method 
	
	@RequestMapping(value =  "/keysnvalue", method = RequestMethod.GET)
	public String getKEYS_n_Values() throws InterruptedException, ExecutionException 
	{	
	
		GraphDataDemoPojo gre= firebaseDao.GetKey_n_values_in_list();
		System.out.println(gre.getKeyName());
		System.out.println(gre.getValue());
		System.out.println("getkeySet :"+gre.getKeySet());
		System.out.println("getValueSet :"+ gre.getValueSet());
		
		return null;	
	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/graph", method = RequestMethod.GET)
	public String getGraphData(Model model) throws InterruptedException, ExecutionException
	{
		GraphDataPojo graphdataPojo = firebaseDao.getGraphData();
		System.out.println(graphdataPojo.getKeyName());
		System.out.println(graphdataPojo.getValue());
		System.out.println(graphdataPojo.getKeySet()); // [Time,Time]
		System.out.println(graphdataPojo.getValueSet());// [Value,Value]
		
		Set<String> getkeySet = graphdataPojo.getKeySet();
		String getValueSet = graphdataPojo.getValueSet();
		
		
		List<String> mainList = new ArrayList<String>();
		mainList.addAll(getkeySet);
		

		JSONArray array = new JSONArray();
		
		for (int i=0; i < mainList.size();i++)
		{
			
		  System.out.println("Value of element "+i +":"+ mainList.get(i));
		  array.add(i, mainList.get(i));
		  
		}
		
		// different key n value no pair/// 
		model.addAttribute("sendarrayform",array);
		model.addAttribute("sendvalueSet",getValueSet);
		
		
		
//		System.out.println(getkeySet.toString());
//		String getkeySetStr = getkeySet.toString();
//		model.addAttribute("sendkeyset",getkeySet);
//		model.addAttribute("SendstrKey", getkeySetStr);
	
		return "line";
	}
	
	// Test controller for ascending order of the map data .... 
	@RequestMapping(value = "/traverseGraph", method = RequestMethod.GET)
	public String TraverseGraphData(Model model) throws InterruptedException, ExecutionException
	{
		
		TraverseGraphDataPojo graphdata = firebaseDao.getTraverseGraphData();
		System.out.println(graphdata.getKeySet());
		System.out.println(graphdata.getValueSet());
		
		
		Set<String> getkeySet = graphdata.getKeySet();
		String getValueSet = graphdata.getValueSet();
		
		List<String> mainList = new ArrayList<String>();
		mainList.addAll(getkeySet);
		

		JSONArray array = new JSONArray();
		
		for (int i=0; i < mainList.size();i++)
		{
			
		  System.out.println("Value of element "+i +":"+ mainList.get(i));
		  array.add(i, mainList.get(i));
		  
		}
		
		model.addAttribute("sendarrayform",array);
		model.addAttribute("sendvalueSet",getValueSet);
		
		
		return "lineTest";
	}

}








/*	Map<String, Object> map = firebaseDao.GetKey_n_values_in_list();
		GraphDataPojo gdp = (GraphDataPojo) map;
		
		Map<String, Object>  mapget = new HashMap<String, Object>();
		
		mapget = gdp.getMapkeynval();
		
		if (mapget != null) 
		{
			System.out.println("Something in there");
			
		}
		
		else 
		{
			System.out.println("some errors occur");
		}
		*/
 