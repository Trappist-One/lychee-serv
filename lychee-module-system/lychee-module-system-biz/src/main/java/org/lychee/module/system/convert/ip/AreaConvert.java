package org.lychee.module.system.convert.ip;

import org.lychee.framework.ip.core.Area;
import org.lychee.framework.ip.core.enums.AreaTypeEnum;
import org.lychee.module.system.controller.admin.ip.vo.AreaNodeRespVO;
import org.lychee.module.system.controller.admin.ip.vo.AreaNodeSimpleRespVO;
import org.lychee.module.system.controller.app.ip.vo.AppAreaNodeRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

@Mapper
public interface AreaConvert {

    AreaConvert INSTANCE = Mappers.getMapper(AreaConvert.class);

    List<AreaNodeRespVO> convertList(List<Area> list);

    List<AreaNodeSimpleRespVO> convertList2(List<Area> list);

    @Mapping(source = "type", target = "leaf")
    AreaNodeSimpleRespVO convert(Area area);

    default Boolean convertAreaType(Integer type) {
        return Objects.equals(AreaTypeEnum.DISTRICT.getType(), type);
    }

    List<AppAreaNodeRespVO> convertList3(List<Area> list);

}
