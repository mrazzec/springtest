package by.tms.springtest2.controller;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserFindException;
import by.tms.springtest2.exceptions.UserFindServiceException;
import by.tms.springtest2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ModelAndView log(ModelAndView modelAndView) {
        return new ModelAndView("login", "logUser", new User());
    }

    @PostMapping
    public ModelAndView logUser(@ModelAttribute("logUser") User user, ModelAndView modelAndView,
                                HttpServletRequest request) {

        modelAndView.setViewName("login");
        try {
            if (userService.findUser(user, request)) {
                modelAndView.setViewName("index");
            }
        } catch (UserFindServiceException e) {
            throw new UserFindException(e.getMessage());
        }
        return modelAndView;
    }
}
