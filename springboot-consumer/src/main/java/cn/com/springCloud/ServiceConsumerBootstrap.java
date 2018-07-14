package cn.com.springCloud;/**
 * Created by niejian on 2018/7/10.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author niejian
 * @date 2018/7/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@ComponentScan({
//        "cn.com.springCloud.controller"
//})
public class ServiceConsumerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerBootstrap.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
