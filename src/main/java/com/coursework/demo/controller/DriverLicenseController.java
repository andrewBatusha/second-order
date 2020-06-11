package com.coursework.demo.controller;

import com.coursework.demo.dto.DriverLicenseDTO;
import com.coursework.demo.entity.DriverLicense;
import com.coursework.demo.mapper.DriverLicenseMapper;
import com.coursework.demo.service.DriverLicenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "Licence API")
@RequestMapping("/licenses")
public class DriverLicenseController {

    private final DriverLicenseService driverLicenseService;
    private final DriverLicenseMapper driverLicenseMapper;

    @Autowired
    public DriverLicenseController(DriverLicenseService driverLicenseService, DriverLicenseMapper driverLicenseMapper) {
        this.driverLicenseService = driverLicenseService;
        this.driverLicenseMapper = driverLicenseMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get license info by id")
    public ResponseEntity<DriverLicenseDTO> get(@PathVariable("id") long id){
        DriverLicense driverLicense = driverLicenseService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(driverLicenseMapper.convertToDto(driverLicense));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all driver licenses")
    public ResponseEntity<List<DriverLicenseDTO>> list() {
        return ResponseEntity.ok().body(driverLicenseMapper.convertToDtoList(driverLicenseService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new driver license")
    public ResponseEntity<DriverLicenseDTO> save(@RequestBody DriverLicenseDTO driverLicenseDTO) {
        DriverLicense driverLicense = driverLicenseService.save(driverLicenseMapper.convertToEntity(driverLicenseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(driverLicenseMapper.convertToDto(driverLicense));
    }

    @PutMapping
    @ApiOperation(value = "Update existing driver license by id")
    public ResponseEntity<DriverLicenseDTO> update(@RequestBody DriverLicenseDTO driverLicenseDTO) {
        DriverLicense driverLicense = driverLicenseService.update(driverLicenseMapper.convertToEntity(driverLicenseDTO));
        return ResponseEntity.status(HttpStatus.OK).body(driverLicenseMapper.convertToDto(driverLicense));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete driver License by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        DriverLicense driverLicense = driverLicenseService.getById(id);
        driverLicenseService.delete(driverLicense);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
