package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.entity.Project;
import net.javaguides.springboot.repository.ProjectRepository;
import net.javaguides.springboot.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;
    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
    @Override
    public Project getProjectById(Long projectId) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);
        return optionalProject.get();
    }
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    @Override
    public Project updateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getId()).get();
        existingProject.setFunding_goal(project.getFunding_goal());
        existingProject.setMoney_raised(project.getMoney_raised());
        existingProject.setDescription(existingProject.getDescription());
        Project updatedProject = projectRepository.save(existingProject);
        return updatedProject;
    }
    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
