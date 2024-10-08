package ru.pavlov.CourseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavlov.CourseProject.entity.UserActions;

import java.util.List;

public interface UserActionsRepository extends JpaRepository<UserActions, Long> {

}
