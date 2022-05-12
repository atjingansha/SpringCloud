package com.atwangjin.cloud.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * 自定义一个gateway的过滤器,
 * @author WangJin
 * @create 2022-05-01 21:26
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {


    /**
     *进行一个全局判断查看请求是否携带uname的key,并且不可为空,满足放行,否则为非法用户
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("from自定义的MyGatewayFilter:"+new Date());

        String uname = exchange.getRequest().getQueryParams().getFirst("uname");

        if (uname ==null){
            log.info("用户名非法");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
