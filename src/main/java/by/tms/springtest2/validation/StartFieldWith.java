package by.tms.springtest2.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartFieldWithConstaintValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartFieldWith {

    public String value() default "XX";

    public String message() default "должно начинаться с XX";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
