package com.mp.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // helper class that contains business logic
@Target({ElementType.METHOD, ElementType.FIELD}) // apply annotation to method or field
@Retention(RetentionPolicy.RUNTIME) // how long mark annotation be stored
public @interface CourseCode {

    // define default course code
    public String value() default "NEW";

    // define default error message
    public String message() default "must start with NEW";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {}; // provide custom details about validation failure

}
