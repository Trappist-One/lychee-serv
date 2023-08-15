package org.lychee.framework.operatelog.config;

import org.lychee.framework.operatelog.core.aop.OperateLogAspect;
import org.lychee.framework.operatelog.core.service.OperateLogFrameworkService;
import org.lychee.framework.operatelog.core.service.OperateLogFrameworkServiceImpl;
import org.lychee.module.system.api.logger.OperateLogApi;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class LycheeOperateLogAutoConfiguration {

    @Bean
    public OperateLogAspect operateLogAspect() {
        return new OperateLogAspect();
    }

    @Bean
    public OperateLogFrameworkService operateLogFrameworkService(OperateLogApi operateLogApi) {
        return new OperateLogFrameworkServiceImpl(operateLogApi);
    }

}
