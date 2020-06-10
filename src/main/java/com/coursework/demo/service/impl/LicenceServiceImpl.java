package com.coursework.demo.service.impl;

import com.coursework.demo.entity.Licence;
import com.coursework.demo.repository.LicenceRepository;
import com.coursework.demo.service.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LicenceServiceImpl implements LicenceService {

    LicenceRepository licenceRepository;

    @Autowired
    public LicenceServiceImpl(LicenceRepository licenceRepository) {
        this.licenceRepository = licenceRepository;
    }

    @Override
    public Licence getById(Long id) {
        return licenceRepository.findById(id).get();
    }

    @Override
    public List<Licence> getAll() {
        return (List<Licence>) licenceRepository.findAll();
    }

    @Override
    public Licence update(Licence object) {
        return licenceRepository.save(object);
    }

    @Override
    public Licence save(Licence object) {
        return licenceRepository.save(object);
    }

    @Override
    public Licence delete(Licence object) {
        licenceRepository.delete(object);
        return object;
    }
}
