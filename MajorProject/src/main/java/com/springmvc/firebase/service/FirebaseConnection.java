package com.springmvc.firebase.service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.FirebaseDatabase;

@Service
public class FirebaseConnection {
	
	//Admin sdk for the server
	@PostConstruct
	public void firebaseInitializer() throws IOException
	{
		
		//Initialize the SDK as shown:
		

		InputStream serviceAccount = this.getClass().getClassLoader()
				.getResourceAsStream("./firebase.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://web-dev-18406.firebaseio.com").build();

		if (FirebaseApp.getApps().isEmpty()) {
			FirebaseApp.initializeApp(options);
		}   
			   		
	}
	
	
	public Firestore getFirestore()
	{
		return FirestoreClient.getFirestore();
	}

}
	
	
	
////InputStream serviceAccount = this.getClass()
////.getClassLoader()
////.getResourceAsStream("src/main/resources/");
//
//InputStream serviceAccount = new ClassPathResource("firebase.json")
//.getInputStream();
//FirebaseOptions options = new FirebaseOptions.Builder()
//.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//.setDatabaseUrl("https://web-dev-18406.firebaseio.com").build();
//
//
//
//
//// check is firebase app is empty
//
//if (FirebaseApp.getApps().isEmpty()) 
//{
//FirebaseApp.initializeApp(options);
//FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//}
//
//}
//
////for firebase return instance 
//public Firestore getFirebase()
//{
//return FirestoreClient.getFirestore();
//}
