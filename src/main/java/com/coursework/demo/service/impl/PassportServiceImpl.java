package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Passport;
import com.coursework.demo.repository.PassportRepository;
import com.coursework.demo.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PassportServiceImpl implements PassportService {

    PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public Passport getById(Long id) {
        return passportRepository.findById(id).get();
    }

    @Override
    public List<Passport> getAll(Pageable pageable) {
        return passportRepository.findAll(pageable).getContent();
    }

    @Override
    public Passport update(Passport object) {
        return passportRepository.save(object);
    }

    @Override
    public Passport save(Passport object) {
        return passportRepository.save(object);
    }

    @Override
    public Passport delete(Passport object) {
        passportRepository.delete(object);
        return object;
    }
}
