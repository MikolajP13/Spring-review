package com.mp.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;

        if (code != null) {
            result = code.startsWith(coursePrefix);
        } else {
            result = true;
        }

        return result;
    }

    @Override
    public void initialize(CourseCode courseCode) {
        this.coursePrefix = courseCode.value();
    }
}
