package com.coursework.demo.controller;

import com.coursework.demo.dto.BusDTO;
import com.coursework.demo.entity.Bus;
import com.coursework.demo.mapper.BusMapper;
import com.coursework.demo.service.BusService;
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
@Api(tags = "Bus API")
@RequestMapping("v1/buses")
public class BusController {

    private final BusService busService;
    private final BusMapper busMapper;

    @Autowired
    public BusController(BusService busService, BusMapper busMapper) {
        this.busService = busService;
        this.busMapper = busMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get bus info by id")
    public ResponseEntity<BusDTO> get(@PathVariable("id") long id){
        Bus bus = busService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(busMapper.convertToDto(bus));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all buses")
    public ResponseEntity<List<BusDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(busMapper.convertToDtoList(busService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new bus")
    public ResponseEntity<BusDTO> save(@RequestBody BusDTO passportDTO) {
        Bus bus = busService.save(busMapper.convertToEntity(passportDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(busMapper.convertToDto(bus));
    }

    @PutMapping
    @ApiOperation(value = "Update existing bus by id")
    public ResponseEntity<BusDTO> update(@RequestBody BusDTO busDTO) {
        Bus bus = busService.update(busMapper.convertToEntity(busDTO));
        return ResponseEntity.status(HttpStatus.OK).body(busMapper.convertToDto(bus));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete bus by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Bus bus = busService.getById(id);
        busService.delete(bus);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
