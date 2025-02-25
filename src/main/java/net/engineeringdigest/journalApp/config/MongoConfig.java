/*
package net.engineeringdigest.journalApp.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Replace with your MongoDB URI if needed
        return MongoClients.create("mongodb+srv://meetneral33:C6OmSekfGzEu7lnq@cluster0.jxe3e.mongodb.net");
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, "journaldb"); // Replace with your DB name
    }
}
*/
