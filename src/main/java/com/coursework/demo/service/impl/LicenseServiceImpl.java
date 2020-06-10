package com.coursework.demo.service.impl;

import com.coursework.demo.entity.License;
import com.coursework.demo.repository.LicenseRepository;
import com.coursework.demo.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LicenseServiceImpl implements LicenseService {

    LicenseRepository licenseRepository;

    @Autowired
    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    @Override
    public License getById(Long id) {
        return licenseRepository.findById(id).get();
    }

    @Override
    public List<License> getAll() {
        return (List<License>) licenseRepository.findAll();
    }

    @Override
    public License update(License object) {
        return licenseRepository.save(object);
    }

    @Override
    public License save(License object) {
        return licenseRepository.save(object);
    }

    @Override
    public License delete(License object) {
        licenseRepository.delete(object);
        return object;
    }
}
