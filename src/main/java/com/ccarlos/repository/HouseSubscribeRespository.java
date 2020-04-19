package com.ccarlos.repository;

import com.ccarlos.entity.HouseSubscribe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface HouseSubscribeRespository extends PagingAndSortingRepository<HouseSubscribe, Long> {

    HouseSubscribe findByHouseIdAndUserId(Long houseId, Long loginUserId);

    Page<HouseSubscribe> findAllByUserIdAndStatus(Long userId, int status, Pageable pageable);
}
