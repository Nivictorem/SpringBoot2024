package ru.pavlov.CourseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pavlov.CourseProject.entity.Car;
import ru.pavlov.CourseProject.entity.CarModel;

import java.util.List;
@Repository
public interface CarModelRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findByBrand(String brand);
}
