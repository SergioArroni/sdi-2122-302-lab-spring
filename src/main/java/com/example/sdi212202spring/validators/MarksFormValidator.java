package com.example.sdi212202spring.validators;

import com.example.sdi212202spring.entities.Mark;
import com.example.sdi212202spring.entities.User;
import com.example.sdi212202spring.service.MarksService;
import com.example.sdi212202spring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MarksFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Mark.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Mark mark = (Mark) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "score", "Error.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Error.empty");

        if (!(mark.getScore() >= 0 && mark.getScore() <= 10 )) {
            errors.rejectValue("score", "Error.mark.score.value");
        }
        if (!(mark.getDescription().length() >= 20)) {
            errors.rejectValue("description", "Error.mark.description.length");
        }

    }
}