package crud.operations.controller;

import crud.operations.entity.User_Project;
import crud.operations.service.UserService;
import crud.operations.service.User_ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class that builds CRUD REST APIs for the {@link User_Project} resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/user_projects")
public class User_ProjectController {

    /**
     * Instance of {@link User_ProjectService} class.
     */
    private User_ProjectService userProjectService;

    /**
     * POST REST API.
     * @param userProject The user project data to be added to the DataBase.
     * @return The response to the operation.
     */
    @PostMapping
    public ResponseEntity<User_Project> createUser_Project(@RequestBody User_Project userProject) {
        User_Project savedUserProject = userProjectService.createUser_Project(userProject);
        return new ResponseEntity<>(savedUserProject, HttpStatus.CREATED);
    }

    /**
     * GET REST API (with id parameter).
     * @param userProjectId The User Project ID to be searched.
     * @return The response to the operation.
     */
    @GetMapping("{id}")
    public ResponseEntity<User_Project> getUser_ProjectById(@PathVariable("id") Long userProjectId) {
        User_Project userProject = userProjectService.getUser_ProjectById(userProjectId);
        return new ResponseEntity<>(userProject, HttpStatus.OK);
    }

    /**
     * GET REST API (with no parameters).
     * @return The response to the operation.
     */
    @GetMapping
    public ResponseEntity<List<User_Project>> getAllUser_Projects() {
        List<User_Project> userProjects = userProjectService.getAllUser_Projects();
        return new ResponseEntity<>(userProjects, HttpStatus.OK);
    }

    /**
     * DELETE REST API.
     * @param userProjectId The user project id to be searched.
     * @return The response to the operation.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser_Project(@PathVariable("id") Long userProjectId) {
        userProjectService.deleteUser_Project(userProjectId);
        return new ResponseEntity<>("User_Project successfully deleted!", HttpStatus.OK);
    }
}
