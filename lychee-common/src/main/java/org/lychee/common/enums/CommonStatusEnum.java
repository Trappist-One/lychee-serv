package org.lychee.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.lychee.common.core.IntArrayValuable;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum CommonStatusEnum implements IntArrayValuable {
    /**
     *
     */
    ON(0, "开启"),
    OFF(1, "关闭");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(CommonStatusEnum::getStatus).toArray();

    private final int status;
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
