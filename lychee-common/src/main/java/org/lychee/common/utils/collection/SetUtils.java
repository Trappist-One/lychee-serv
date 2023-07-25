package org.lychee.common.utils.collection;

import cn.hutool.core.collection.CollUtil;

import java.util.Set;

/**
 * Set 工具类
 *
 * @author xu
 * @since 1.0
 */
public class SetUtils {

    @SafeVarargs
    public static <T> Set<T> asSet(T... objs) {
        return CollUtil.newHashSet(objs);
    }

}
