package cn.com.springCloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ZuulBootstrap.class, args);
    }
}
