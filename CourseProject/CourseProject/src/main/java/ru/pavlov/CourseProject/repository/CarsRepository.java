package ru.pavlov.CourseProject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pavlov.CourseProject.entity.Car;
import ru.pavlov.CourseProject.entity.User;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {
    List<Car> findByEmail(String email);
}
