package org.lychee.module.infra.convert.file;

import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.infra.controller.admin.file.vo.file.FileRespVO;
import org.lychee.module.infra.dal.dataobject.file.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileConvert {

    FileConvert INSTANCE = Mappers.getMapper(FileConvert.class);

    FileRespVO convert(FileDO bean);

    PageResult<FileRespVO> convertPage(PageResult<FileDO> page);

}
