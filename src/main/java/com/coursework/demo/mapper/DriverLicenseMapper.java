package com.coursework.demo.mapper;

import com.coursework.demo.dto.DriverLicenseDTO;
import com.coursework.demo.entity.DriverLicense;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverLicenseMapper {

    DriverLicenseDTO convertToDto(DriverLicense driverLicense);

    DriverLicense convertToEntity(DriverLicenseDTO driverLicenseDTO);

    List<DriverLicenseDTO> convertToDtoList(List<DriverLicense> licens);

}
