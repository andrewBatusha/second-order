package com.coursework.demo.repository;

import com.coursework.demo.entity.Engineer;
import org.springframework.data.repository.CrudRepository;

public interface EngineerRepository extends CrudRepository<Engineer, Long> {
}
