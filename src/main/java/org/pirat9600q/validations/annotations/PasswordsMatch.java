package org.pirat9600q.validations.annotations;


import org.pirat9600q.validations.PasswordsMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = PasswordsMatchValidator.class)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordsMatch {

    String message() default "{org.pirat9600q.passwordConfirmation.passwordsDoesNotMatch}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String violationProperty() default "confirmPassword";
}
