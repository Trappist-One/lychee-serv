package org.lychee.module.bpm.dal.mysql.definition;


import org.lychee.module.bpm.controller.admin.definition.vo.form.BpmFormPageReqVO;
import org.lychee.module.bpm.dal.dataobject.definition.BpmFormDO;
import org.lychee.framework.common.pojo.PageResult;
import org.lychee.framework.mybatis.core.mapper.BaseMapperX;
import org.lychee.framework.mybatis.core.query.QueryWrapperX;
import org.apache.ibatis.annotations.Mapper;

/**
 * 动态表单 Mapper
 *
 * @author 风里雾里
 */
@Mapper
public interface BpmFormMapper extends BaseMapperX<BpmFormDO> {

    default PageResult<BpmFormDO> selectPage(BpmFormPageReqVO reqVO) {
        return selectPage(reqVO, new QueryWrapperX<BpmFormDO>()
                .likeIfPresent("name", reqVO.getName())
                .orderByDesc("id"));
    }

}
