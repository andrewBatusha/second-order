package com.coursework.demo.controller;

import com.coursework.demo.dto.PassportDTO;
import com.coursework.demo.entity.Passport;
import com.coursework.demo.mapper.PassportMapper;
import com.coursework.demo.service.PassportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Api(tags = "Passport API")
@RequestMapping("v1/passports")
public class PassportController {

    private final PassportService passportService;
    private final PassportMapper passportMapper;

    @Autowired
    public PassportController(PassportService passportService, PassportMapper passportMapper) {
        this.passportService = passportService;
        this.passportMapper = passportMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get passport info by id")
    public ResponseEntity<PassportDTO> get(@PathVariable("id") long id) {
        Passport passport = passportService.getById(id);
        return ResponseEntity.status(OK).body(passportMapper.convertToDto(passport));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all passports")
    public ResponseEntity<List<PassportDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(passportMapper.convertToDtoList(passportService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new passport")
    public ResponseEntity<PassportDTO> save(@RequestBody PassportDTO passportDTO) {
        Passport passport = passportService.save(passportMapper.convertToEntity(passportDTO));
        return ResponseEntity.status(CREATED).body(passportMapper.convertToDto(passport));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update existing passport by id")
    public ResponseEntity<PassportDTO> update(@PathVariable("id") long id, @RequestBody PassportDTO passportDTO) {
        if (id == passportDTO.getId()) {
            Passport passport = passportService.update(passportMapper.convertToEntity(passportDTO));
            return ResponseEntity.status(OK).body(passportMapper.convertToDto(passport));
        } else {
            return ResponseEntity.status(BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete passport by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Passport passport = passportService.getById(id);
        passportService.delete(passport);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
