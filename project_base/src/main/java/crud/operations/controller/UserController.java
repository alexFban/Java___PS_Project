package crud.operations.controller;

import crud.operations.entity.Project;
import crud.operations.entity.User;
import lombok.AllArgsConstructor;
import crud.operations.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class that builds CRUD REST APIs for the {@link User} resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    /**
     * Instance of {@link UserService} class.
     */
    private UserService userService;

    /**
     * POST REST API.
     * @param user The user data to be added to the DataBase.
     * @return The response to the operation.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/users/1
    /**
     * GET REST API (with id parameter).
     * @param userId The User ID to be searched.
     * @return The response to the operation.
     */
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("{uId}/projects")
    public ResponseEntity<List<Project>> getUserProjects(@PathVariable("uId") Long userId) {
        List<Project> projects = userService.getUserProjects(userId);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    // http://localhost:8080/api/users
    /**
     * GET REST API (with no parameters).
     * @return The response to the operation.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // http://localhost:8080/api/users/1
    /**
     * PUT REST API.
     * @param userId The user id to be searched.
     * @param user The new user data to be modified.
     * @return The response to the operation.
     */
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    /**
     * DELETE REST API.
     * @param userId The user id to be searched.
     * @return The response to the operation.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}