package org.lychee.module.system.convert.mail;

import org.lychee.framework.common.pojo.PageResult;
import org.lychee.module.system.controller.admin.mail.vo.template.MailTemplateCreateReqVO;
import org.lychee.module.system.controller.admin.mail.vo.template.MailTemplateRespVO;
import org.lychee.module.system.controller.admin.mail.vo.template.MailTemplateSimpleRespVO;
import org.lychee.module.system.controller.admin.mail.vo.template.MailTemplateUpdateReqVO;
import org.lychee.module.system.dal.dataobject.mail.MailTemplateDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MailTemplateConvert {

    MailTemplateConvert INSTANCE = Mappers.getMapper(MailTemplateConvert.class);

    MailTemplateDO convert(MailTemplateUpdateReqVO bean);

    MailTemplateDO convert(MailTemplateCreateReqVO bean);

    MailTemplateRespVO convert(MailTemplateDO bean);

    PageResult<MailTemplateRespVO> convertPage(PageResult<MailTemplateDO> pageResult);

    List<MailTemplateSimpleRespVO> convertList02(List<MailTemplateDO> list);

}
