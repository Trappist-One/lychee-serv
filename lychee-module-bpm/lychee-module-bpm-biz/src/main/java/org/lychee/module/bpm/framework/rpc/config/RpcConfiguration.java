package org.lychee.module.bpm.framework.rpc.config;

import org.lychee.module.system.api.dept.DeptApi;
import org.lychee.module.system.api.dept.PostApi;
import org.lychee.module.system.api.dict.DictDataApi;
import org.lychee.module.system.api.permission.RoleApi;
import org.lychee.module.system.api.sms.SmsSendApi;
import org.lychee.module.system.api.user.AdminUserApi;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableFeignClients(clients = {RoleApi.class, DeptApi.class, PostApi.class, AdminUserApi.class, SmsSendApi.class, DictDataApi.class})
public class RpcConfiguration {
}
