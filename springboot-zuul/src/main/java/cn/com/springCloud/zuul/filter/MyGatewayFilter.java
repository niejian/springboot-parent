package cn.com.springCloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 网关过滤器
 * @author niejian
 * @date 2018/7/12
 */
//@Component
public class MyGatewayFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(MyGatewayFilter.class);
//
//    @Override
//    public boolean isStaticFilter() {
//        return super.isStaticFilter();
//    }
//
//    @Override
//    public String disablePropertyName() {
//        return super.disablePropertyName();
//    }
//
//    @Override
//    public boolean isFilterDisabled() {
//        return super.isFilterDisabled();
//    }
//
//    @Override
//    public ZuulFilterResult runFilter() {
//        return super.runFilter();
//    }
//
//    @Override
//    public int compareTo(ZuulFilter filter) {
//        return super.compareTo(filter);
//    }

    /**
     * Zuul大部分功能都是通过过滤器来实现的。Zuul中定义了四种标准过滤器类型，这些过滤器类型对应于请求的典型生命周期。
     (1) PRE：这种过滤器在请求被路由之前调用。我们可利用这种过滤器实现身份验证、在集群中选择请求的微服务、记录调试信息等。
     (2) ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netfilx Ribbon请求微服务。
     (3) POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端等。
     (4) ERROR：在其他阶段发生错误时执行该过滤器。
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体实现
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
//        RequestContext currentContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = currentContext.getRequest();
//        logger.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());
//
//        Object accessToken = request.getParameter("accessToken");
//        if(accessToken == null) {
//            logger.warn("access token is empty");
//            //令zuul过滤该请求，不对其进行路由
//            currentContext.setSendZuulResponse(false);
//            //设置了其返回的错误码，当然我们也可以进一步优化我们的返回
//            currentContext.setResponseStatusCode(401);
//            return null;
//        }
//        logger.info("access token ok");
        return null;
    }
}
