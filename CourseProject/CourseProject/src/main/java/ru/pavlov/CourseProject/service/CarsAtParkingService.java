package ru.pavlov.CourseProject.service;

import org.springframework.stereotype.Service;

@Service
public interface CarsAtParkingService {
    Integer CalcAtParkingCarsById(String email);
}
