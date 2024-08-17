//package org.eventure.controller;
//
//
//
//import org.eventure.datamodel.User;
//import org.eventure.services.Impl.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable String id) {
//        return ResponseEntity.ok(userService.getUserById(id).orElse(null));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
//        user.setId(id);
//        return ResponseEntity.ok(userService.updateUser(user));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
//        userService.deleteUser(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//
