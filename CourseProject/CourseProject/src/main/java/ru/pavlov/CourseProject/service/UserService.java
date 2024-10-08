package ru.pavlov.CourseProject.service;


import ru.pavlov.CourseProject.dto.UserDto;
import ru.pavlov.CourseProject.entity.User;

import java.util.List;

public interface UserService {
    void saveUserRole(UserDto userDTO);
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();

    UserDto mapToUserDto(User user);
}