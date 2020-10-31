package com.springmvc.firebase.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.util.JsonMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.springmvc.firebase.model.CounterPojo;
import com.springmvc.firebase.model.FirebasePojo;
import com.springmvc.firebase.model.GraphDataDemoPojo;
import com.springmvc.firebase.model.GraphDataPojo;
import com.springmvc.firebase.model.TraverseGraphDataPojo;
import com.springmvc.firebase.service.FirebaseConnection;

@Repository
public class FirebaseDaoImpl implements FirebaseDao {
	@Autowired
	
	//global
	FirebaseConnection db;

	public static final String COL_NAME = "Employee";
	public static final String Doc_NAME = "cftYmTF2yzO9LYIShanu";
	public static final String COL_NAME2 = "Counter";

	// Global Variable. 
	// Access this var anywhere. 
	public List<CounterPojo> counterpojos;
	private List<GraphDataDemoPojo> graphdatapojos = null;
	private GraphDataDemoPojo gdp;
	private GraphDataPojo graphdatapojo;
	private TraverseGraphDataPojo traversedata;

	// get query
	public FirebasePojo getEmployeeName(String name) throws InterruptedException, ExecutionException {

		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(Doc_NAME);
		ApiFuture<DocumentSnapshot> future = documentReference.get();

		DocumentSnapshot document = future.get();

		FirebasePojo patient = null;

		if (document.exists()) {
			patient = document.toObject(FirebasePojo.class);
			return patient;
		}

		else {
			return null;
		}
	}
	

	public List<CounterPojo> getAlltheReadings() throws InterruptedException, ExecutionException {

		List<CounterPojo> empList = new ArrayList<CounterPojo>();

		CollectionReference employee = db.getFirestore().collection(COL_NAME);

		ApiFuture<QuerySnapshot> querySnapshot = employee.get();

		for (DocumentSnapshot doc : querySnapshot.get().getDocuments()) {
			CounterPojo emp = doc.toObject(CounterPojo.class);
			empList.add(emp);

			emp.setStrlist(empList);
		}

		return empList;
	}
	
	
	// This Below What i want
	public GraphDataDemoPojo GetKey_n_values_in_list() throws InterruptedException, ExecutionException {

		// database credential
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Counter").document("mapping");
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		if (document.exists()) {
			Map<String, Object> map = document.getData();

			if (map != null) {

				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Map<String, String> map1 = (Map<String, String>) entry.getValue();

					Set<String> keys1 = map1.keySet(); // key 
					String strval = map1.values().toString(); // value

					Gson gson = new Gson();
					JsonElement jsonElement = gson.toJsonTree(entry.getValue());
					GraphDataDemoPojo graphdatapojo = gson.fromJson(jsonElement, GraphDataDemoPojo.class);
					graphdatapojo.setKeyName(entry.getKey());
					graphdatapojo.setValue(entry.getValue());
					graphdatapojo.setKeySet(keys1);
					graphdatapojo.setValueSet(strval);

					return graphdatapojo;
				}

			}

		}
		return gdp;
	}
	
	
	public GraphDataPojo getGraphData() throws InterruptedException, ExecutionException
	{
		// database credential
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Counter").document("20-09-2020");
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		if (document.exists()) {
			Map<String, Object> map = document.getData();

			if (map != null) {

				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Map<String, String> map1 = (Map<String, String>) entry.getValue();

					Set<String> keys1 = map1.keySet();
					String strval = map1.values().toString();

					Gson gson = new Gson();
					JsonElement jsonElement = gson.toJsonTree(entry.getValue());
					GraphDataPojo graphdatapojo = gson.fromJson(jsonElement, GraphDataPojo.class);
					graphdatapojo.setKeyName(entry.getKey());
					graphdatapojo.setValue(entry.getValue());
					graphdatapojo.setKeySet(keys1);
					graphdatapojo.setValueSet(strval);

					return graphdatapojo;
				}

			}

		}
		
		return graphdatapojo;
	}
	
	
	public TraverseGraphDataPojo getTraverseGraphData() throws InterruptedException, ExecutionException
	{
		// database credential
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Counter").document("20-09-2020");
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		if (document.exists()) 
		{
			Map<String, Object> map = document.getData();
			//map - 

			if (map != null) {

				for (Map.Entry<String, Object> entry : map.entrySet()) {
					
					Map<String, String> map1 = (Map<String, String>) entry.getValue();
					Map<String, String> linkMap = new LinkedHashMap<String, String>();
						 linkMap.putAll(map1);
						 
						 
						  System.out.println("Before Sorting by Values -"
					                + " as per insertion-order : \n");
					 
					        // iterate original LinkedHashMap
					        for(Map.Entry<String, String> lhmap : 
					            linkMap.entrySet()){
					            System.out.println("Key : "  + lhmap.getKey() 
					                    + "\t\t" + "Value : "  + lhmap.getValue());
					        }
					 
					
						   // 1. get entrySet from LinkedHashMap object
					        Set<Map.Entry<String, String>> companyFounderSet = linkMap.entrySet();
					 
					        // 2. convert LinkedHashMap to List of Map.Entry
					        List<Map.Entry<String, String>> companyFounderListEntry = new ArrayList<Map.Entry<String, String>>(companyFounderSet);
					 
					        // 3. sort list of entries using Collections class'
					        // utility method sort(ls, cmptr)
					        Collections.sort(companyFounderListEntry, new Comparator<Map.Entry<String, String>>() {
					 
					            public int compare(Entry<String, String> es1, 
					                    Entry<String, String> es2) {
					                
//					            	return es2.getValue().compareTo(es1.getValue());
					                return es1.getKey().compareTo(es2.getKey());
					            }
					        });
					 
					        // 4. clear original LinkedHashMap
					        linkMap.clear();
					 
					        // 5. iterating list and storing in LinkedHahsMap
					        for(Map.Entry<String, String> map2 : companyFounderListEntry){
					            linkMap.put(map2.getKey(), map2.getValue());
					        }
					 
					        System.out.println("\n\nSorted LinkedHashMap by its Values"
					                + " in descending-order\n");
					 
					        // iterate LinkedHashMap to retrieved stored values
					        for(Map.Entry<String, String> lhmap : linkMap.entrySet()){
					            System.out.println("Key : "  + lhmap.getKey() 
					                    + "\t\t" + "Value : "  + lhmap.getValue());

					        }
					        
					        //now linkmap is stores ascdeing data 
						    Set<String> keys1 = linkMap.keySet();
							String strval = linkMap.values().toString();
							
							Gson gson = new Gson();
							JsonElement jsonElement = gson.toJsonTree(entry.getValue());
							TraverseGraphDataPojo graphdatapojo = gson.fromJson(jsonElement, TraverseGraphDataPojo.class);
							
//							graphdatapojo.setKeyName(entry.getKey());
//							graphdatapojo.setValue(entry.getValue());
							
							graphdatapojo.setKeySet(keys1);
							graphdatapojo.setValueSet(strval);
							
							return graphdatapojo;
						
						 
				       
					 	
					}
				
				}

			}

		return traversedata;
	}
	

}





