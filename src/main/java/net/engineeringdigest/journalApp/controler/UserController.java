package net.engineeringdigest.journalApp.controler;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserEntryRepository userEntryRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }


   // @PutMapping("/{userName}")
    @PutMapping
    public ResponseEntity<?> UpdateUser(@RequestBody User user) {
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       String userName=authentication.getName();
        User userInDb = userService.findByUserName(userName);
      /*  if (userInDb != null) {
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }*/// this if add before Spring security

            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping
    public ResponseEntity<?> DeleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userEntryRepository.deleteByUsername(authentication.getName());//remember this naming convention are very challenging keep it as lesson meet very inport i have just change N to n

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);}

}
