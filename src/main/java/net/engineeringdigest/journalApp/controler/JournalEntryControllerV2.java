/*
package net.engineeringdigest.journalApp.controler;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
@Autowired
private JournalEntryService journalEntryService;


*/
/*@GetMapping
    public  List<JournalEntry> getAllEntries() {
    return journalEntryService.getAll();


    }*//*

    @GetMapping
    public  ResponseEntity<?> getAllEntries() {
        List<JournalEntry> entries = journalEntryService.getAll();
        return new ResponseEntity<>(entries,HttpStatus.OK);


    }
    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){

    try{
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);

    }catch(Exception e){
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
     //return myEntry can t able to add this line checking later on
    }
    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
       Optional<JournalEntry>journalEntry=journalEntryService.getFindById(myId);

        if (journalEntry.isPresent()) {

            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }


    }
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntry(@PathVariable ObjectId myId){//? wild card entry mean (?) means it may be empty or null
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("id/{myId}")
    public ResponseEntity<JournalEntry> updateJournalEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry newEntry){
        JournalEntry old=journalEntryService.getFindById(myId).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle() !=null && !newEntry.getTitle().equals("") ? newEntry.getTitle():old.getTitle());//  this condition will check if new entry is null or empty or not  if not then it set the new Enrty value given by user iin postman
            old.setContent(newEntry.getContent() !=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }

        return new ResponseEntity<>(old,HttpStatus.NOT_FOUND);
    }
}
*/
