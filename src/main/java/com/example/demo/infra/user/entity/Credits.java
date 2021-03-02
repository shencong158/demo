package com.example.demo.infra.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户积分表
 * </p>
 *
 * @author jobob
 * @since 2021-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_credits")
public class Credits implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 当前积分
     */
    private Integer currentCredits;

    /**
     * 用户Id
     */
    private String userId;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
