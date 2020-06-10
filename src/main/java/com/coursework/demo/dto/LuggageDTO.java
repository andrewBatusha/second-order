package com.coursework.demo.dto;

import com.coursework.demo.entity.Passenger;
import com.coursework.demo.entity.enums.LuggageType;
import lombok.Data;

@Data
public class LuggageDTO {
    private long id;

    private String name;

    private int weight;

    private LuggageType luggageType;

    private Passenger passenger;
}
