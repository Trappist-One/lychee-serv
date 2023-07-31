package org.lychee.framework.apilog.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;

/**
 * API 日志使用到 Feign 的配置项
 *
 * @author 芋道源码
 */
@AutoConfiguration
@EnableFeignClients(clients = {ApiAccessLogApi.class, // 主要是引入相关的 API 服务
        ApiErrorLogApi.class})
public class LycheeApiLogRpcAutoConfiguration {
}
