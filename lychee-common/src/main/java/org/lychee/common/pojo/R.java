package org.lychee.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xu
 * @desc
 * @since 1.0
 */
@Data
public class R<T> implements Serializable {
    private Integer code;

    private String msg;

    private T data;

    private Long uuid;
}
