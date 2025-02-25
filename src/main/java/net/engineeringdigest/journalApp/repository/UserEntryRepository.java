package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

/*@Configuration
@EnableMongoRepositories(basePackages = "net.engineeringdigest.journalApp.repository")*/
//@Repository

public interface UserEntryRepository extends MongoRepository<User, ObjectId> {

User findByUsername(String username );

void deleteByUsername(String username);
}

