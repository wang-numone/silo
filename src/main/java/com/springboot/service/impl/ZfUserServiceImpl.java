package com.springboot.service.impl;

import com.springboot.model.ZfUser;
import com.springboot.dao.ZfUserMapper;
import com.springboot.service.IZfUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wzw
 * @since 2020-06-18
 */
@Service
public class ZfUserServiceImpl extends ServiceImpl<ZfUserMapper, ZfUser> implements IZfUserService {
    @Autowired
    ZfUserMapper zfUserMapper;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public List<ZfUser> getList() {
        redisUtil.set("user", zfUserMapper.getList());
        System.out.println(redisUtil.get("user")+"====================================================================");
        return zfUserMapper.getList();
    }
}
