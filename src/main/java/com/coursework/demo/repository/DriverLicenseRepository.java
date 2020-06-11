package com.coursework.demo.repository;

import com.coursework.demo.entity.DriverLicense;
import org.springframework.data.repository.CrudRepository;

public interface DriverLicenseRepository extends CrudRepository<DriverLicense, Long> {
}
