package by.tms.springtest2.controller;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ModelAndView reg() {
        return new ModelAndView("registration", "newUser", new User());
    }

    @PostMapping
    public ModelAndView newUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult,
                                ModelAndView modelAndView) {

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.setViewName("redirect:/login");
        }

        if (user.getName().equals("Devil")) {
            throw new ArithmeticException("Bad name");
        }

        return modelAndView;
    }
}
