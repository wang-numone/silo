package com.springboot.model;

import com.springboot.model.BaseModel;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wzw
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ZfInfo extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 信息
     */
    private String info;

    /**
     * 图片
     */
    private String image;

    /**
     * 点赞次数
     */
    private Long likeNum;

    /**
     * 浏览次数
     */
    private Long browse;


}
