package com.coursework.demo.dto;

import com.coursework.demo.entity.Passport;
import lombok.Data;

@Data
public class PassengerDTO {
    private long id;

    private Passport passport;
}
