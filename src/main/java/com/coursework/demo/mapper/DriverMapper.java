package com.coursework.demo.mapper;

import com.coursework.demo.dto.DriverDTO;
import com.coursework.demo.entity.Driver;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverDTO convertToDto(Driver driver);

    Driver convertToEntity(DriverDTO driverDTO);

    List<DriverDTO> convertToDtoList(List<Driver> drivers);

}