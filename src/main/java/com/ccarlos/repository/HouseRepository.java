package com.ccarlos.repository;

import com.ccarlos.entity.House;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseRepository extends PagingAndSortingRepository<House, Long> {
}
