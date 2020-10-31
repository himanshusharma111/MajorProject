package com.springmvc.firebase.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.springmvc.firebase.model.CounterPojo;
import com.springmvc.firebase.model.FirebasePojo;
import com.springmvc.firebase.model.GraphDataDemoPojo;
import com.springmvc.firebase.model.GraphDataPojo;
import com.springmvc.firebase.model.TraverseGraphDataPojo;


public interface FirebaseDao {
	
//	public FirebasePojo get(String name);
	
//	public List<FirebasePojo> list();
	
	public FirebasePojo getEmployeeName(String name) throws InterruptedException, ExecutionException;

	public List<CounterPojo> getAlltheReadings() throws InterruptedException, ExecutionException;

	public GraphDataDemoPojo GetKey_n_values_in_list() throws InterruptedException, ExecutionException;
	
	public GraphDataPojo getGraphData() throws InterruptedException, ExecutionException;
	
	public TraverseGraphDataPojo getTraverseGraphData() throws InterruptedException, ExecutionException; 
	
}
