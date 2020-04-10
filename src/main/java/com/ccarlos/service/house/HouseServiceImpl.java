package com.ccarlos.service.house;

import com.ccarlos.base.LoginUserUtil;
import com.ccarlos.entity.House;
import com.ccarlos.repository.HouseRepository;
import com.ccarlos.service.ServiceResult;
import com.ccarlos.web.dto.HouseDTO;
import com.ccarlos.web.form.HouseForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private HouseRepository houseRepository;

    @Override
    public ServiceResult<HouseDTO> save(HouseForm houseForm) {

        House house = new House();
        modelMapper.map(houseForm, house);

        Date now = new Date();
        house.setCreateTime(now);
        house.setLastUpdateTime(now);
        house.setAdminId(LoginUserUtil.getLoginUserId());
        house = houseRepository.save(house);

       return null;
    }

}
