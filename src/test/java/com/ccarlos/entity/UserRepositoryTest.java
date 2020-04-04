package com.ccarlos.entity;

import com.ccarlos.SearchHouseNetApplicationTests;
import com.ccarlos.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends SearchHouseNetApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("ccarlos", user.getName());
    }
}
