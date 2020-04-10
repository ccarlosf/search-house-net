package com.ccarlos.repository;

import com.ccarlos.entity.House;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseRepository extends PagingAndSortingRepository<House, Long>
        , JpaSpecificationExecutor<House> {
}
