/*
package net.engineeringdigest.journalApp.controler;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> JournalEntries=  new HashMap<>();
@GetMapping
    public List<JournalEntry> getAllJournalEntries() {
        return  new ArrayList<>(JournalEntries.values());

    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myentry){
JournalEntries.put(myentry.getId(), myentry);
return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){

return JournalEntries.get( myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntry(@PathVariable Long myId){
    return  JournalEntries.remove(myId);
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
        return  JournalEntries.put(myId,myEntry);
    }
}
*/
