package com.coursework.demo.controller;

import com.coursework.demo.dto.LicenceDTO;
import com.coursework.demo.entity.Licence;
import com.coursework.demo.mapper.LicenceMapper;
import com.coursework.demo.service.LicenceService;
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
@RequestMapping("/licences")
public class LicenceController {

    private final LicenceService licenceService;
    private final LicenceMapper licenceMapper;

    @Autowired
    public LicenceController(LicenceService licenceService, LicenceMapper licenceMapper) {
        this.licenceService = licenceService;
        this.licenceMapper = licenceMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get licence info by id")
    public ResponseEntity<LicenceDTO> get(@PathVariable("id") long id){
        Licence licence = licenceService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(licenceMapper.convertToDto(licence));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all licences")
    public ResponseEntity<List<LicenceDTO>> list() {
        return ResponseEntity.ok().body(licenceMapper.convertToDtoList(licenceService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new licence")
    public ResponseEntity<LicenceDTO> save(@RequestBody LicenceDTO licenceDTO) {
        Licence licence = licenceService.save(licenceMapper.convertToEntity(licenceDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(licenceMapper.convertToDto(licence));
    }

    @PutMapping
    @ApiOperation(value = "Update existing licence by id")
    public ResponseEntity<LicenceDTO> update(@RequestBody LicenceDTO licenceDTO) {
        Licence licence = licenceService.update(licenceMapper.convertToEntity(licenceDTO));
        return ResponseEntity.status(HttpStatus.OK).body(licenceMapper.convertToDto(licence));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete licence by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Licence licence = licenceService.getById(id);
        licenceService.delete(licence);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
