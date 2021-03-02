package com.example.demo.infra.user.service.impl;

import com.example.demo.infra.user.entity.Credits;
import com.example.demo.infra.user.mapper.CreditsMapper;
import com.example.demo.infra.user.service.ICreditsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户积分表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-03-02
 */
@Service
public class CreditsServiceImpl extends ServiceImpl<CreditsMapper, Credits> implements ICreditsService {

}
