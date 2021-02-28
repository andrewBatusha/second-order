package com.coursework.demo.service;

import com.coursework.demo.entity.Route;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface RouteService extends BasicService<Route, Long>{
    List<Route> getAll(String from, String to, LocalDate date, Pageable pageable);
}