package com.example.demo.infra.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分操作表
 * </p>
 *
 * @author jobob
 * @since 2021-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CreditsOperateRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 操作类型1是增加0是减少
     */
    private String operateType;

    /**
     * 操作数量
     */
    private Integer operateNumber;

    private String userId;

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;


}
