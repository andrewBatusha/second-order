package com.coursework.demo.controller;

import com.coursework.demo.dto.PassengerDTO;
import com.coursework.demo.entity.Passenger;
import com.coursework.demo.mapper.PassengerMapper;
import com.coursework.demo.service.PassengerService;
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
@Api(tags = "Passenger API")
@RequestMapping("v1/passengers")
public class PassengerController {

    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;

    @Autowired
    public PassengerController(PassengerService passengerService, PassengerMapper passengerMapper) {
        this.passengerService = passengerService;
        this.passengerMapper = passengerMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get passenger info by id")
    public ResponseEntity<PassengerDTO> get(@PathVariable("id") long id){
        Passenger passenger = passengerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(passengerMapper.convertToDto(passenger));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all passengers")
    public ResponseEntity<List<PassengerDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(passengerMapper.convertToDtoList(passengerService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new passenger")
    public ResponseEntity<PassengerDTO> save(@RequestBody PassengerDTO passengerDTO) {
        Passenger passenger = passengerService.save(passengerMapper.convertToEntity(passengerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(passengerMapper.convertToDto(passenger));
    }

    @PutMapping
    @ApiOperation(value = "Update existing passenger by id")
    public ResponseEntity<PassengerDTO> update(@RequestBody PassengerDTO passengerDTO) {
        Passenger passenger = passengerService.update(passengerMapper.convertToEntity(passengerDTO));
        return ResponseEntity.status(HttpStatus.OK).body(passengerMapper.convertToDto(passenger));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete passenger by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Passenger passenger = passengerService.getById(id);
        passengerService.delete(passenger);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
