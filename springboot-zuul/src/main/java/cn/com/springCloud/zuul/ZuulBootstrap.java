package cn.com.springCloud.zuul;

import cn.com.springCloud.zuul.filter.MyGatewayFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@ZuulC
//@ComponentScan({
//        "cn.com.springCloud.zuul"
//})
public class ZuulBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(ZuulBootstrap.class, args);
    }

//    @Bean
//    public MyGatewayFilter myGatewayFilter(){
//        return new MyGatewayFilter();
//    }
}
