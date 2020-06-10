package com.coursework.demo.dto;

import com.coursework.demo.entity.Bus;
import lombok.Data;

@Data
public class RouteDTO {
    private long id;

    private String departureDate;
    private String destinationDate;

    private String departure;

    private String destination;

    private Bus bus;

}
