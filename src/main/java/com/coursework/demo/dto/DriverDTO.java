package com.coursework.demo.dto;

import com.coursework.demo.entity.Engineer;
import com.coursework.demo.entity.Passport;
import com.coursework.demo.entity.Position;
import lombok.Data;

@Data
public class DriverDTO {
    private long id;

    private Position position;

    private Passport passport;

    private Engineer engineer;
}
