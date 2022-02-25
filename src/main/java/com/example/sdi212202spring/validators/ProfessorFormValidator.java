package com.example.sdi212202spring.validators;

import com.example.sdi212202spring.entities.Professor;
import com.example.sdi212202spring.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProfessorFormValidator implements Validator {

    @Autowired
    private ProfessorService professorService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Professor.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Professor professor = (Professor) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "professor", "Error.empty");

        if (!(professor.getDni().length() == 8 && Character.isLetter(professor.getDni().charAt(professor.getDni().length())))) {
            errors.rejectValue("dni", "Error.professor.dni.format");
        }
        if (!(professorService.getProfessorByDni(professor.getDni()) != null)) {
            errors.rejectValue("dni", "Error.professor.dni.duplicate");
        }

    }
}