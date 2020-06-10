package com.coursework.demo.repository;

import com.coursework.demo.entity.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {
}
