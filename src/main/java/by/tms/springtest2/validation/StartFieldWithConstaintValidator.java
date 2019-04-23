package by.tms.springtest2.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartFieldWithConstaintValidator implements ConstraintValidator<StartFieldWith, String> {

    private String prefix;


    @Override
    public void initialize(StartFieldWith constraintAnnotation) {
        prefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;

        if (s != null) {
            result = s.startsWith(prefix);
        } else {
            result = true;
        }

        return result;
    }
}
