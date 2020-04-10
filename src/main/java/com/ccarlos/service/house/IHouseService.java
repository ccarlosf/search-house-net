package com.ccarlos.service.house;

import com.ccarlos.service.ServiceMultiResult;
import com.ccarlos.service.ServiceResult;
import com.ccarlos.web.dto.HouseDTO;
import com.ccarlos.web.form.DatatableSearch;
import com.ccarlos.web.form.HouseForm;

/**
 * 房屋管理服务接口
 */
public interface IHouseService {

    /**
     * 新增
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> save(HouseForm houseForm);

    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);

    /**
     * 查询完整房源信息
     * @param id
     * @return
     */
    ServiceResult<HouseDTO> findCompleteOne(Long id);

    ServiceResult update(HouseForm houseForm);
}
