package com.coursework.demo.dto;

import com.coursework.demo.entity.Station;
import lombok.Data;

@Data
public class EngineerDTO {
    private long id;

    private String name;

    private Station station;
}
