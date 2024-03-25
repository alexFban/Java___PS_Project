package crud.operations.service;

import crud.operations.entity.User_Project;

import java.util.List;

/**
 * An interface where we define the header of the CRUD operations for User_Project.
 */
public interface User_ProjectService {
    User_Project createUser_Project(User_Project userProject);
    User_Project getUser_ProjectById(Long userProjectId);
    List<User_Project> getAllUser_Projects();
    void deleteUser_Project(Long userProjectId);
}
