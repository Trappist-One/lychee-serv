package org.lychee.module.infra.convert.logger;

import org.lychee.framework.apilog.core.service.ApiErrorLog;
import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.infra.api.logger.dto.ApiErrorLogCreateReqDTO;
import org.lychee.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogExcelVO;
import org.lychee.module.infra.controller.admin.logger.vo.apierrorlog.ApiErrorLogRespVO;
import org.lychee.module.infra.dal.dataobject.logger.ApiErrorLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 错误日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiErrorLogConvert {

    ApiErrorLogConvert INSTANCE = Mappers.getMapper(ApiErrorLogConvert.class);

    ApiErrorLogRespVO convert(ApiErrorLogDO bean);

    PageResult<ApiErrorLogRespVO> convertPage(PageResult<ApiErrorLogDO> page);

    List<ApiErrorLogExcelVO> convertList02(List<ApiErrorLogDO> list);

    ApiErrorLogDO convert(ApiErrorLogCreateReqDTO bean);

}
