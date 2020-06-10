package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Luggage;
import com.coursework.demo.repository.LuggageRepository;
import com.coursework.demo.service.LuggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LuggageServiceImpl implements LuggageService {

    LuggageRepository luggageRepository;

    @Autowired
    public LuggageServiceImpl(LuggageRepository luggageRepository) {
        this.luggageRepository = luggageRepository;
    }

    @Override
    public Luggage getById(Long id) {
        return luggageRepository.findById(id).get();
    }

    @Override
    public List<Luggage> getAll() {
        return (List<Luggage>) luggageRepository.findAll();
    }

    @Override
    public Luggage update(Luggage object) {
        return luggageRepository.save(object);
    }

    @Override
    public Luggage save(Luggage object) {
        return luggageRepository.save(object);
    }

    @Override
    public Luggage delete(Luggage object) {
        luggageRepository.delete(object);
        return object;
    }
}
