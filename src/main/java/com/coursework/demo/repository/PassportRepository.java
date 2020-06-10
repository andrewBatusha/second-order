package com.coursework.demo.repository;

import com.coursework.demo.entity.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport, Long> {
}
