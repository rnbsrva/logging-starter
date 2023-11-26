package com.akerke.loggingstarter.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Configuration properties class for logging in the application.
 * Provides properties to control and configure logging behavior.
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@ConfigurationProperties(prefix = "com.akerke.logging.starter")
public class LoggingProperties {


    /**
     * Indicates whether logging is enabled or not.
     */
    private boolean enabled = true;


    /**
     * Initializes the LoggingProperties.
     * Logs an initialization message after the bean has been constructed.
     */
    @PostConstruct
    void init() {
        log.info("Logging properties initialized: {}", this);
    }

    /**
     * Returns a string representation of the LoggingProperties.
     *
     * @return a string representation of the LoggingProperties.
     */
    @Override
    public String toString() {
        return "enabled=" + enabled;
    }
}
