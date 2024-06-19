package com.example.CuoiKy.validator;


import com.example.CuoiKy.entity.Borrow;

import com.example.CuoiKy.validator.annotation.ValidBorrowId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidBorrowIdValidator implements ConstraintValidator<ValidBorrowId, Borrow> {
    @Override
    public boolean isValid(Borrow borrow, ConstraintValidatorContext context){
        return borrow != null && borrow.getId() != null;
    }
}
