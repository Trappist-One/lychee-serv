package org.lychee.module.infra.service.logger;

import org.lychee.framework.apilog.core.service.ApiAccessLog;
import org.lychee.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import org.lychee.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import org.lychee.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import org.lychee.module.infra.convert.logger.ApiAccessLogConvert;
import org.lychee.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import org.lychee.module.infra.dal.mysql.logger.ApiAccessLogMapper;
import org.lychee.framework.common.pojo.PageResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.List;

/**
 * API 访问日志 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ApiAccessLogServiceImpl implements ApiAccessLogService {

    @Resource
    private ApiAccessLogMapper apiAccessLogMapper;

    @Override
    public void createApiAccessLog(ApiAccessLogCreateReqDTO createDTO) {
        ApiAccessLogDO apiAccessLog = ApiAccessLogConvert.INSTANCE.convert(createDTO);
        apiAccessLogMapper.insert(apiAccessLog);
    }

    @Override
    public PageResult<ApiAccessLogDO> getApiAccessLogPage(ApiAccessLogPageReqVO pageReqVO) {
        return apiAccessLogMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ApiAccessLogDO> getApiAccessLogList(ApiAccessLogExportReqVO exportReqVO) {
        return apiAccessLogMapper.selectList(exportReqVO);
    }

}
