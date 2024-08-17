package org.eventure.services.Impl;

import org.eventure.datamodel.User;
import org.eventure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = passwordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);

        System.out.println("Raw password during signup: " + rawPassword);
        System.out.println("Encoded password during signup: " + encodedPassword);

        return userRepository.save(user);
    }


    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(User user) {
        Optional<User> existingUserOptional = userRepository.findById(user.getId());

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            } else {
                user.setPassword(existingUser.getPassword());
            }

            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
