## 说明
* eureka：注册中心

### 实现远程调用
```java
    //声明restTemplate
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    //调用端
    @Autowired
    private LoadBalancerClient loadBalanced;
    @Autowired
    private RestTemplate restTemplate;    
    @GetMapping(value = "/getConsumerMsg")
    public Map<String, Object> getConsumerMsg() {
        Map<String, Object> map = new HashMap<>(2);
        //要调用的eureka上面注册的服务名
        ServiceInstance serviceInstance = loadBalanced.choose("service-provider");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/getMsg";
        System.out.println(url);
        map = restTemplate.getForObject(url, Map.class);

        return map;
    }
```

* Ribbon：Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。它是一个基于HTTP和TCP的客户端负载均衡器。它可以通过在客户端中配置ribbonServerList来设置服务端列表去轮询访问以达到均衡负载的作用。
```java
//使用Ribbon来做服务的负载均衡
@Bean
@LoadBalanced
public RestTemplate restTemplate() {
    return new RestTemplate();
}

//调用端
@GetMapping(value = "/RibbonRequest")
public Map<String, Object> RibbonRequest() {
    //http://service-provider/getMsg；http//注册的服务名/具体方法
    Map<String, Object> map = this.restTemplate.getForObject("http://service-provider/getMsg", Map.class);
    return map;
}

```
* 使用Feign消费服务
> feign默认集成了Ribbon也就是默认集成了负载均衡的功能特性。

1、在主类添加注解 ***@EnableFeignClients***

2、声明调用端代码，实现远程调用

```java
//填写注册的服务名称
@FeignClient(value = "service-provider")
public interface FeignGetService {
    //这里注入的是服务提供方对应的方法名
    @GetMapping(value = "/getMsg")
    public Map<String, Object> consumerFeignCallService();
}

//声明对应的controller方法去调用这个service
@Autowired
private FeignGetService feignGetService;

/**
 * 调用service，
 * @return
 */
@GetMapping(value = "/consumerFeignCallService")
public Map<String, Object> consumerFeignCallService() {
    return this.feignGetService.consumerFeignCallService();
}
```



