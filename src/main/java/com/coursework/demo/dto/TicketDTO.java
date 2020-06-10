package com.coursework.demo.dto;

import com.coursework.demo.entity.Route;
import com.coursework.demo.entity.Passenger;
import lombok.Data;

@Data
public class TicketDTO {
    private long id;

    private Route route;

    private Passenger passenger;

    private int price;

}
