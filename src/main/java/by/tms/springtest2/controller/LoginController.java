package by.tms.springtest2.controller;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserAuthorizationServiceException;
import by.tms.springtest2.exceptions.UserDoesntExistServiceException;
import by.tms.springtest2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ModelAndView log(ModelAndView modelAndView) {
        System.out.println("INDEX CONTROLLER");
        return new ModelAndView("login", "logUser", new User());
    }

    @PostMapping
    public ModelAndView logUser(@Valid @ModelAttribute("logUser") User user, BindingResult bindingResult,
                                ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("login");
        try {
            if (userService.findUser(user, request)) {
                modelAndView.setViewName("redirect:/");
            }
        } catch (UserDoesntExistServiceException e) {
            bindingResult.rejectValue("email", "error.user", e.getMessage());
        }catch (UserAuthorizationServiceException e) {
            bindingResult.rejectValue("pass", "error.user", e.getMessage());
//            throw new UserFindException(e.getMessage());
        }
        return modelAndView;
    }
}
