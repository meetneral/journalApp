package net.engineeringdigest.journalApp.controler;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV3 {
@Autowired
private JournalEntryService journalEntryService;


@Autowired

private UserService userService;



    //@GetMapping("{userName}")
    @GetMapping
    public  ResponseEntity<?> getAllJournalEntriesOfUser() {//@PathVariable String userName //used before spring security
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if(all!=null && !all.isEmpty()) {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @PostMapping //("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){

    try{

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName= authentication.getName();

        journalEntryService.saveEntry(myEntry,userName);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);

    }catch(Exception e){
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
     //return myEntry can t able to add this line checking later on
    }

    @GetMapping("id/{myId}")

    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);

        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());

        if (!collect.isEmpty()) {
            Optional<JournalEntry> journalEntry = journalEntryService.getFindById(myId);
            if (journalEntry.isPresent()) {

                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);


    }
    @DeleteMapping("id/{myId}")

    public ResponseEntity<?> deleteJournalEntry(@PathVariable ObjectId myId){//? wild card entry mean (?) means it may be empty or null
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed=journalEntryService.deleteById(myId,userName);
        if(removed){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("id/{myId}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable ObjectId myId,
                                                           @RequestBody JournalEntry newEntry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            Optional<JournalEntry> journalEntry = journalEntryService.getFindById(myId);
            if (journalEntry.isPresent()) {
                JournalEntry old =journalEntry.get();
                old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());//  this condition will check if new entry is null or empty or not  if not then it set the new Enrty value given by user iin postman
                old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old,HttpStatus.OK);
            }

        } return new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }
}


//my way
/*
@PutMapping("id/{myId}")
public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable ObjectId myId,
                                                       @RequestBody JournalEntry newEntry){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName = authentication.getName();


    JournalEntry old=journalEntryService.getFindById(myId).orElse(null);

    if(old!=null){
        old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());//  this condition will check if new entry is null or empty or not  if not then it set the new Enrty value given by user iin postman
        old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        journalEntryService.saveEntry(old);
        return new ResponseEntity<>(old,HttpStatus.OK);
    }

    return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);

}*/
