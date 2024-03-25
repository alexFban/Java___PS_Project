package crud.operations.service.impl;

import crud.operations.entity.User_Project;
import crud.operations.repository.User_ProjectRepository;
import crud.operations.service.User_ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class User_ProjectServiceImpl implements User_ProjectService {
    private User_ProjectRepository userProjectRepository;
    @Override
    public User_Project createUser_Project(User_Project userProject) { return userProjectRepository.save(userProject); }
    @Override
    public User_Project getUser_ProjectById(Long userProjectId) {
        Optional<User_Project> optionalUserProject = userProjectRepository.findById(userProjectId);
        return optionalUserProject.get();
    }
    @Override
    public List<User_Project> getAllUser_Projects() { return userProjectRepository.findAll(); }
    @Override
    public void deleteUser_Project(Long userProjectId) { userProjectRepository.deleteById(userProjectId); }
}
