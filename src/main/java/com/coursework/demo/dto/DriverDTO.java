package com.coursework.demo.dto;

import com.coursework.demo.entity.Engineer;
import com.coursework.demo.entity.Passport;
import com.coursework.demo.entity.Licence;
import lombok.Data;

@Data
public class DriverDTO {
    private long id;

    private Licence licence;

    private Passport passport;

    private Engineer engineer;
}
