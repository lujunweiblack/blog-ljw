package com.ljw.blog.manage.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @time: 10:19 2019/5/23
 * @des:
 */
@Data
@ConfigurationProperties(prefix = "blog.manage.gitalk")
public class GitalkProperties {
    private String label;
    private String autoInitUrl;
}
