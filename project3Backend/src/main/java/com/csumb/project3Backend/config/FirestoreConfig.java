package com.csumb.project3Backend.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirestoreConfig {

    @Bean
    public Firestore firestore() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            InputStream serviceAccount = new FileInputStream("src/main/java/com/csumb/project3backend/config/firebaseAccount.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();
            FirebaseApp.initializeApp(options);
        }
        return FirestoreClient.getFirestore();
    }
}