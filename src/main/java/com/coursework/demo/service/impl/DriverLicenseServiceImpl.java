package com.coursework.demo.service.impl;

import com.coursework.demo.entity.DriverLicense;
import com.coursework.demo.repository.DriverLicenseRepository;
import com.coursework.demo.service.DriverLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DriverLicenseServiceImpl implements DriverLicenseService {

    DriverLicenseRepository driverLicenseRepository;

    @Autowired
    public DriverLicenseServiceImpl(DriverLicenseRepository driverLicenseRepository) {
        this.driverLicenseRepository = driverLicenseRepository;
    }

    @Override
    public DriverLicense getById(Long id) {
        return driverLicenseRepository.findById(id).get();
    }

    @Override
    public List<DriverLicense> getAll(Pageable pageable) {
        return driverLicenseRepository.findAll(pageable).getContent();
    }

    @Override
    public DriverLicense update(DriverLicense object) {
        return driverLicenseRepository.save(object);
    }

    @Override
    public DriverLicense save(DriverLicense object) {
        return driverLicenseRepository.save(object);
    }

    @Override
    public DriverLicense delete(DriverLicense object) {
        driverLicenseRepository.delete(object);
        return object;
    }
}
