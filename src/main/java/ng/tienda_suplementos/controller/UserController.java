package ng.tienda_suplementos.controller;

import ng.tienda_suplementos.exceptions.UserNotFound;
import ng.tienda_suplementos.model.User;
import ng.tienda_suplementos.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        User userObtained = this.userService.searchUserById(id);

        if (userObtained != null) {
            logger.info("\n Usuario Obtenido:" + userObtained);
        } else {
            logger.info("\n No se ha encontrado el usuario de id: " + id);
        }

        return userObtained;
    }

    @PostMapping("/user-register")
    public User registerUser(@RequestBody User user) {
        user.setRole("User");

        User userData = this.userService.saveUser(user);

        if (userData != null) {
            logger.info("\n Usuario Registrado: " + userData);
        } else {
            logger.info("\n No se ha podido registrar al usuario.");
        }

        return userData;
    }

    @PutMapping("/user-edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable String id, @RequestBody User user) {
        User userObtained = this.userService.searchUserById(id);

        if (userObtained == null) {
            throw new UserNotFound("Usuario no encontrado.");
        }

        userObtained.setUsername(user.getUsername());
        userObtained.setEmail(user.getEmail());
        userObtained.setPassword(user.getPassword());
        userObtained.setRole((user.getRole() == null) ? "User" : user.getRole());

        this.userService.saveUser(userObtained);

        return ResponseEntity.ok(userObtained);
    }


    @DeleteMapping("/user-delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable String id) {
        User user = this.userService.searchUserById(id);

        if (user == null) {
            throw new UserNotFound("Usuario no encontrado.");
        }

        this.userService.deleteUser(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Erased", true);

        return ResponseEntity.ok(response);
    }
}
