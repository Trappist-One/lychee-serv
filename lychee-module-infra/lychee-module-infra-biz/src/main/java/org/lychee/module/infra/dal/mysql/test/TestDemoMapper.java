package org.lychee.module.infra.dal.mysql.test;

import org.lychee.framework.common.pojo.PageResult;
import org.lychee.framework.mybatis.core.mapper.BaseMapperX;
import org.lychee.framework.mybatis.core.query.LambdaQueryWrapperX;
import org.lychee.module.infra.controller.admin.test.vo.TestDemoExportReqVO;
import org.lychee.module.infra.controller.admin.test.vo.TestDemoPageReqVO;
import org.lychee.module.infra.dal.dataobject.test.TestDemoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 字典类型 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface TestDemoMapper extends BaseMapperX<TestDemoDO> {

    default PageResult<TestDemoDO> selectPage(TestDemoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TestDemoDO>()
                .likeIfPresent(TestDemoDO::getName, reqVO.getName())
                .eqIfPresent(TestDemoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TestDemoDO::getType, reqVO.getType())
                .eqIfPresent(TestDemoDO::getCategory, reqVO.getCategory())
                .eqIfPresent(TestDemoDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(TestDemoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TestDemoDO::getId));
    }

    default List<TestDemoDO> selectList(TestDemoExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<TestDemoDO>()
                .likeIfPresent(TestDemoDO::getName, reqVO.getName())
                .eqIfPresent(TestDemoDO::getStatus, reqVO.getStatus())
                .eqIfPresent(TestDemoDO::getType, reqVO.getType())
                .eqIfPresent(TestDemoDO::getCategory, reqVO.getCategory())
                .eqIfPresent(TestDemoDO::getRemark, reqVO.getRemark())
                .betweenIfPresent(TestDemoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(TestDemoDO::getId));
    }

    List<TestDemoDO> selectList2();

}
