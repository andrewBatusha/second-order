package com.coursework.demo.mapper;


import com.coursework.demo.dto.EngineerDTO;
import com.coursework.demo.entity.Engineer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EngineerMapper {

    EngineerDTO convertToDto(Engineer engineer);

    Engineer convertToEntity(EngineerDTO engineerDTO);

    List<EngineerDTO> convertToDtoList(List<Engineer> engineers);

}
