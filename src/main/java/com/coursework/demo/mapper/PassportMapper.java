package com.coursework.demo.mapper;

import com.coursework.demo.dto.PassportDTO;
import com.coursework.demo.entity.Passport;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    PassportDTO convertToDto(Passport passport);

    Passport convertToEntity(PassportDTO passportDTO);

    List<PassportDTO> convertToDtoList(List<Passport> passports);

}
