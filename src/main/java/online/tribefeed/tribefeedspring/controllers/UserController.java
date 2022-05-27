package online.tribefeed.tribefeedspring.controllers;

import online.tribefeed.tribefeedspring.domain.User;
import online.tribefeed.tribefeedspring.exceptions.ResourceNotFoundException;
import online.tribefeed.tribefeedspring.repositories.UserRepository;
import online.tribefeed.tribefeedspring.security.CurrentUser;
import online.tribefeed.tribefeedspring.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}