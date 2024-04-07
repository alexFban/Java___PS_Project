package crud.operations.controller;

import lombok.AllArgsConstructor;
import crud.operations.entity.Project;
import crud.operations.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class that builds CRUD REST APIs for the {@link Project} resource.
 */
@RestController
@AllArgsConstructor
@RequestMapping("api/projects")
public class ProjectController {

    /**
     * Instance of {@link ProjectService} class.
     */
    private ProjectService projectService;

    /**
     * POST REST API.
     * @param project The project data to be added to the DataBase.
     * @return The response to the operation.
     */
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project savedProject = projectService.createProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }

    /**
     * GET REST API (with id parameter).
     * @param projectId The Project ID to be searched.
     * @return The response to the operation.
     */
    @GetMapping("{id}")
    public ResponseEntity<Project> getProjectByProject(@PathVariable("id") Long projectId) {
        Project project = projectService.getProjectById(projectId);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    /**
     * GET REST API (with no parameters).
     * @return The response to the operation.
     */
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    /**
     * PUT REST API.
     * @param projectId The project id to be searched.
     * @param project The new project data to be modified.
     * @return The response to the operation.
     */
    @PutMapping("{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") Long projectId, @RequestBody Project project) {
        project.setId(projectId);
        Project updatedProject = projectService.updateProject(project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    /**
     * DELETE REST API.
     * @param projectId The project id to be searched.
     * @return The response to the operation.
     */
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>("Project successfully deleted!", HttpStatus.OK);
    }
}
