package org.lychee.module.infra.service.logger;

import org.lychee.framework.apilog.core.service.ApiAccessLog;
import org.lychee.framework.apilog.core.service.ApiAccessLogFrameworkService;
import org.lychee.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import org.lychee.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExportReqVO;
import org.lychee.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogPageReqVO;
import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.infra.dal.dataobject.logger.ApiAccessLogDO;

import java.util.List;

/**
 * API 访问日志 Service 接口
 *
 * @author 芋道源码
 */
public interface ApiAccessLogService {

    /**
     * 创建 API 访问日志
     *
     * @param createReqDTO API 访问日志
     */
    void createApiAccessLog(ApiAccessLogCreateReqDTO createReqDTO);

    /**
     * 获得 API 访问日志分页
     *
     * @param pageReqVO 分页查询
     * @return API 访问日志分页
     */
    PageResult<ApiAccessLogDO> getApiAccessLogPage(ApiAccessLogPageReqVO pageReqVO);

    /**
     * 获得 API 访问日志列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return API 访问日志分页
     */
    List<ApiAccessLogDO> getApiAccessLogList(ApiAccessLogExportReqVO exportReqVO);

}
