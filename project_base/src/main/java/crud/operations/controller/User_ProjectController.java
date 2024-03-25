package crud.operations.controller;

import crud.operations.entity.User_Project;
import crud.operations.service.User_ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user_projects")
public class User_ProjectController {
    private User_ProjectService userProjectService;
    @PostMapping
    public ResponseEntity<User_Project> createUser_Project(@RequestBody User_Project userProject) {
        User_Project savedUserProject = userProjectService.createUser_Project(userProject);
        return new ResponseEntity<>(savedUserProject, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<User_Project> getUser_ProjectById(@PathVariable("id") Long userProjectId) {
        User_Project userProject = userProjectService.getUser_ProjectById(userProjectId);
        return new ResponseEntity<>(userProject, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User_Project>> getAllUser_Projects() {
        List<User_Project> userProjects = userProjectService.getAllUser_Projects();
        return new ResponseEntity<>(userProjects, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser_Project(@PathVariable("id") Long userProjectId) {
        userProjectService.deleteUser_Project(userProjectId);
        return new ResponseEntity<>("User_Project successfully deleted!", HttpStatus.OK);
    }
}
