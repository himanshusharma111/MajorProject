package com.springmvc.firebase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

// DEMO controller responsible accepting request.

@Controller
public class DemoCont {

	@RequestMapping("/hellostarting")
	public String helloSpring(Model model) {
		String ss = "spring mvc module is ready";
		model.addAttribute("sandesh", ss);
		return "firstIndex";
	}

	// below method is for dao we need to implement this method inside the dao to
	// pojo and then send it to the controller.
	// this method is belongs to here because of trial purposes. :)

	@RequestMapping("/another")
	public String querytry() throws InterruptedException, ExecutionException {
		/*
		 * 
		//database credential 
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Counter").document("mapping");
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		if (document.exists()) {
			
			List<String> list = new ArrayList<String>();
			Map<String, Object> map = document.getData();
			if (map != null) {
				
				for (Map.Entry<String, Object> entry : map.entrySet()) 
				{
					
					list.add(entry.getValue().toString());
					System.out.println("entry.toString() : " + entry.toString());

					Set<String> keys = map.keySet();
					
					System.out.println("Map name : " + keys);
					
					for (String key1 : keys) {
						System.out.println(key1 + ":" + map.get(key1));
					}

					
					// getting all the data of field and values in sperate way.... 
					Map<String, String> map1 = new HashMap<String, String>();
					Map<String, String> value = (Map<String, String>) entry.getValue();
					map1 = value;
					
					Set<String> keys1 = map1.keySet();
					System.out.println("All the keys1 are : " + keys1);
					
					String strval = map1.values().toString();
					System.out.println("All the values are :"+strval);
					
					
					// Converting set to the arraylist // for storing the data data inside the pojo class
					List<String> listSet = new ArrayList<String>(keys1);
					System.out.println("ArrayList contains ListSet :"+listSet);
						
				}

			}
			
			//getting all the data default format of Map using list (map data is added to the list)
			for (String string : list) {
				System.out.println("normal form :" + string);

			}
			
			// now i want to send this all the data inside the pojo class model class. 
			//waiting for the logics..........

		}
*/
		return null;

	}

	/*
	 * public String getKeys() throws InterruptedException, ExecutionException {
	 * 
	 * Firestore dbFirestore = FirestoreClient.getFirestore(); DocumentReference
	 * documentReference = dbFirestore.collection("Counter").document("mapping");
	 * ApiFuture<DocumentSnapshot> future = documentReference.get();
	 * 
	 * DocumentSnapshot document = future.get();
	 * 
	 * if (document.exists()) {
	 * 
	 * }
	 * 
	 * 
	 * return null; }
	 */

}

// get id in string form means document id 

/*
 * Firestore db = FirestoreClient.getFirestore(); ApiFuture<QuerySnapshot> query
 * = db.collection("Counter").get();
 * 
 * QuerySnapshot querySnapshot = query.get();
 * 
 * List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
 * ArrayList<String> titles = new ArrayList<String>();
 * 
 * for (QueryDocumentSnapshot document : documents) { String as =
 * document.getId(); System.out.println(as); System.out.println("auto id: " +
 * document.getId()); String title = document.getString("names");
 * 
 * titles.add(title); }
 * 
 * System.out.println("titles = " + titles);
 */

/*
 * List<String> liststr = new ArrayList<String>();
 * 
 * String sa = "=";
 * 
 * if (list != null) {
 * 
 * if (list.equals(sa)) { liststr = list; } }
 */
