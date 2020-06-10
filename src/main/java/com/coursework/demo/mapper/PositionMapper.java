package com.coursework.demo.mapper;

import com.coursework.demo.dto.PositionDTO;
import com.coursework.demo.entity.Position;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {

    PositionDTO convertToDto(Position position);

    Position convertToEntity(PositionDTO positionDTO);

    List<PositionDTO> convertToDtoList(List<Position> positions);

}
