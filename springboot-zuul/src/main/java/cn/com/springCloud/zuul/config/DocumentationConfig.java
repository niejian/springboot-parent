package cn.com.springCloud.zuul.config;/**
 * Created by niejian on 2018/7/19.
 */

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niejian
 * @date 2018/7/19
 */

public class DocumentationConfig implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;

    public DocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }
    /**
     * Retrieves an instance of the appropriate type. The returned object may or
     * may not be a new instance, depending on the implementation.
     *
     * @return an instance of the appropriate type
     */
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        //在这里遍历的时候，可以排除掉敏感微服务的路由
        routes.forEach(route -> resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"),"2.0")));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
