package org.lychee.module.system.service.logger;

import org.lychee.module.system.controller.admin.logger.vo.loginlog.LoginLogExportReqVO;
import org.lychee.module.system.controller.admin.logger.vo.loginlog.LoginLogPageReqVO;
import org.lychee.module.system.dal.dataobject.logger.LoginLogDO;
import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.system.api.logger.dto.LoginLogCreateReqDTO;

import javax.validation.Valid;
import java.util.List;

/**
 * 登录日志 Service 接口
 */
public interface LoginLogService {

    /**
     * 获得登录日志分页
     *
     * @param reqVO 分页条件
     * @return 登录日志分页
     */
    PageResult<LoginLogDO> getLoginLogPage(LoginLogPageReqVO reqVO);

    /**
     * 获得登录日志列表
     *
     * @param reqVO 列表条件
     * @return 登录日志列表
     */
    List<LoginLogDO> getLoginLogList(LoginLogExportReqVO reqVO);

    /**
     * 创建登录日志
     *
     * @param reqDTO 日志信息
     */
    void createLoginLog(@Valid LoginLogCreateReqDTO reqDTO);

}
