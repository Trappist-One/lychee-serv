package org.lychee.module.mp.dal.mysql.tag;

import org.lychee.framework.common.pojo.PageResult;
import org.lychee.framework.mybatis.core.mapper.BaseMapperX;
import org.lychee.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lychee.module.mp.controller.admin.tag.vo.MpTagPageReqVO;
import org.lychee.module.mp.dal.dataobject.tag.MpTagDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MpTagMapper extends BaseMapperX<MpTagDO> {

    default PageResult<MpTagDO> selectPage(MpTagPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MpTagDO>()
                .eqIfPresent(MpTagDO::getAccountId, reqVO.getAccountId())
                .likeIfPresent(MpTagDO::getName, reqVO.getName())
                .orderByDesc(MpTagDO::getId));
    }

    default List<MpTagDO> selectListByAccountId(Long accountId) {
        return selectList(MpTagDO::getAccountId, accountId);
    }

}
