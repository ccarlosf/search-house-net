package com.ccarlos.service;

import com.ccarlos.entity.User;


/**
 * 用户服务
 */
public interface IUserService {

    User findUserByName(String userName);
}
