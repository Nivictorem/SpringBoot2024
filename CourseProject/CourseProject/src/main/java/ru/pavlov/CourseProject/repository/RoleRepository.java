package ru.pavlov.CourseProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavlov.CourseProject.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}