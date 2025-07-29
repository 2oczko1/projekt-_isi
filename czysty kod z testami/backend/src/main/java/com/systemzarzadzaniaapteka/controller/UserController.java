package com.systemzarzadzaniaapteka.controller;

import com.systemzarzadzaniaapteka.model.AppUser;
import com.systemzarzadzaniaapteka.model.Customer;
import com.systemzarzadzaniaapteka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.systemzarzadzaniaapteka.service.UserService;
import com.systemzarzadzaniaapteka.security.CustomOidcUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody Map<String, String> userData) {
      try {
          AppUser registeredUser = userService.registerUserFromMap(userData);

          return ResponseEntity.ok(Map.of(
                  "success", true,
                  "message", "User registered successfully",
                  "user", registeredUser
          ));
      } catch (IllegalStateException e) {
          return ResponseEntity.status(409).body(Map.of(
                  "success", false,
                  "message", e.getMessage()
          ));
      }
  }

    @GetMapping
    public List<AppUser> getAllUsers() {
        return userService.getAllUsers();
    }
}
