package org.lychee.framework.env.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 环境配置
 *
 * @author xu
 * @since 1.0
 */
@ConfigurationProperties(prefix = "lychee.env")
@Data
public class EnvProperties {

    public static final String TAG_KEY = "lychee.env.tag";

    /**
     * 环境标签
     */
    private String tag;

}
