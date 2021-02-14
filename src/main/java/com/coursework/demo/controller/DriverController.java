package com.coursework.demo.controller;

import com.coursework.demo.dto.DriverDTO;
import com.coursework.demo.entity.Driver;
import com.coursework.demo.mapper.DriverMapper;
import com.coursework.demo.service.DriverService;
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
@Api(tags = "Driver API")
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;
    private final DriverMapper driverMapper;

    @Autowired
    public DriverController(DriverService driverService, DriverMapper driverMapper) {
        this.driverService = driverService;
        this.driverMapper = driverMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get driver info by id")
    public ResponseEntity<DriverDTO> get(@PathVariable("id") long id){
        Driver driver = driverService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(driverMapper.convertToDto(driver));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all drivers")
    public ResponseEntity<List<DriverDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(driverMapper.convertToDtoList(driverService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new driver")
    public ResponseEntity<DriverDTO> save(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverService.save(driverMapper.convertToEntity(driverDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(driverMapper.convertToDto(driver));

    }

    @PutMapping
    @ApiOperation(value = "Update existing driver by id")
    public ResponseEntity<DriverDTO> update(@RequestBody DriverDTO driverDTO) {
        Driver driver = driverService.update(driverMapper.convertToEntity(driverDTO));
        return ResponseEntity.status(HttpStatus.OK).body(driverMapper.convertToDto(driver));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete driver by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Driver driver = driverService.getById(id);
        driverService.delete(driver);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
