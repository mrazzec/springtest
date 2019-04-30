package by.tms.springtest2.controller;

import by.tms.springtest2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/")
public class IndexController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("index", "users", userService.findAll());
    }
}
