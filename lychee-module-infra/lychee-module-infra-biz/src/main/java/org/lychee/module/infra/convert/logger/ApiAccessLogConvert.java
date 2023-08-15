package org.lychee.module.infra.convert.logger;

import org.lychee.framework.apilog.core.service.ApiAccessLog;
import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.infra.api.logger.dto.ApiAccessLogCreateReqDTO;
import org.lychee.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogExcelVO;
import org.lychee.module.infra.controller.admin.logger.vo.apiaccesslog.ApiAccessLogRespVO;
import org.lychee.module.infra.dal.dataobject.logger.ApiAccessLogDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * API 访问日志 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface ApiAccessLogConvert {

    ApiAccessLogConvert INSTANCE = Mappers.getMapper(ApiAccessLogConvert.class);

    ApiAccessLogRespVO convert(ApiAccessLogDO bean);

    List<ApiAccessLogRespVO> convertList(List<ApiAccessLogDO> list);

    PageResult<ApiAccessLogRespVO> convertPage(PageResult<ApiAccessLogDO> page);

    List<ApiAccessLogExcelVO> convertList02(List<ApiAccessLogDO> list);

    ApiAccessLogDO convert(ApiAccessLogCreateReqDTO bean);

}
