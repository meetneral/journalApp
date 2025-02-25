package net.engineeringdigest.journalApp;

import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(JournalApplication.class, args);
		System.out.println(context);//to know which prfile is running


    }
	@Bean
	public PlatformTransactionManager TimePass(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}


}
