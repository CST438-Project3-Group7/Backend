package com.csumb.project3Backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

  @PostConstruct
  public void initializeFirebase() {
    try {
      // Load the service account key JSON file from the resources directory
      InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

      if (serviceAccount == null) {
        throw new IllegalStateException("Firebase service account file not found in resources.");
      }

      // Initialize Firebase with the service account credentials
      FirebaseOptions options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .build();

      // Only initialize if no FirebaseApp exists already
      if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
      }
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize Firebase", e);
    }
  }
}

