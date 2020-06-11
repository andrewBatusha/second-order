package com.coursework.demo.entity;

import com.coursework.demo.entity.enums.LicenseStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "driver_licenses")
public class DriverLicense implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String licenceId;

    @Enumerated(EnumType.STRING)
    private LicenseStatus licenseStatus;
}