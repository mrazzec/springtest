package by.tms.springtest2.controller;

import by.tms.springtest2.entity.User;
import by.tms.springtest2.exceptions.UserFindException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExController {

  @ExceptionHandler(ArithmeticException.class)
  public String ex(Model model, Exception e) {
    model.addAttribute("error", e.getMessage());
    return "registration";
  }

    @ExceptionHandler(UserFindException.class)
    public String exc(Model model, Exception e) {
        model.addAttribute("userException", e.getMessage());
        model.addAttribute("logUser", new User());
        return "login";
    }
}
