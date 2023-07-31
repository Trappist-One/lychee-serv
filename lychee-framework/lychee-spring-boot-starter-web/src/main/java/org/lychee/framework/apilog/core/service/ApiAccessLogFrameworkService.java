package org.lychee.framework.apilog.core.service;

import org.lychee.framework.apilog.core.pojo.ApiAccessLog;

/**
 * API 访问日志 Framework Service 接口
 *
 * @author xu
 * @since 1.0
 */
public interface ApiAccessLogFrameworkService {

    /**
     * 创建 API 访问日志
     *
     * @param apiAccessLog API 访问日志
     */
    void createApiAccessLog(ApiAccessLog apiAccessLog);

}
