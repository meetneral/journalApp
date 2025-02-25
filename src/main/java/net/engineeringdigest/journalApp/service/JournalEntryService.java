package net.engineeringdigest.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class  JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired

    private UserService userService;

   // private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);


        @Transactional
        public void saveEntry(JournalEntry journalEntry, String userName){

            try{
                User user=userService.findByUserName(userName);
                journalEntry.setDate(LocalDateTime.now());
                JournalEntry saved = journalEntryRepository.save(journalEntry);// from here isuue begin for the encoed password -encode
                user.getJournalEntries().add(saved);
                //user.setPassword(null); this statemnet is add to check the functionality of transactional annotation and it s implementation
                userService.saveUser(user);
            }catch(Exception e){
                log.info("hdssdggsg");
                throw new RuntimeException("thhere is exeception in the input");
            }

        }

    public void saveEntry(JournalEntry journalEntry){


        journalEntryRepository.save(journalEntry);
    }

        public List<JournalEntry> getAll(){
            return journalEntryRepository.findAll();
        }


        @Transactional
        public Optional<JournalEntry> getFindById(ObjectId id){
            return journalEntryRepository.findById(id);
        }
        public boolean deleteById(ObjectId id, String userName){
            boolean removed =false;
            try{
                User user=userService.findByUserName(userName);
                removed= user.getJournalEntries().removeIf(x->x.getId().equals(id));

                if(removed){//just added this if cause if it find then only run the below statement
                    userService.saveUser(user);//form this entry will be delete on users db
                    journalEntryRepository.deleteById(id); // and from this entry will be deletefrom jouranl_entries db
                }
            }catch(Exception e){
                System.out.println(e);
                throw new RuntimeException("error while deleting entries");
            }
            return removed;

        }


}

// controller-->service--> repository