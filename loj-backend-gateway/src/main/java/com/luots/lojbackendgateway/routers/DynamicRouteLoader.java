package com.luots.lojbackendgateway.routers;

import cn.hutool.json.JSONUtil;
import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

@Slf4j
@Component
@RequiredArgsConstructor
public class DynamicRouteLoader {

    private final NacosConfigManager nacosConfigManager;

    private final RouteDefinitionWriter routeDefinitionWriter;

    private final String dataId = "gateway-routes.json";

    private final String group = "DEFAULT_GROUP";

    private final Set<String> routeIds = new HashSet<>();

    @PostConstruct
    public void initRouteConfigListener() throws NacosException {
        // 1. 项目启动先拉取一次配置，并且添加配置监听器
        String configInfo = nacosConfigManager.getConfigService().
                getConfigAndSignListener(dataId, group, 5000, new Listener() {

                    @Override
                    public Executor getExecutor() {
                        return null;
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        // 2. 监听到配置变化，更新路由配置
                        updateConfigInfo(configInfo);
                    }
                });
        updateConfigInfo(configInfo);
    }
    public void updateConfigInfo(String configInfo){
        log.debug("监听到路由配置信息：{}", configInfo);
        // 1. 解析配置信息，转为RouteDefinition
        List<RouteDefinition> routeDefinitions = JSONUtil.toList(configInfo, RouteDefinition.class);
        // 2. 删除旧的路由表（防止更新路由配置是删除操作，save只能添加）
        for (String routeId : routeIds) {
            routeDefinitionWriter.delete(Mono.just(routeId)).subscribe();
        }
        routeIds.clear();
        // 3. 更新路由表
        for (RouteDefinition routeDefinition : routeDefinitions) {
            routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
            // 记录路由id，便于下一次更新的时候删除
            routeIds.add(routeDefinition.getId());
        }
    }
}
