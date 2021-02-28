package com.coursework.demo.dto;

import com.coursework.demo.entity.enums.BusCondition;
import lombok.Data;

@Data
public class BusDTO {
    private long id;

    private String name;

    private int capacity;

    private BusCondition status;
}
