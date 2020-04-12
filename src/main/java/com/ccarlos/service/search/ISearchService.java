package com.ccarlos.service.search;

import com.ccarlos.service.ServiceMultiResult;
import com.ccarlos.web.form.RentSearch;

import java.util.List;

/**
 * 检索接口
 */
public interface ISearchService {
    /**
     * 索引目标房源
     * @param houseId
     */
    void index(Long houseId);

    /**
     * 移除房源索引
     *
     * @param houseId
     */
    void remove(Long houseId);

    /**
     * 查询房源接口
     *
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<Long> query(RentSearch rentSearch);
}
