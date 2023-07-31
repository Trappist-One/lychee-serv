package org.lychee.framework.apilog.core.service;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.lychee.framework.apilog.core.pojo.ApiAccessLog;
import org.springframework.scheduling.annotation.Async;

/**
 * API 访问日志 Framework Service 实现类
 *
 * 基于 {@link ApiAccessLogApi} 远程服务，记录访问日志
 *
 * @author 芋道源码
 */
@RequiredArgsConstructor
public class ApiAccessLogFrameworkServiceImpl implements ApiAccessLogFrameworkService {

    private final ApiAccessLogApi apiAccessLogApi;

    @Override
    @Async
    public void createApiAccessLog(ApiAccessLog apiAccessLog) {
        ApiAccessLogCreateReqDTO reqDTO = BeanUtil.copyProperties(apiAccessLog, ApiAccessLogCreateReqDTO.class);
        apiAccessLogApi.createApiAccessLog(reqDTO).checkError();
    }

}
