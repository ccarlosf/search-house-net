package com.ccarlos.repository;

import com.ccarlos.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String userName);

    User findUserByPhoneNumber(String telephone);
}
