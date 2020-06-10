package com.coursework.demo.dto;

import com.coursework.demo.entity.Driver;
import com.coursework.demo.entity.Engineer;
import com.coursework.demo.entity.enums.BusCondition;
import lombok.Data;

@Data
public class BusDTO {
    private long id;

    private String name;

    private int capacity;

    private Driver driver;

    private BusCondition status;

    private Engineer engineer;

}
