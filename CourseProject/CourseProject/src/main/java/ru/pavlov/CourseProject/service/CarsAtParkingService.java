package ru.pavlov.CourseProject.service;

import org.springframework.stereotype.Service;
import ru.pavlov.CourseProject.entity.Car;
import ru.pavlov.CourseProject.entity.CarModel;

@Service
public interface CarsAtParkingService {
    Integer CalcAtParkingCarsById(String email);
    void SaveNewCarModel(Car car);
    CarModel MapToCarModel(Car car);
}
