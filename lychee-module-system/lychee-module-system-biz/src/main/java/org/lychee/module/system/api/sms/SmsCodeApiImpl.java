package org.lychee.module.system.api.sms;

import org.lychee.framework.common.pojo.CommonResult;
import org.lychee.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import org.lychee.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import org.lychee.module.system.api.sms.dto.code.SmsCodeValidateReqDTO;
import org.lychee.module.system.service.sms.SmsCodeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static org.lychee.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class SmsCodeApiImpl implements SmsCodeApi {

    @Resource
    private SmsCodeService smsCodeService;

    @Override
    public CommonResult<Boolean> sendSmsCode(SmsCodeSendReqDTO reqDTO) {
        smsCodeService.sendSmsCode(reqDTO);
        return success(true);
    }

    @Override
    public CommonResult<Boolean> useSmsCode(SmsCodeUseReqDTO reqDTO) {
        smsCodeService.useSmsCode(reqDTO);
        return success(true);
    }

    @Override
    public CommonResult<Boolean> validateSmsCode(SmsCodeValidateReqDTO reqDTO) {
        smsCodeService.validateSmsCode(reqDTO);
        return success(true);
    }

}
