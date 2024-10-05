package ru.pavlov.CourseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavlov.CourseProject.entity.UserActions;

public interface UserActionsRepository extends JpaRepository<UserActions, Long> {
}
