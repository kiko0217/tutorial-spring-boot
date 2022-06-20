package com.domain.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.domain.validator.NumberUniqueConstrain;
import com.domain.validator.PasswordEqualConstrain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@PasswordEqualConstrain(message = "Retry password invalid!!")
public class MemberRequestData {

    @NotEmpty(message = "Number is required")
    @Size(min = 3, max = 5, message = "Number length must be in 3 to 5 characters")
    @Pattern(regexp = "MB[0-9]+", message = "Number must be start with \'MB\'")
    @NumberUniqueConstrain(message = "Number already in use")
    private String memberNumber;

    @NotEmpty(message = "Name is required")
    private String memberName;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email address")
    private String memberEmail;

    @NotEmpty(message = "Password is required")
    private String memberPassword;

    @NotEmpty(message = "Retype password is required")
    private String retypeMemberPassword;
}
