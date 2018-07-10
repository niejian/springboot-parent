package cn.com.springCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * 使用Feign的方式调用远程服务
 * Created by niejian on 2018/7/10.
 */
//填写注册的服务名称
@FeignClient(value = "service-provider")
public interface FeignGetService {
    //这里注入的是服务提供方对应的方法名
    @GetMapping(value = "/getMsg")
    public Map<String, Object> consumerFeignCallService();
}
