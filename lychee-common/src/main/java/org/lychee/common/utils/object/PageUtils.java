package org.lychee.common.utils.object;


import org.lychee.common.pojo.PageParam;

/**
 * {@link org.lychee.common.pojo.PageParam} 工具类
 *
 * @author xu
 * @since 1.0
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
