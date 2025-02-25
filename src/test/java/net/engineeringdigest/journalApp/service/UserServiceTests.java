package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // without this we can't able to create componenet in spring very important
public class UserServiceTests {

    @Autowired
    UserEntryRepository userEntryRepository;

    @Autowired
    UserService userService;

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "Ram","Meet","Meeet","RajendraN"
    })
    public void testAddUser(String name) throws Exception {
       // assertEquals(4,2+2);
        assertNotNull(userEntryRepository.findByUsername(name));

       // User user=userEntryRepository.findByUsername("Meet");
      //  assertNotNull(user.getJournalEntries().isEmpty());
    }

    /*@ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
public void testSaveNewUser(User user){
        assertTrue(userService.saveNewUser(user));
    }*/

    @Disabled
    @ParameterizedTest
    @CsvSource({"1,1,2",
    "2,10,12",
    "3,3,9"})
    public void testCM(int a,int b,int expected){
        assertEquals(expected,a+b);
    }
}
