package org.lychee.framework.desensitize.core.handler;

import org.lychee.framework.desensitize.core.DesensitizeTest;
import org.lychee.framework.desensitize.core.base.handler.DesensitizationHandler;
import org.lychee.framework.desensitize.core.annotation.Address;

/**
 * {@link Address} 的脱敏处理器
 *
 * 用于 {@link DesensitizeTest} 测试使用
 */
public class AddressHandler implements DesensitizationHandler<Address> {

    @Override
    public String desensitize(String origin, Address annotation) {
        return origin + annotation.replacer();
    }

}
