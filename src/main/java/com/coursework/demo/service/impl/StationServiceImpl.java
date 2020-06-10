package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Station;
import com.coursework.demo.repository.StationRepository;
import com.coursework.demo.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class StationServiceImpl implements StationService {

    StationRepository stationRepository;

    @Autowired
    public StationServiceImpl(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public Station getById(Long id) {
        return stationRepository.findById(id).get();
    }

    @Override
    public List<Station> getAll() {
        return (List<Station>) stationRepository.findAll();
    }

    @Override
    public Station update(Station object) {
        return stationRepository.save(object);
    }

    @Override
    public Station save(Station object) {
        return stationRepository.save(object);
    }

    @Override
    public Station delete(Station object) {
        stationRepository.delete(object);
        return object;
    }
}
