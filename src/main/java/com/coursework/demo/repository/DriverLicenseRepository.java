package com.coursework.demo.repository;

import com.coursework.demo.entity.DriverLicense;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DriverLicenseRepository extends PagingAndSortingRepository<DriverLicense, Long> {
}
