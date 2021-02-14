package com.coursework.demo.repository;

import com.coursework.demo.entity.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PassengerRepository extends PagingAndSortingRepository<Passenger, Long> {
}
