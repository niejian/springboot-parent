package cn.com.springCloud;/**
 * Created by niejian on 2018/7/10.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author niejian
 * @date 2018/7/10
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({
        "cn.com.springCloud.service",
        "cn.com.springCloud.controller"
})
public class SpringCloudProvider {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudProvider.class, args);
    }
}
