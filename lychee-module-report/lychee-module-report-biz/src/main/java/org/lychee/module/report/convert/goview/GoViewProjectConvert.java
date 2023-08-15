package org.lychee.module.report.convert.goview;

import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.report.controller.admin.goview.vo.project.GoViewProjectCreateReqVO;
import org.lychee.module.report.controller.admin.goview.vo.project.GoViewProjectRespVO;
import org.lychee.module.report.controller.admin.goview.vo.project.GoViewProjectUpdateReqVO;
import org.lychee.module.report.dal.dataobject.goview.GoViewProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GoViewProjectConvert {

    GoViewProjectConvert INSTANCE = Mappers.getMapper(GoViewProjectConvert.class);

    GoViewProjectDO convert(GoViewProjectCreateReqVO bean);

    GoViewProjectDO convert(GoViewProjectUpdateReqVO bean);

    GoViewProjectRespVO convert(GoViewProjectDO bean);

    PageResult<GoViewProjectRespVO> convertPage(PageResult<GoViewProjectDO> page);

}
