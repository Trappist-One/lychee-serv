package org.lychee.module.system.dal.mysql.mail;

import org.lychee.framework.common.pojo.PageResult;
import org.lychee.framework.mybatis.core.mapper.BaseMapperX;
import org.lychee.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lychee.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import org.lychee.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername()));
    }

}
