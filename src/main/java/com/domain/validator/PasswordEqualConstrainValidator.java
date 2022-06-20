package com.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.domain.dto.MemberRequestData;

public class PasswordEqualConstrainValidator implements
        ConstraintValidator<PasswordEqualConstrain, Object> {

    @Override
    public boolean isValid(Object data, ConstraintValidatorContext context) {
        MemberRequestData memberRequestData = (MemberRequestData) data;
        return memberRequestData.getMemberPassword().equals(memberRequestData.getRetypeMemberPassword());
    }


}
