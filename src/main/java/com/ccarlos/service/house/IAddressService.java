package com.ccarlos.service.house;

import com.ccarlos.service.ServiceMultiResult;
import com.ccarlos.web.dto.SupportAddressDTO;

/**
 * 地址服务接口
 */
public interface IAddressService {

    /**
     * 获取所有支持的城市列表
     * @return
     */
    ServiceMultiResult<SupportAddressDTO> findAllCities();
}

