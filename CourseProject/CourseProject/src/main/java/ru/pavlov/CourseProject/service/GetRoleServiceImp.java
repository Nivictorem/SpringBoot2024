package ru.pavlov.CourseProject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import ru.pavlov.CourseProject.entity.User;

import java.util.Objects;
@Service
public class GetRoleServiceImp implements GetRoleService{
    private final GetUsernameService getUsernameService;
    private final UserService userService;
    public GetRoleServiceImp(GetUsernameService getUsernameService, UserService userService)
    {
        this.getUsernameService = getUsernameService;
        this.userService = userService;
    }
    @Override
    public String getRoleCurrentUser() {
        User user = userService.findUserByEmail(getUsernameService.getusername());
//        if(!user.getRoles().stream().filter(x-> Objects.equals(x.getName(), "ROLE_ADMIN")).toList().isEmpty())
//        {
//            return "ROLE_ADMIN";
//        }
        return user.getRoles().get(0).getName();
    }
}
