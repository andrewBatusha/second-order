package com.coursework.demo.controller;

import com.coursework.demo.dto.EngineerDTO;
import com.coursework.demo.entity.Engineer;
import com.coursework.demo.mapper.EngineerMapper;
import com.coursework.demo.service.EngineerService;
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
@Api(tags = "Engineer API")
@RequestMapping("/engineers")
public class EngineerController {

    private final EngineerService engineerService;
    private final EngineerMapper engineerMapper;

    @Autowired
    public EngineerController(EngineerService engineerService, EngineerMapper engineerMapper) {
        this.engineerService = engineerService;
        this.engineerMapper = engineerMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get engineer info by id")
    public ResponseEntity<EngineerDTO> get(@PathVariable("id") long id) {
        Engineer engineer = engineerService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(engineerMapper.convertToDto(engineer));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all engineers")
    public ResponseEntity<List<EngineerDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(engineerMapper.convertToDtoList(engineerService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new engineer")
    public ResponseEntity<EngineerDTO> save(@RequestBody EngineerDTO engineerDTO) {
        Engineer engineer = engineerService.save(engineerMapper.convertToEntity(engineerDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(engineerMapper.convertToDto(engineer));
    }

    @PutMapping
    @ApiOperation(value = "Update existing engineer by id")
    public ResponseEntity<EngineerDTO> update(@RequestBody EngineerDTO engineerDTO) {
        Engineer engineer = engineerService.update(engineerMapper.convertToEntity(engineerDTO));
        return ResponseEntity.status(HttpStatus.OK).body(engineerMapper.convertToDto(engineer));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete engineer by id")
    public ResponseEntity delete(@PathVariable("id") long id) {
        Engineer engineer = engineerService.getById(id);
        engineerService.delete(engineer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
