// src/main/java/com/eventure/adminpanel/service/UserDetailsServiceImpl.java
package org.eventure.services.Impl;

import org.eventure.datamodel.User;
import org.eventure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.get().getUsername())
                    .password(user.get().getPassword())
                    .roles(user.get().getRole())  // e.g., "ADMIN"
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }


}
