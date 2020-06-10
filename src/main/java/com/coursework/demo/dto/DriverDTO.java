package com.coursework.demo.dto;

import com.coursework.demo.entity.License;
import com.coursework.demo.entity.Passport;
import lombok.Data;

@Data
public class DriverDTO {
    private long id;

    private License license;

    private Passport passport;
}
