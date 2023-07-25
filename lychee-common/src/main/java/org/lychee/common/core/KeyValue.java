package org.lychee.common.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xu
 * @desc 键值对
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyValue<K, V> {
    private K key;

    private V value;
}
