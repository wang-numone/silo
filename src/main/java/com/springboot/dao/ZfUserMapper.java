package com.springboot.dao;

import com.springboot.model.ZfUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzw
 * @since 2020-06-18
 */
@Repository
public interface ZfUserMapper extends BaseMapper<ZfUser> {

    @Select("select * from zf_user")
    List<ZfUser> getList();
}
