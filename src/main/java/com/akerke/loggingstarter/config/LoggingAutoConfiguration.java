package com.akerke.loggingstarter.config;

import com.akerke.loggingstarter.common.aspect.EnableLoggerLibTimeExecutionAspect;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * Auto-configuration class for logging in the application.
 * Configures and initializes necessary logging components based on properties defined in {@link LoggingProperties}.
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
@ConditionalOnClass(LoggingProperties.class)
@EnableAspectJAutoProxy
public class LoggingAutoConfiguration {

    /**
     * Initializes the LoggingAutoConfiguration.
     * Logs an initialization message after the bean has been constructed.
     */
    @PostConstruct
    void init() {
        log.info("LoggingAutoConfiguration initialized ");
    }

    /**
     * Creates an instance of {@link EnableLoggerLibTimeExecutionAspect} if the class is present in the classpath.
     *
     * @return an instance of {@link EnableLoggerLibTimeExecutionAspect} if the class is present, otherwise null.
     */
    @Bean
    @ConditionalOnClass(EnableLoggerLibTimeExecutionAspect.class)
    public EnableLoggerLibTimeExecutionAspect controllerTimeExecutionAspect() {
        log.info("Creating EnableLoggerLibTimeExecutionAspect instance");
        return new EnableLoggerLibTimeExecutionAspect();
    }

}
