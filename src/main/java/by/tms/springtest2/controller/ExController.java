package by.tms.springtest2.controller;

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

    @ExceptionHandler(Exception.class)
    public String exc(Model model, Exception e) {
        model.addAttribute("error", "что то пошло не по плану");
        return "registration";
    }
}
