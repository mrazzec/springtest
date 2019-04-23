package by.tms.springtest2.controller;

import by.tms.springtest2.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegController {

    @GetMapping
    public ModelAndView reg(ModelAndView modelAndView) {
        modelAndView.setViewName("registration");
        modelAndView.addObject("newUser", new User());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView newUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult,
                          ModelAndView modelAndView, HttpSession session) {

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            session.setAttribute("user", user);
            modelAndView.setViewName("redirect:/");
        }

        if (user.getName().equals("Devil")) {
            throw new ArithmeticException("Bad name");
        }

        return modelAndView;
    }
}
