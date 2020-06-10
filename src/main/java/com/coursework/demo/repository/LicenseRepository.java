package com.coursework.demo.repository;

import com.coursework.demo.entity.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
}
