package com.coursework.demo.dto;

import com.coursework.demo.entity.enums.LicenseStatus;
import lombok.Data;

@Data
public class LicenceDTO {
    private long id;

    private String licenceId;

    private LicenseStatus licenseStatus;
}
