package ru.urfu.test_security2db_themeleaf.service;

import ru.urfu.test_security2db_themeleaf.dto.UserDto;
import ru.urfu.test_security2db_themeleaf.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
