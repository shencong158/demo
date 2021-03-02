package com.example.demo.common.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author: cong.shen
 * @version: V1.0
 * @date: 2021/2/26 13:26
 */
@Configuration
public class RedissonConfig {
    // 读取环境变量的实例env
    @Autowired
    private Environment env;

    /**
     * 自定义注入配置操作Redisson客户端实例
     * @return
     */
    @Bean
    public RedissonClient config() {
        // 创建配置实例
        Config config = new Config();

        // 传输模式既可以设置为EPOLL，也可以设置为NIO等
        config.setTransportMode(TransportMode.NIO);

        // 设置服务节点部署模式: 集群、单一节点/主从模式/哨兵模式
        // config.useClusterServers().addNodeAddress(env.getProperty("redisson.host.config"), env.getProperty("redisson.host.config"));
        config.useSingleServer().setAddress(env.getProperty("redisson.host.config")).setPassword(env.getProperty("redisson.host.config.password")).setKeepAlive(true);

        return Redisson.create(config);
    }
}
