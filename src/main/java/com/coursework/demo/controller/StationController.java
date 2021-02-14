package com.coursework.demo.controller;

import com.coursework.demo.dto.StationDTO;
import com.coursework.demo.entity.Station;
import com.coursework.demo.mapper.StationMapper;
import com.coursework.demo.service.StationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Station API")
@RequestMapping("v1/stations")
public class StationController {

    private final StationService stationService;
    private final StationMapper stationMapper;

    @Autowired
    public StationController(StationService stationService, StationMapper stationMapper) {
        this.stationService = stationService;
        this.stationMapper = stationMapper;
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "Get station info by id")
    public ResponseEntity<StationDTO> get(@PathVariable("id") long id){
        Station station = stationService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(stationMapper.convertToDto(station));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all stations")
    public ResponseEntity<List<StationDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(stationMapper.convertToDtoList(stationService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new station")
    public ResponseEntity<StationDTO> save(@RequestBody StationDTO stationDTO) {
        Station station = stationService.save(stationMapper.convertToEntity(stationDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(stationMapper.convertToDto(station));
    }

    @PutMapping
    @ApiOperation(value = "Update existing station by id")
    public ResponseEntity<StationDTO> update(@RequestBody StationDTO stationDTO) {
        Station station = stationService.update(stationMapper.convertToEntity(stationDTO));
        return ResponseEntity.status(HttpStatus.OK).body(stationMapper.convertToDto(station));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete station by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Station station = stationService.getById(id);
        stationService.delete(station);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
