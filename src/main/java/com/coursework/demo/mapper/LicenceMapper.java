package com.coursework.demo.mapper;

import com.coursework.demo.dto.LicenceDTO;
import com.coursework.demo.entity.Licence;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LicenceMapper {

    LicenceDTO convertToDto(Licence licence);

    Licence convertToEntity(LicenceDTO licenceDTO);

    List<LicenceDTO> convertToDtoList(List<Licence> licences);

}
