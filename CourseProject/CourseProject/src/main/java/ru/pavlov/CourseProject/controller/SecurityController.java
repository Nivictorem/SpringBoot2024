package ru.pavlov.CourseProject.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.pavlov.CourseProject.dto.UserDto;
import ru.pavlov.CourseProject.entity.Car;
import ru.pavlov.CourseProject.entity.Role;
import ru.pavlov.CourseProject.entity.User;
import ru.pavlov.CourseProject.repository.RoleRepository;
import ru.pavlov.CourseProject.repository.UserRepository;
import ru.pavlov.CourseProject.service.GetRoleService;
import ru.pavlov.CourseProject.service.GetUsernameService;
import ru.pavlov.CourseProject.service.UserActionService;
import ru.pavlov.CourseProject.service.UserService;

import java.util.*;

@Controller
public class SecurityController {
    private UserService userService;
    private UserRepository userRepository;
    private GetUsernameService getUsernameService;
    private GetRoleService getRoleService;
    private UserActionService userActionService;

    public SecurityController(UserService userService,
                              UserRepository userRepository,
                              GetUsernameService getUsernameService,
                              GetRoleService getRoleService,
                              UserActionService userActionService) {
        this.getUsernameService = getUsernameService;
        this.userRepository = userRepository;
        this.userService = userService;
        this.getRoleService = getRoleService;
        this.userActionService = userActionService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about-form";
    }

    @GetMapping("/login")
    public String login() {
        if (userRepository.findByEmail("ybrbx98@mail.ru") == null) {
            setAdminAccount();
        }
        return "login";
    }
    private void setAdminAccount()
    {
        UserDto userDto = new UserDto();
        userDto.setRole("ROLE_ADMIN");
        userDto.setLastName("Pavlov");
        userDto.setFirstName("Nikita");
        userDto.setEmail("ybrbx98@mail.ru");
        userDto.setPassword("1");
        userService.saveUser(userDto);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());
        if (existingUser != null &&
                existingUser.getEmail() != null &&
                !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null,
                    "На этот адрес электронной почты уже зарегистрирована учетный адрес");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";

        }
        userDto.setRole("ROLE_USER");
        userService.saveUser(userDto);
        return "redirect:/login";

    }

    @GetMapping("/users")
    public String users(Model model) {
        User user = userService.findUserByEmail(getUsernameService.getusername());
        List<UserDto> users = userService.findAllUsers();
        if (getRoleService.getRoleCurrentUser().equals("ROLE_ADMIN"))
        {
            model.addAttribute("mainUserRole", "ROLE_ADMIN");
        }
        else
        {
            model.addAttribute("mainUserRole", "ROLE_USER");
        }
        model.addAttribute("users", users);
        userActionService.setUserAction("connection to users");
        return "users";
    }
    @PostMapping("/saveRole")
    public String saveRole(@ModelAttribute UserDto userDto)
    {
        String r = userDto.getRole();
        userService.saveUserRole(userDto);
        userActionService.setUserAction("save new role");
        return "redirect:/users";
    }
    @GetMapping("/addNewRole")
    public ModelAndView addNewRole(@RequestParam String userEmail)//@RequestParam String userEmail
    {
        ModelAndView mav = new ModelAndView("add-new-role");
        UserDto user = userService.mapToUserDto(userService.findUserByEmail(userEmail));
        mav.addObject("user", user);
        userActionService.setUserAction("modify role");
        return mav;
    }
}