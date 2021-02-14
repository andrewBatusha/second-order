package com.coursework.demo.controller;

import com.coursework.demo.dto.LuggageDTO;
import com.coursework.demo.entity.Luggage;
import com.coursework.demo.mapper.LuggageMapper;
import com.coursework.demo.service.LuggageService;
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
@Api(tags = "Luggage API")
@RequestMapping("/luggage")
public class LuggageController {

    private final LuggageService luggageService;
    private final LuggageMapper luggageMapper;

    @Autowired
    public LuggageController(LuggageService luggageService, LuggageMapper luggageMapper) {
        this.luggageService = luggageService;
        this.luggageMapper = luggageMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get luggage info by id")
    public ResponseEntity<LuggageDTO> get(@PathVariable("id") long id){
        Luggage luggage = luggageService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(luggageMapper.convertToDto(luggage));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all luggages")
    public ResponseEntity<List<LuggageDTO>> list(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok().body(luggageMapper.convertToDtoList(luggageService.getAll(pageable)));
    }


    @PostMapping
    @ApiOperation(value = "Create new luggage")
    public ResponseEntity<LuggageDTO> save(@RequestBody LuggageDTO luggageDTO) {
        Luggage luggage = luggageService.save(luggageMapper.convertToEntity(luggageDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(luggageMapper.convertToDto(luggage));
    }

    @PutMapping
    @ApiOperation(value = "Update existing luggage by id")
    public ResponseEntity<LuggageDTO> update(@RequestBody LuggageDTO luggageDTO) {
        Luggage luggage = luggageService.update(luggageMapper.convertToEntity(luggageDTO));
        return ResponseEntity.status(HttpStatus.OK).body(luggageMapper.convertToDto(luggage));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete luggage by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Luggage luggage = luggageService.getById(id);
        luggageService.delete(luggage);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
