package com.coursework.demo.entity;

import com.coursework.demo.entity.enums.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "passports")
public class Passport implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String surname;

    private String patronymic;

    private int age;

    private String birthplace;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(name = "passport_number")
    private String passportId;

}
