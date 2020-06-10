package com.coursework.demo.mapper;

import com.coursework.demo.dto.LuggageDTO;
import com.coursework.demo.entity.Luggage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LuggageMapper {

    LuggageDTO convertToDto(Luggage luggage);

    Luggage convertToEntity(LuggageDTO luggageDTO);

    List<LuggageDTO> convertToDtoList(List<Luggage> luggageList);

}
