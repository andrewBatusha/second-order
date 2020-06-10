package com.coursework.demo.repository;

import com.coursework.demo.entity.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {
}
