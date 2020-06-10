package com.coursework.demo.mapper;

import com.coursework.demo.dto.StationDTO;
import com.coursework.demo.entity.Station;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StationMapper {

    StationDTO convertToDto(Station station);

    Station convertToEntity(StationDTO stationDTO);

    List<StationDTO> convertToDtoList(List<Station> stations);

}