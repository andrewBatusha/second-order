package com.coursework.demo.controller;

import com.coursework.demo.dto.LicenseDTO;
import com.coursework.demo.entity.License;
import com.coursework.demo.mapper.LicenсeMapper;
import com.coursework.demo.service.LicenseService;
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
public class LicenceController {

    private final LicenseService licenseService;
    private final LicenсeMapper licenсeMapper;

    @Autowired
    public LicenceController(LicenseService licenseService, LicenсeMapper licenсeMapper) {
        this.licenseService = licenseService;
        this.licenсeMapper = licenсeMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get licence info by id")
    public ResponseEntity<LicenseDTO> get(@PathVariable("id") long id){
        License license = licenseService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(licenсeMapper.convertToDto(license));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all licences")
    public ResponseEntity<List<LicenseDTO>> list() {
        return ResponseEntity.ok().body(licenсeMapper.convertToDtoList(licenseService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new licence")
    public ResponseEntity<LicenseDTO> save(@RequestBody LicenseDTO licenseDTO) {
        License license = licenseService.save(licenсeMapper.convertToEntity(licenseDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(licenсeMapper.convertToDto(license));
    }

    @PutMapping
    @ApiOperation(value = "Update existing licence by id")
    public ResponseEntity<LicenseDTO> update(@RequestBody LicenseDTO licenseDTO) {
        License license = licenseService.update(licenсeMapper.convertToEntity(licenseDTO));
        return ResponseEntity.status(HttpStatus.OK).body(licenсeMapper.convertToDto(license));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete licence by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        License license = licenseService.getById(id);
        licenseService.delete(license);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
