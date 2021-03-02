package com.example.demo.controller;

import com.riversoft.weixin.common.decrypt.SHA1;
import com.riversoft.weixin.common.message.XmlMessageHeader;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: cong.shen
 * @version: V1.0
 * @date: 2021/2/22 10:35
 */
@Controller
@Slf4j
public class InitController {


    @Autowired
    private RedissonClient redissonClient;

    @Value("${wx.token}")
    private String token;

    @Value("${wx.aesKey}")
    private String aesKey;

    @GetMapping("/wx/qy")
    @ResponseBody
    public String qy(@RequestParam(value="signature") String signature,
                     @RequestParam(value="timestamp") String timestamp,
                     @RequestParam(value="nonce") String nonce,
                     @RequestParam(value="echostr", required = false) String echostr,
                     @RequestBody(required = false) String content) {

        log.info("msg_signature={}, nonce={}, timestamp={}, echostr={}", signature, nonce, timestamp, echostr);
//        SHA1
        try {
            if (!StringUtils.isEmpty(echostr)) {
                if (!SHA1.getSHA1(new String[]{this.token, timestamp, nonce}).equals(signature)) {
                    log.info("消息签名验证失败.");
                    return "";
                } else {
                    log.info("消息签名验证成功.");
                    return echostr;
                }
            }
        } catch (Exception e) {
            log.error("callback failed.", e);
        }

        return "";
    }

    private XmlMessageHeader qyDispatch(XmlMessageHeader xmlRequest) {
        //添加处理逻辑

        //需要同步返回消息（被动响应消息）给用户则构造一个XmlMessageHeader类型，比较鸡肋，因为处理逻辑如果比较复杂响应太慢会影响用户感知，建议直接返回null；
        //如果有消息需要发送给用户则可以调用主动消息发送接口进行异步发送
        return null;
    }

}
