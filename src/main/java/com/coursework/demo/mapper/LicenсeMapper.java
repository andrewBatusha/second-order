package com.coursework.demo.mapper;

import com.coursework.demo.dto.LicenseDTO;
import com.coursework.demo.entity.License;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LicenсeMapper {

    LicenseDTO convertToDto(License license);

    License convertToEntity(LicenseDTO licenseDTO);

    List<LicenseDTO> convertToDtoList(List<License> licenses);

}
