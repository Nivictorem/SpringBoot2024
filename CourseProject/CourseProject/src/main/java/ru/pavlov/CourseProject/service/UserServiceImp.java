package ru.pavlov.CourseProject.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.pavlov.CourseProject.dto.UserDto;
import ru.pavlov.CourseProject.entity.Role;
import ru.pavlov.CourseProject.entity.User;
import ru.pavlov.CourseProject.repository.RoleRepository;
import ru.pavlov.CourseProject.repository.UserRepository;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final GetUsernameService getUsernameService;

    @Autowired
    public UserServiceImp(UserRepository userRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder,
                          GetUsernameService getUsernameService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.getUsernameService = getUsernameService;
    }

    @Override
    public void saveUserRole(UserDto userDTO) {

        User user = findUserByEmail(userDTO.getEmail());
        Role role = checkRoleExist(userDTO.getRole());
        role = roleRepository.findById(role.getId()).get();
        user.getRoles().remove(0);
        user.getRoles().add(role);
        userRepository.save(user);
        user = findUserByEmail(userDTO.getEmail());
        var a = 0;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName(userDto.getRole());
        if (role == null) {
            role = checkRoleExist(userDto.getRole());
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        if (!user.getRoles().stream().filter(x -> Objects.equals(x.getName(), "ROLE_ADMIN")).toList().isEmpty()) {
            userDto.setRole("ROLE_ADMIN");
        } else {
            userDto.setRole("ROLE_USER");
        }
        return userDto;
    }

    private Role checkRoleExist(String roleString) {
        Role role = new Role();
        role.setName(roleString);
        if(roleRepository.findByName(roleString)==null)
            return roleRepository.save(role);
        return roleRepository.findByName(roleString);
    }

}