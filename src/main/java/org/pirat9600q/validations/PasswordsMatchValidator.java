package org.pirat9600q.validations;

import org.pirat9600q.validations.annotations.PasswordsMatch;
import org.pirat9600q.validations.contracts.PasswordConfirmation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, PasswordConfirmation> {

    private String violationProperty;

    @Override
    public void initialize(PasswordsMatch constraintAnnotation) {
        violationProperty = constraintAnnotation.violationProperty();
    }

    @Override
    public boolean isValid(PasswordConfirmation value, ConstraintValidatorContext context) {
        if(value.getPassword() == null || value.getConfirmPassword() == null) {
            return true;
        }
        else {
            boolean isValid = value.getPassword().equals(value.getConfirmPassword());
            if(!isValid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode(violationProperty)
                        .addConstraintViolation();
            }
            return isValid;
        }
    }
}
