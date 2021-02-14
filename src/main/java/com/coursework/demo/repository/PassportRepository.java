package com.coursework.demo.repository;

import com.coursework.demo.entity.Passport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PassportRepository extends PagingAndSortingRepository<Passport, Long> {
}
