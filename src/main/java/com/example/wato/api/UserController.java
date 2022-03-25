package com.example.wato.api;

import com.example.wato.model.User;
import com.example.wato.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private  final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @CrossOrigin
    @PostMapping
    public void addUser(@RequestBody User user) {
        System.out.println(user.getUsername());
        userService.addUser(user);
    }
    @CrossOrigin
    @GetMapping
    public List<User> getAllUsers() {
        System.out.println(userService.getAllUsers());
        return userService.getAllUsers();
    }
    @CrossOrigin
    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id){
        return userService.getUserById(id)
                .orElse(null);
    }
    @CrossOrigin
    @DeleteMapping(path = "{id}")
    public void deleteUserById(@PathVariable("id") UUID id){
        userService.deleteUser(id);
    }
    @CrossOrigin
    @PutMapping(path = "{id}")
    public void updateUser(@PathVariable("id") UUID id, @RequestBody User userToUpdate){
        userService.updateUser(id, userToUpdate);
    }
}
