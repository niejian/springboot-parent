package cn.com.springCloud.controller;/**
 * Created by niejian on 2018/7/10.
 */

import cn.com.springCloud.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author niejian
 * @date 2018/7/10
 */
@RestController
public class CustController {

    @Autowired
    private CustService custService;

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
