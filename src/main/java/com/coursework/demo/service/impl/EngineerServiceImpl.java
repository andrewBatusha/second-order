package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Engineer;
import com.coursework.demo.repository.EngineerRepository;
import com.coursework.demo.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class EngineerServiceImpl implements EngineerService {

    EngineerRepository engineerRepository;

    @Autowired
    public EngineerServiceImpl(EngineerRepository engineerRepository) {
        this.engineerRepository = engineerRepository;
    }

    @Override
    public Engineer getById(Long id) {
        return engineerRepository.findById(id).get();
    }

    @Override
    public List<Engineer> getAll(Pageable pageable) {
        return engineerRepository.findAll(pageable).getContent();
    }

    @Override
    public Engineer update(Engineer object) {
        return engineerRepository.save(object);
    }

    @Override
    public Engineer save(Engineer object) {
        return engineerRepository.save(object);
    }

    @Override
    public Engineer delete(Engineer object) {
        engineerRepository.delete(object);
        return object;
    }
}
