package cn.com.springCloud.service.impl;/**
 * Created by niejian on 2018/7/10.
 */

import cn.com.springCloud.service.CustService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

/**
 * @author niejian
 * @date 2018/7/10
 */
@Service(value = "custService")
public class CustServiceImpl implements CustService {
    @Override
    public String getCustService() {
        return System.currentTimeMillis() + "";
    }
}
