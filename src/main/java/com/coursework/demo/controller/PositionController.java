package com.coursework.demo.controller;

import com.coursework.demo.dto.PositionDTO;
import com.coursework.demo.entity.Position;
import com.coursework.demo.mapper.PositionMapper;
import com.coursework.demo.service.PositionService;
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
@Api(tags = "Position API")
@RequestMapping("/positions")
public class PositionController {

    private final PositionService positionService;
    private final PositionMapper positionMapper;

    @Autowired
    public PositionController(PositionService positionService, PositionMapper positionMapper) {
        this.positionService = positionService;
        this.positionMapper = positionMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get position info by id")
    public ResponseEntity<PositionDTO> get(@PathVariable("id") long id){
        Position position = positionService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(positionMapper.convertToDto(position));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all positions")
    public ResponseEntity<List<PositionDTO>> list() {
        return ResponseEntity.ok().body(positionMapper.convertToDtoList(positionService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new position")
    public ResponseEntity<PositionDTO> save(@RequestBody PositionDTO positionDTO) {
        Position position = positionService.save(positionMapper.convertToEntity(positionDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(positionMapper.convertToDto(position));
    }

    @PutMapping
    @ApiOperation(value = "Update existing position by id")
    public ResponseEntity<PositionDTO> update(@RequestBody PositionDTO positionDTO) {
        Position position = positionService.update(positionMapper.convertToEntity(positionDTO));
        return ResponseEntity.status(HttpStatus.OK).body(positionMapper.convertToDto(position));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete position by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Position position = positionService.getById(id);
        positionService.delete(position);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
