package com.springboot.controller;


import com.springboot.model.ZfUser;
import com.springboot.service.IZfUserService;
import com.springboot.util.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzw
 * @since 2020-06-18
 */
@RestController
@RequestMapping("/zfUser")
public class ZfUserController {
    @Autowired
    IZfUserService zfUserService;
    @GetMapping("/list")
    public List<ZfUser> list(){
        return zfUserService.getList();
    }


}
