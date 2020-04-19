package com.ccarlos.service.house;

import com.ccarlos.base.HouseSubscribeStatus;
import com.ccarlos.entity.HouseSubscribe;
import com.ccarlos.service.ServiceMultiResult;
import com.ccarlos.service.ServiceResult;
import com.ccarlos.web.dto.HouseDTO;
import com.ccarlos.web.form.DatatableSearch;
import com.ccarlos.web.form.HouseForm;
import com.ccarlos.web.form.MapSearch;
import com.ccarlos.web.form.RentSearch;
import org.springframework.data.util.Pair;

/**
 * 房屋管理服务接口
 */
public interface IHouseService {

    /**
     * 新增
     *
     * @param houseForm
     * @return
     */
    ServiceResult<HouseDTO> save(HouseForm houseForm);

    ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);

    /**
     * 查询完整房源信息
     *
     * @param id
     * @return
     */
    ServiceResult<HouseDTO> findCompleteOne(Long id);

    ServiceResult update(HouseForm houseForm);

    /**
     * 移除图片
     *
     * @param id
     * @return
     */
    ServiceResult removePhoto(Long id);

    /**
     * 更新封面
     *
     * @param coverId
     * @param targetId
     * @return
     */
    ServiceResult updateCover(Long coverId, Long targetId);

    /**
     * 新增标签
     *
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult addTag(Long houseId, String tag);

    /**
     * 移除标签
     *
     * @param houseId
     * @param tag
     * @return
     */
    ServiceResult removeTag(Long houseId, String tag);

    /**
     * 更新房源状态
     *
     * @param id
     * @param status
     * @return
     */
    ServiceResult updateStatus(Long id, int status);

    /**
     * 查询房源信息集
     *
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> query(RentSearch rentSearch);

    /**
     * 全地图查询
     *
     * @param mapSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> wholeMapQuery(MapSearch mapSearch);

    /**
     * 精确范围数据查询
     *
     * @param mapSearch
     * @return
     */
    ServiceMultiResult<HouseDTO> boundMapQuery(MapSearch mapSearch);

    /**
     * 加入预约清单
     *
     * @param houseId
     * @return
     */
    ServiceResult addSubscribeOrder(Long houseId);

    /**
     * 获取对应状态的预约列表
     */
    ServiceMultiResult<Pair<HouseDTO, HouseSubscribe>> querySubscribeList
    (HouseSubscribeStatus status, int start, int size);

}
