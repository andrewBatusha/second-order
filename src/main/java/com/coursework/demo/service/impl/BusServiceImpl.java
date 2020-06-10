package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Bus;
import com.coursework.demo.repository.BusRepository;
import com.coursework.demo.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BusServiceImpl implements BusService {

    BusRepository busRepository;

    @Autowired
    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus getById(Long id) {
        return busRepository.findById(id).get();
    }

    @Override
    public List<Bus> getAll() {
        return (List<Bus>) busRepository.findAll();
    }

    @Override
    public Bus update(Bus object) {
        return busRepository.save(object);
    }

    @Override
    public Bus save(Bus object) {
        return busRepository.save(object);
    }

    @Override
    public Bus delete(Bus object) {
        busRepository.delete(object);
        return object;
    }
}
