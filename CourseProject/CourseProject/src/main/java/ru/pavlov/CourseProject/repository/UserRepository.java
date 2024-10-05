package ru.pavlov.CourseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavlov.CourseProject.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}