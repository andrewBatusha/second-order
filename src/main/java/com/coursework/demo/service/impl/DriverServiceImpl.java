package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Driver;
import com.coursework.demo.repository.DriverRepository;
import com.coursework.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DriverServiceImpl implements DriverService {

    DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver getById(Long id) {
        return driverRepository.findById(id).get();
    }

    @Override
    public List<Driver> getAll() {
        return (List<Driver>) driverRepository.findAll();
    }

    @Override
    public Driver update(Driver object) {
        return driverRepository.save(object);
    }

    @Override
    public Driver save(Driver object) {
        return driverRepository.save(object);
    }

    @Override
    public Driver delete(Driver object) {
        driverRepository.delete(object);
        return object;
    }
}
