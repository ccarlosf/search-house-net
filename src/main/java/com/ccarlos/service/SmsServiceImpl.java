package com.ccarlos.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SmsServiceImpl implements ISmsService {

    private final static String SMS_CODE_CONTENT_PREFIX = "SMS::CODE::CONTENT";

    private static final String[] NUMS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private static final Random random = new Random();


    @Override
    public ServiceResult<String> sendSms(String telephone) {
        return ServiceResult.of("123456");
    }

    @Override
    public String getSmsCode(String telephone) {
        return "123456";
    }

    @Override
    public void remove(String telephone) {
    }

}
