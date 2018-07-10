package cn.com.springCloud.controller;

import cn.com.springCloud.service.FeignGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niejian
 * @date 2018/7/10
 */
@RestController
public class TestController {

    @Autowired
    private LoadBalancerClient loadBalanced;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignGetService feignGetService;

    @GetMapping(value = "/getConsumerMsg")
    public Map<String, Object> getConsumerMsg() {
        Map<String, Object> map = new HashMap<>(2);
        ServiceInstance serviceInstance = loadBalanced.choose("service-provider");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getMsg";
        System.out.println(url);
        map = restTemplate.getForObject(url, Map.class);

        return map;
    }

    /**
     * 使用ribbon
     * @return
     */
    @GetMapping(value = "/RibbonRequest")
    public Map<String, Object> RibbonRequest() {
        Map<String, Object> map = this.restTemplate.getForObject("http://service-provider/getMsg", Map.class);
        return map;
    }

    /**
     * 调用service，
     * @return
     */
    @GetMapping(value = "/consumerFeignCallService")
    public Map<String, Object> consumerFeignCallService() {
        return this.feignGetService.consumerFeignCallService();
    }


}
