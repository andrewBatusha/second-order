package com.coursework.demo.dto;

import com.coursework.demo.entity.DriverLicense;
import com.coursework.demo.entity.Passport;
import lombok.Data;

@Data
public class DriverDTO {
    private long id;

    private DriverLicense driverLicense;

    private Passport passport;
}
