package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Position;
import com.coursework.demo.repository.PositionRepository;
import com.coursework.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PositionServiceImpl implements PositionService {

    PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Position getById(Long id) {
        return positionRepository.findById(id).get();
    }

    @Override
    public List<Position> getAll() {
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public Position update(Position object) {
        return positionRepository.save(object);
    }

    @Override
    public Position save(Position object) {
        return positionRepository.save(object);
    }

    @Override
    public Position delete(Position object) {
        positionRepository.delete(object);
        return object;
    }
}
