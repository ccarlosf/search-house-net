package com.ccarlos.web.controller;

import com.ccarlos.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping(value = {"/"})
    public String index(Model model) {
        model.addAttribute("name","Hello World");
        return "index";
    }

    @GetMapping(value = "/get")
    @ResponseBody
    public ApiResponse get(Model model) {
        return ApiResponse.ofMessage(200,"成功了");
    }
}
