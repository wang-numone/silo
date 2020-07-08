package com.springboot.service;

import com.springboot.model.ZfUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wzw
 * @since 2020-06-18
 */
public interface IZfUserService extends IService<ZfUser> {

    List<ZfUser> getList();
}