//first try 

/*
 * 
 * // Map<String, Object> map = new HashMap<String, Object>();
 * 
 * // database credential Firestore dbFirestore =
 * FirestoreClient.getFirestore(); DocumentReference documentReference =
 * dbFirestore.collection("Counter").document("mapping");
 * ApiFuture<DocumentSnapshot> future = documentReference.get();
 * DocumentSnapshot document = future.get();
 * 
 * // Map<String, Object> mappp = new HashMap<String, Object>(); GraphDataPojo
 * mapp = null;
 * 
 * if (document.exists()) {
 * 
 * //using custom java object mapp = document.toObject(GraphDataPojo.class);
 * 
 * return mapp; }
 * 
 * return mapp;
 * 
 * }
 */

/*
 * if (mappp != null) {
 * 
 * 
 * for (Map.Entry<String, Object> entry : mappp.entrySet()) {
 * gdp.setMapkeynval(entry.getKey(),entry.getValue(), mappp); }
 */

/*
 * if (map != null) {
 * 
 * for (Map.Entry<String, Object> entry : map.entrySet()) {
 * 
 * 
 * 
 * // list.add(entry.getValue().toString()); //
 * System.out.println("entry.toString() : " + entry.toString());
 * 
 * // Set<String> keys = map.keySet();
 * 
 * // System.out.println("Map name : " + keys);
 * 
 * // for (String key1 : keys) { // System.out.println(key1 + ":" +
 * map.get(key1)); // }
 * 
 * 
 * // getting all the data of field and values in sperate way.... Map<String,
 * String> map1 = new HashMap<String, String>(); Map<String, String> value =
 * (Map<String, String>) entry.getValue(); map1 = value;
 * 
 * Set<String> keys1 = map1.keySet(); //
 * System.out.println("All the keys1 are : " + keys1);
 * 
 * // String strval = map1.values().toString(); //
 * System.out.println("All the values are :"+strval);
 * 
 * 
 * // now i want to send this all the data inside the pojo class model class. //
 * Converting set to the arraylist // for storing the data data inside the pojo
 * class List<String> listSet = new ArrayList<String>(keys1); //
 * System.out.println("ArrayList contains ListSet :"+listSet);
 * 
 * // graphdatapojos = null; // ((GraphDataPojo)
 * graphdatapojos).setListofkeys(listSet);
 * 
 * gdp.setListofkeys(listSet);
 * 
 * 
 * return graphdatapojos;
 * 
 * }
 * 
 * }
 * 
 * //getting all the data default format of Map using list (map data is added to
 * the list) // for (String string : list) { //
 * System.out.println("normal form :" + string); // // }
 */

/*
 * 
 * public ArrayList<String> getkeyValue() throws InterruptedException,
 * ExecutionException { Firestore db = FirestoreClient.getFirestore();
 * ApiFuture<QuerySnapshot> query = db.collection("COL_NAME2").get();
 * 
 * QuerySnapshot querySnapshot = query.get();
 * 
 * List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
 * ArrayList<String> titles = new ArrayList<String>();
 * 
 * for (QueryDocumentSnapshot document : documents) { String as =
 * document.getId(); System.out.println(as); System.out.println("auto id: " +
 * document.getId()); String title = document.getString("number 1");
 * titles.add(title+as); }
 * 
 * System.out.println("titles = " + titles);
 * 
 * return titles; }
 */
