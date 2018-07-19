package cn.com.springCloud.controller;/**
 * Created by niejian on 2018/7/10.
 */

import cn.com.springCloud.service.CustService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niejian
 * @date 2018/7/10
 */
@Api(value = "提供者接口")
@RestController
public class CustController {

    @Autowired
    private CustService custService;
    @ApiOperation(value = "01.消息提供获取信息", notes = "06.消息提供获取信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/getMsg")
    public Map<String, Object> getMsg() {
        Map<String, Object> map = new HashMap<>(2);
        map.put("success", true);
        map.put("msg", custService.getCustService());

        return map;
    }

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return "hello + " + name + ", this is b";
    }
}
