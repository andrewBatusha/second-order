package com.coursework.demo.repository;

import com.coursework.demo.entity.Luggage;
import org.springframework.data.repository.CrudRepository;

public interface LuggageRepository extends CrudRepository<Luggage, Long> {
}
