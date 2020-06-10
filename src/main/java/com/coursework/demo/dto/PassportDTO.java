package com.coursework.demo.dto;

import lombok.Data;

@Data
public class PassportDTO {

    private long id;

    private String name;

    private String surname;

    private String patronymic;

    private int age;

    private String birthplace;

    private String sex;

    private String passportId;
}
