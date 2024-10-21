package ru.pavlov.CourseProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavlov.CourseProject.entity.CarModel;
import ru.pavlov.CourseProject.repository.CarModelRepository;
import ru.pavlov.CourseProject.repository.CarsRepository;

import ru.pavlov.CourseProject.entity.Car;

import java.util.Objects;
import java.util.Optional;

@Service
public class CarsAtParkingServiceImp implements CarsAtParkingService{
    @Autowired
    CarsRepository carsRepository;
    @Autowired
    CarModelRepository carModelRepository;
    @Override
    public Integer CalcAtParkingCarsById(String email)
    {
        return carsRepository.findByEmail(email).size();
    }

    @Override
    public void SaveNewCarModel(Car car) {
        CarModel carModel = MapToCarModel(car);
        if(carModelRepository.findByBrand(carModel.getBrand())
                .stream()
                .noneMatch(x-> Objects.equals(x.getWorth(), car.getWorth())))
        {
            carModelRepository.save(carModel);
        }
    }

    @Override
    public CarModel MapToCarModel(Car car) {
        CarModel carModel = new CarModel();
        carModel.setBrand(car.getBrand());
        carModel.setWorth(car.getWorth());
        return carModel;
    }
}
