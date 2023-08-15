package org.lychee.module.system.convert.social;

import org.lychee.module.system.api.social.dto.SocialUserBindReqDTO;
import org.lychee.module.system.api.social.dto.SocialUserUnbindReqDTO;
import org.lychee.module.system.controller.admin.socail.vo.SocialUserBindReqVO;
import org.lychee.module.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SocialUserConvert {

    SocialUserConvert INSTANCE = Mappers.getMapper(SocialUserConvert.class);

    SocialUserBindReqDTO convert(Long userId, Integer userType, SocialUserBindReqVO reqVO);

    SocialUserUnbindReqDTO convert(Long userId, Integer userType, SocialUserUnbindReqVO reqVO);

}
