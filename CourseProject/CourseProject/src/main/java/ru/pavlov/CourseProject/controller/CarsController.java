package ru.pavlov.CourseProject.controller;


import ch.qos.logback.classic.BasicConfigurator;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pavlov.CourseProject.entity.Car;
import ru.pavlov.CourseProject.repository.CarsRepository;
import ru.pavlov.CourseProject.repository.UserActionsRepository;
import ru.pavlov.CourseProject.service.GetUsernameService;
import ru.pavlov.CourseProject.service.GetUsernameServiceImp;
import ru.pavlov.CourseProject.service.UserService;

import java.util.Optional;

@Slf4j
@Controller
public class CarsController {
    @Autowired
    private CarsRepository carsRepository;
    private GetUsernameService getUsernameService;
    public CarsController(GetUsernameService getUsernameService)
    {
        this.getUsernameService = getUsernameService;
    }

    @Autowired
    private UserActionsRepository userActionsRepository;
    @GetMapping("/list")
    public ModelAndView getAllCar() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-cars");
        mav.addObject("cars", carsRepository.findAll());
        return mav;
    }
    @GetMapping("/userActions")
    public ModelAndView getAllLogs() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-actions");
        mav.addObject("userActions", userActionsRepository.findAll());
        return mav;
    }
    @GetMapping("/addCarForm")
    public ModelAndView addStudentForm()
    {
        ModelAndView mav = new ModelAndView("add-car-form");
        Car car = new Car();
        mav.addObject("car", car);
        return mav;
    }
    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute Car car)
    {
        car.setEmail(getUsernameService.getusername());
        carsRepository.save(car);
        return "redirect:/list";
    }
    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long carId)
    {
        ModelAndView mav = new ModelAndView("add-car-form");
        Optional<Car> optionalCar = carsRepository.findById(carId);
        Car car = new Car();
        if(optionalCar.isPresent())
        {
            car = optionalCar.get();
        }
        mav.addObject("car", car);
        return mav;
    }
    @GetMapping("/deleteCar")
    public String deleteStudent(@RequestParam Long carId)
    {
        carsRepository.deleteById(carId);
        return "redirect:/list";
    }
}
