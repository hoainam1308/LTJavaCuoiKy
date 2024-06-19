package com.example.CuoiKy.validator.annotation;


import com.example.CuoiKy.validator.ValidBorrowIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidBorrowIdValidator.class)
public @interface ValidBorrowId {
    String message() default "Invalid Borrow ID";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
