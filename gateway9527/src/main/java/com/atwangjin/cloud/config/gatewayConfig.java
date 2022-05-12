package com.atwangjin.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * gateway配置方式,推荐yml
 * @author WangJin
 * @create 2022-05-01 20:02
 */
@Configuration
public class gatewayConfig {


    /**
     * 配置了一个id为pathId的gateway的路由规则
     * 当访问http://localhost:9527/guonei时会自动映射为http://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("pathId",r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
