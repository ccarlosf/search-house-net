package com.ccarlos.service.address;

import com.ccarlos.SearchHouseNetApplicationTests;
import com.ccarlos.service.ServiceResult;
import com.ccarlos.service.house.IAddressService;
import com.ccarlos.service.search.BaiduMapLocation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressServiceTests extends SearchHouseNetApplicationTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void testGetMapLocation() {
        String city = "北京";
        String address = "北京市昌平区巩华家园1号楼2单元";
        ServiceResult<BaiduMapLocation> serviceResult = addressService.getBaiduMapLocation
                (city, address);

        Assert.assertTrue(serviceResult.isSuccess());

        Assert.assertTrue(serviceResult.getResult().getLongitude() > 0 );
        Assert.assertTrue(serviceResult.getResult().getLatitude() > 0 );

    }
}
