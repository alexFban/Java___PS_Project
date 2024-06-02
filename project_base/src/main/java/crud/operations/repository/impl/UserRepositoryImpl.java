package crud.operations.repository.impl;

import crud.operations.entity.User;
import crud.operations.repository.UserRepository;
import crud.operations.repository.jpa.UserJpaRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    UserJpaRepo jpaRepository;

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return jpaRepository.findById(userId);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        List<User> users = jpaRepository.findAll();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long userId) {
        jpaRepository.deleteById(userId);
    }
}
