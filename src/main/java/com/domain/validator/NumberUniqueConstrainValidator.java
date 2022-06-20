package com.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.domain.models.repos.MemberRepo;

public class NumberUniqueConstrainValidator implements ConstraintValidator<NumberUniqueConstrain, String> {

    @Autowired
    private MemberRepo memberRepo;

    @Override
    public boolean isValid(String memberNumber, ConstraintValidatorContext context) {
        return !memberRepo.existsMemberByMemberNumber(memberNumber);
    }

}
