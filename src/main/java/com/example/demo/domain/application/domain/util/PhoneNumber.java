package com.example.demo.domain.application.domain.util;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class PhoneNumber {

    @Pattern(regexp="^0(\\d{2})(\\d{4})(\\d{4})")
    private String phoneNumber;

}
