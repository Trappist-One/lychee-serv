package org.lychee.module.pay.api.refund;

import org.lychee.module.pay.api.refund.dto.PayRefundCreateReqDTO;
import org.lychee.module.pay.api.refund.dto.PayRefundRespDTO;
import org.lychee.module.pay.convert.refund.PayRefundConvert;
import org.lychee.module.pay.service.refund.PayRefundService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Service
@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class PayRefundApiImpl implements PayRefundApi {

    @Resource
    private PayRefundService payRefundService;

    @Override
    public Long createRefund(PayRefundCreateReqDTO reqDTO) {
        return payRefundService.createPayRefund(reqDTO);
    }

    @Override
    public PayRefundRespDTO getRefund(Long id) {
        return PayRefundConvert.INSTANCE.convert02(payRefundService.getRefund(id));
    }

}
