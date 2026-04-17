package com.jsp.project.SpringBootProject.Controller;

import java.util.List;

import com.jsp.project.SpringBootProject.Entity.Users;
import com.jsp.project.SpringBootProject.Service.UserService;
import com.jsp.project.SpringBootProject.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    // Create User
    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users user) {
        return userService.saveUser(user);
    }

    // Fetch All Users
    @GetMapping("/users")
    public ResponseEntity<ResponseStructure<List<Users>>> fetchAllUsers() {
        return userService.fetchUsers();
    }

    // Fetch User By ID
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<Users>> fetchUserById(@PathVariable int id) {
        return userService.fetchUser(id);
    }

    // Update User
    @PutMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<Users>> updateUser(@PathVariable int id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    // Delete User
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }
}
