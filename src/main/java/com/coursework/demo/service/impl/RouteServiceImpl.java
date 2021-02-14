package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Route;
import com.coursework.demo.repository.RouteRepository;
import com.coursework.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class RouteServiceImpl implements RouteService {

    RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route getById(Long id) {
        return routeRepository.findById(id).get();
    }

    @Override
    public List<Route> getAll(Pageable pageable) {
        return routeRepository.findAll(pageable).getContent();
    }

    @Override
    public Route update(Route object) {
        return routeRepository.save(object);
    }

    @Override
    public Route save(Route object) {
        return routeRepository.save(object);
    }

    @Override
    public Route delete(Route object) {
        routeRepository.delete(object);
        return object;
    }
}
