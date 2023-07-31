package org.lychee.framework.apilog.core.service;

import org.lychee.framework.apilog.core.pojo.ApiErrorLog;

/**
 * API 错误日志 Framework Service 接口
 *
 * @author xu
 * @since 1.0
 */
public interface ApiErrorLogFrameworkService {

    /**
     * 创建 API 错误日志
     *
     * @param apiErrorLog API 错误日志
     */
    void createApiErrorLog(ApiErrorLog apiErrorLog);

}
