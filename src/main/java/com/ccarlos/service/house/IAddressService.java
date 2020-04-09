package com.ccarlos.service.house;

import com.ccarlos.service.ServiceMultiResult;
import com.ccarlos.web.dto.SubwayDTO;
import com.ccarlos.web.dto.SubwayStationDTO;
import com.ccarlos.web.dto.SupportAddressDTO;

import java.util.List;

/**
 * 地址服务接口
 */
public interface IAddressService {

    /**
     * 获取所有支持的城市列表
     *
     * @return
     */
    ServiceMultiResult<SupportAddressDTO> findAllCities();

    /**
     * 根据城市英文简写获取该城市所有支持的区域信息
     *
     * @param cityName
     * @return
     */
    ServiceMultiResult findAllRegionsByCityName(String cityName);

    /**
     * 获取该城市所有的地铁线路
     *
     * @param cityEnName
     * @return
     */
    List<SubwayDTO> findAllSubwayByCity(String cityEnName);

    /**
     * 获取地铁线路所有的站点
     *
     * @param subwayId
     * @return
     */
    List<SubwayStationDTO> findAllStationBySubway(Long subwayId);
}

