package com.ccarlos.service;

import com.ccarlos.entity.User;
import com.ccarlos.web.dto.UserDTO;


/**
 * 用户服务
 */
public interface IUserService {

    User findUserByName(String userName);

    ServiceResult<UserDTO> findById(Long userId);
}
