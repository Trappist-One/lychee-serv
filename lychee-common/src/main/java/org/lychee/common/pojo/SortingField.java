package org.lychee.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xu
 * @desc 字段排序类
 * @since 1.0
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class SortingField {
    /**
     * 顺序 - 升序
     */
    public static final String ORDER_ASC = "asc";
    /**
     * 顺序 - 降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 字段
     */
    private String field;
    /**
     * 顺序
     */
    private String order;
}
