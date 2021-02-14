package com.coursework.demo.repository;

import com.coursework.demo.entity.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DriverRepository extends PagingAndSortingRepository<Driver, Long> {
}
