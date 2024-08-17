package org.eventure.controller;

import jakarta.validation.Valid;
import org.eventure.request.AuthenticationRequest;
import org.eventure.response.AuthenticationResponse;
import org.eventure.datamodel.User;
import org.eventure.services.Impl.UserService;
import org.eventure.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("Received login request for user: " + authenticationRequest.getUsername());
        System.out.println("Raw password at login: " + authenticationRequest.getPassword());

        UserDetails userDetails;

        try {
            userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }

        System.out.println("Encoded password at login: " + userDetails.getPassword());
        boolean passwordMatches = passwordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword());
        System.out.println("Does the raw password match the encoded password? " + passwordMatches);

        if (!passwordMatches) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody User user) {
        if (userService.getUserByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/test")
    public ResponseEntity<String> testEndpoint() {
        return ResponseEntity.ok("Test endpoint is working!");
    }
}
