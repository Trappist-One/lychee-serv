package org.lychee.module.system.job.demo;

import org.lychee.framework.tenant.core.job.TenantJob;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
@TenantJob
public class DemoJob {

    @XxlJob("demoJob")
    public void execute() {
        System.out.println("美滋滋");
    }

}
