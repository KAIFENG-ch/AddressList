package com.example.addresslist.baseClass;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.AntPathMatcher;

import java.nio.file.PathMatcher;

/**
 * Springboot 启动配置类
 * @author Albert
 */
@Configuration
@Slf4j
@Import(cn.hutool.extra.spring.SpringUtil.class)
public class BeansConfiguration {

    /**
     *
     * @return
     */
    @Bean
    @ApiOperation(value = "init PathMatcher")
    public PathMatcher pathMatcher() {
        log.info("init pathMatcher success!!!");
        return new AntPathMatcher();
    }

    @Primary
    @Bean
    @ApiOperation(value = "init thread pool")
    public TaskExecutor primaryTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        log.info("init thread pool success!!!");
        return executor;
    }

}
