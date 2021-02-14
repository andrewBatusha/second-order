package com.coursework.demo.repository;

import com.coursework.demo.entity.Engineer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EngineerRepository extends PagingAndSortingRepository<Engineer, Long> {
}
