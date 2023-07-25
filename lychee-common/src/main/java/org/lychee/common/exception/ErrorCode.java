package org.lychee.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author xu
 * @desc 错误代码
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class ErrorCode {

    private final Integer code;

    private final String msg;
}
