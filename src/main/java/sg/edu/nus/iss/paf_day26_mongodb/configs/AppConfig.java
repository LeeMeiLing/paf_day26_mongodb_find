package sg.edu.nus.iss.paf_day26_mongodb.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {
    
    @Value("${mongo.url}")
    private String mongoUrl;

    @Bean
    public MongoTemplate createMongoTemplate(){

        // Create Mongo Client
        MongoClient client = MongoClients.create(mongoUrl);

        // MongoTemplate template = new MongoTemplate(client, "shows");
        // return template;

        return new MongoTemplate(client, "shows");

    }

    
}
