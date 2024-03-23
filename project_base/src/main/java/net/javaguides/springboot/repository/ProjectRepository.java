package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
