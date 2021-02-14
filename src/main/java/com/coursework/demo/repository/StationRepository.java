package com.coursework.demo.repository;

import com.coursework.demo.entity.Station;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StationRepository extends PagingAndSortingRepository<Station, Long> {
}
