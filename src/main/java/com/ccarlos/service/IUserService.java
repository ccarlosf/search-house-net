package com.ccarlos.service;

import com.ccarlos.entity.User;
import com.ccarlos.web.dto.UserDTO;


/**
 * 用户服务
 */
public interface IUserService {

    User findUserByName(String userName);

    ServiceResult<UserDTO> findById(Long userId);

    /**
     * 根据电话号码寻找用户
     *
     * @param telephone
     * @return
     */
    User findUserByTelephone(String telephone);

    /**
     * 通过手机号注册用户
     *
     * @param telehone
     * @return
     */
    User addUserByPhone(String telehone);
}
