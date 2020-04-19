package com.ccarlos.web.controller.user;

import com.ccarlos.base.ApiResponse;
import com.ccarlos.base.HouseSubscribeStatus;
import com.ccarlos.base.LoginUserUtil;
import com.ccarlos.entity.HouseSubscribe;
import com.ccarlos.service.IUserService;
import com.ccarlos.service.ServiceMultiResult;
import com.ccarlos.service.ServiceResult;
import com.ccarlos.service.house.IHouseService;
import com.ccarlos.web.dto.HouseDTO;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IHouseService houseService;

    @GetMapping("/user/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/user/center")
    public String centerPage() {
        return "user/center";
    }

    @PostMapping(value = "api/user/info")
    @ResponseBody
    public ApiResponse updateUserInfo(@RequestParam(value = "profile") String profile,
                                      @RequestParam(value = "value") String value) {
        if (value.isEmpty()) {
            return ApiResponse.ofStatus(ApiResponse.Status.BAD_REQUEST);
        }

        if ("email".equals(profile) && !LoginUserUtil.checkEmail(value)) {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST, "不支持的邮箱格式");
        }

        ServiceResult result = userService.modifyUserProfile(profile, value);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess("");
        } else {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST, result.getMessage());
        }
    }

    @PostMapping(value = "api/user/house/subscribe")
    @ResponseBody
    public ApiResponse subscribeHouse(@RequestParam(value = "house_id") Long houseId) {
        ServiceResult result = houseService.addSubscribeOrder(houseId);
        if (result.isSuccess()) {
            return ApiResponse.ofSuccess("");
        } else {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST, result.getMessage());
        }
    }

    @GetMapping(value = "api/user/house/subscribe/list")
    @ResponseBody
    public ApiResponse subscribeList(
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "3") int size,
            @RequestParam(value = "status") int status) {

        ServiceMultiResult<Pair<HouseDTO, HouseSubscribe>> result
                = houseService.querySubscribeList(HouseSubscribeStatus.of(status), start, size);

        return null;
    }

}
