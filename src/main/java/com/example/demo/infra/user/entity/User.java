package com.example.demo.infra.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2021-03-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userName;

    /**
     * 用户open_id
     */
    private String openId;

    private String userSource;

    private LocalDateTime createDate;


}
