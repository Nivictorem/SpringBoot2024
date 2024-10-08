package ru.pavlov.CourseProject.controller;


import ch.qos.logback.classic.LoggerContext;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pavlov.CourseProject.dto.UserDto;
import ru.pavlov.CourseProject.entity.Car;
import ru.pavlov.CourseProject.entity.Role;
import ru.pavlov.CourseProject.entity.User;
import ru.pavlov.CourseProject.repository.CarsRepository;
import ru.pavlov.CourseProject.repository.UserActionsRepository;
import ru.pavlov.CourseProject.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Log4j2
@Slf4j
@Controller
public class CarsController {
    @Autowired
    private CarsRepository carsRepository;
    private GetRoleService getRoleServiceImp;
    private GetUsernameService getUsernameService;
    private UserActionService userActionService;
    public CarsController(GetRoleServiceImp getRoleServiceImp,
                          GetUsernameService getUsernameService,
                          UserActionService userActionService)
    {
        this.getRoleServiceImp = getRoleServiceImp;
        this.getUsernameService = getUsernameService;
        this.userActionService = userActionService;
    }


    @Autowired
    private UserActionsRepository userActionsRepository;
    @GetMapping("/list")
    public ModelAndView getAllCar() {
        ModelAndView mav = new ModelAndView("list-cars");
        if (getRoleServiceImp.getRoleCurrentUser().equals("ROLE_ADMIN"))
        {
            mav.addObject("cars", carsRepository.findAll());
        }
        else
        {
            mav.addObject("cars", carsRepository.findByEmail(getUsernameService.getusername()));
        }
        log.info("/list -> connection");
        userActionService.setUserAction("connection to list-cars");
        return mav;
    }
    @GetMapping("/userActions")
    public ModelAndView getAllLogs() {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-actions");
        mav.addObject("userActions", userActionsRepository.findAll());
        userActionService.setUserAction("connection to list-actions");
        return mav;
    }
    @GetMapping("/CalcCarNumber")
    public ModelAndView calcCarNumber(ModelAndView modelAndView) {
        log.info("/list -> connection");
        ModelAndView mav = new ModelAndView("list-cars");
        mav.addObject("cars", carsRepository.findAll());
        mav.addObject("carNumber", Integer.toString(carsRepository.findAll().size()));
        userActionService.setUserAction("calculate number of car");
        return mav;
    }

    @GetMapping("/addCarForm")
    public ModelAndView addStudentForm()
    {
        ModelAndView mav = new ModelAndView("add-car-form");
        Car car = new Car();
        mav.addObject("car", car);
        userActionService.setUserAction("connection to add-car-form");
        return mav;
    }
    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute Car car)
    {
        car.setEmail(getUsernameService.getusername());
        carsRepository.save(car);
        userActionService.setUserAction("save new car");
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
        userActionService.setUserAction("modify car in database");
        return mav;
    }
    @GetMapping("/deleteCar")
    public String deleteStudent(@RequestParam Long carId)
    {
        carsRepository.deleteById(carId);
        userActionService.setUserAction("delete car in database");
        return "redirect:/list";
    }

}
