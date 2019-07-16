package com.ljw.blog.manage.config;

import com.ljw.blog.manage.config.properties.GitalkProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @time: 10:27 2019/5/23
 * @des:
 */
@Configuration
@EnableConfigurationProperties(GitalkProperties.class)
public class GitalkConfig {
    private final GitalkProperties properties;

    public GitalkConfig(GitalkProperties properties) {
        this.properties = properties;
    }

    public GitalkProperties getProperties() {
        return properties;
    }
}
