package com.coursework.demo.repository;

import com.coursework.demo.entity.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepository extends CrudRepository<Bus, Long> {
}
