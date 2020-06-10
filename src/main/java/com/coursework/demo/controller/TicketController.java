package com.coursework.demo.controller;

import com.coursework.demo.dto.TicketDTO;
import com.coursework.demo.entity.Ticket;
import com.coursework.demo.mapper.TicketMapper;
import com.coursework.demo.service.TicketService;
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
@Api(tags = "Ticket API")
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketController(TicketService ticketService, TicketMapper ticketMapper) {
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get ticket info by id")
    public ResponseEntity<TicketDTO> get(@PathVariable("id") long id){
        Ticket ticket = ticketService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketMapper.convertToDto(ticket));
    }


    @GetMapping
    @ApiOperation(value = "Get the list of all tickets")
    public ResponseEntity<List<TicketDTO>> list() {
        return ResponseEntity.ok().body(ticketMapper.convertToDtoList(ticketService.getAll()));
    }


    @PostMapping
    @ApiOperation(value = "Create new ticket")
    public ResponseEntity<TicketDTO> save(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = ticketService.save(ticketMapper.convertToEntity(ticketDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketMapper.convertToDto(ticket));
    }

    @PutMapping
    @ApiOperation(value = "Update existing ticket by id")
    public ResponseEntity<TicketDTO> update(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = ticketService.update(ticketMapper.convertToEntity(ticketDTO));
        return ResponseEntity.status(HttpStatus.OK).body(ticketMapper.convertToDto(ticket));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete ticket by id")
    public ResponseEntity delete(@PathVariable("id") long id){
        Ticket ticket = ticketService.getById(id);
        ticketService.delete(ticket);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
