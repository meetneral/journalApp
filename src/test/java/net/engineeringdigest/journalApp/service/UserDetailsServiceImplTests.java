/*
package net.engineeringdigest.journalApp.service;


import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTests {


    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserEntryRepository userEntryRepository;


    @BeforeEach
   void setup() throws Exception {
        MockitoAnnotations.initMocks(this);// to intialize the method of this class like userRepository  and userdetailsServiceIMpl
    }

        @Test
    void loadUserByUsernameTest() {

        when(userEntryRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("Meet").password("Meet").roles("USER","ADMIN").build());
        UserDetails user = userDetailsService.loadUserByUsername("Meet");
        Assertions.assertNotNull(user);
    }
}
*/
/*package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enables Mockito for JUnit 5
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService; // Automatically injects mocks

    @Mock
    private UserEntryRepository userEntryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    void loadUserByUsernameTest() {
        // Mocking the User object
        User mockUser = new User();
        mockUser.setUsername("Meet");
        mockUser.setPassword("Meet");

        // Mock repository response
        when(userEntryRepository.findByUsername("Meet")).thenReturn(mockUser);

        // Call the method
        UserDetails userDetails = userDetailsService.loadUserByUsername("Meet");

        // Assertions
        assertNotNull(userDetails, "UserDetails should not be null");
        assertEquals("Meet", userDetails.getUsername(), "Username should match");
        assertEquals("Meet", userDetails.getPassword(), "Password should match");

        // Verify that the repository was called
        verify(userEntryRepository, times(1)).findByUsername("Meet");
    }
}*//*

*/
/*package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Enables Mockito for JUnit 5
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService; // Automatically injects mocks

    @Mock
    private UserEntryRepository userEntryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    void loadUserByUsernameTest() {
        // Creating a mock user with setter methods
        User mockUser = new User();
        mockUser.setUsername("Meet");
        mockUser.setPassword("Meet123"); // Assuming there's a setPassword method
        mockUser.setRole("ROLE_USER");   // If there's a role field, otherwise remove this line

        // Mock repository response
        when(userEntryRepository.findByUsername("Meet")).thenReturn(mockUser);

        // Call the method
        UserDetails userDetails = userDetailsService.loadUserByUsername("Meet");

        // Assertions
        assertNotNull(userDetails, "UserDetails should not be null");
        assertEquals("Meet", userDetails.getUsername(), "Username should match");
        assertEquals("Meet123", userDetails.getPassword(), "Password should match");

        // Verify that the repository was called once
        verify(userEntryRepository, times(1)).findByUsername("Meet");
    }

}*//*

*/
/*
package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Enables Mockito for JUnit 5
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserEntryRepository userEntryRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize mocks properly
    }

    @Test
    void loadUserByUsernameTest() {
        // Create a mock User entity (not Spring Security's UserDetails)
        User mockUser = new User();
        mockUser.setUsername("Meet");
        mockUser.setPassword("Meet");
        mockUser.setRole("ROLE_USER");

        // Mock repository behavior
        when(userEntryRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(mockUser);

        // Call the service method
        UserDetails userDetails = userDetailsService.loadUserByUsername("Meet");

        // Assertions
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals("Meet", userDetails.getUsername());
    }
}

*//*


*/
