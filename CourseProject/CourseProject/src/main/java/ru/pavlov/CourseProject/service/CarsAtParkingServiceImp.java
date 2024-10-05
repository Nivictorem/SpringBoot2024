package ru.pavlov.CourseProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavlov.CourseProject.repository.CarsRepository;

@Service
public class CarsAtParkingServiceImp implements CarsAtParkingService{
    @Autowired
    CarsRepository carsRepository;
    @Override
    public Integer CalcAtParkingCarsById(String email)
    {
        return carsRepository.findByEmail(email).size();
    }
}
