package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserEntryRepository userEntryRepository;


    @Override
    public UserDetails loadUserByUsername(String username){
        User user=userEntryRepository.findByUsername(username);
        if(user != null){
            UserDetails userDetails =org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles((user.getRoles().toArray(new String[0])))
                    .build();
            return  userDetails;
        }
        throw new UsernameNotFoundException("user not found  with username:"+username);
    }


}


// controller-->service--> repository