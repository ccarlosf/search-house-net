package com.ccarlos.repository;

import com.ccarlos.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SupportAddressRepository extends CrudRepository<SupportAddress, Long> {

    /**
     * 获取所有对应行政级别的信息
     *
     * @return
     */
    List<SupportAddress> findAllByLevel(String level);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);

    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);
}
