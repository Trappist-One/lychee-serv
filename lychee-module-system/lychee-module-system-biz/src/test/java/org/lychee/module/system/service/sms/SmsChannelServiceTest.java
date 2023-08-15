package org.lychee.module.system.service.sms;

import org.lychee.framework.common.enums.CommonStatusEnum;
import org.lychee.framework.common.pojo.PageResult;
import org.lychee.framework.sms.core.client.SmsClientFactory;
import org.lychee.framework.test.core.ut.BaseDbUnitTest;
import org.lychee.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import org.lychee.module.system.controller.admin.sms.vo.channel.SmsChannelPageReqVO;
import org.lychee.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import org.lychee.module.system.dal.dataobject.sms.SmsChannelDO;
import org.lychee.module.system.dal.mysql.sms.SmsChannelMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

import static org.lychee.framework.common.util.date.LocalDateTimeUtils.buildBetweenTime;
import static org.lychee.framework.common.util.date.LocalDateTimeUtils.buildTime;
import static org.lychee.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static org.lychee.framework.test.core.util.AssertUtils.*;
import static org.lychee.framework.test.core.util.RandomUtils.*;
import static org.lychee.module.system.enums.ErrorCodeConstants.SMS_CHANNEL_HAS_CHILDREN;
import static org.lychee.module.system.enums.ErrorCodeConstants.SMS_CHANNEL_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@Import(SmsChannelServiceImpl.class)
public class SmsChannelServiceTest extends BaseDbUnitTest {

    @Resource
    private SmsChannelServiceImpl smsChannelService;

    @Resource
    private SmsChannelMapper smsChannelMapper;

    @MockBean
    private SmsClientFactory smsClientFactory;
    @MockBean
    private SmsTemplateService smsTemplateService;

    @Test
    public void testInitLocalCache_success() {
        // mock 数据
        SmsChannelDO smsChannelDO01 = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(smsChannelDO01);
        SmsChannelDO smsChannelDO02 = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(smsChannelDO02);

        // 调用
        smsChannelService.initLocalCache();
        // 校验调用
        verify(smsClientFactory, times(1)).createOrUpdateSmsClient(
                argThat(properties -> isPojoEquals(smsChannelDO01, properties)));
        verify(smsClientFactory, times(1)).createOrUpdateSmsClient(
                argThat(properties -> isPojoEquals(smsChannelDO02, properties)));
        // 断言 channelCache 缓存
        assertEquals(2, smsChannelService.getChannelCache().size());
        assertPojoEquals(smsChannelDO01, smsChannelService.getChannelCache().get(0));
        assertPojoEquals(smsChannelDO02, smsChannelService.getChannelCache().get(1));
    }

    @Test
    public void testCreateSmsChannel_success() {
        // 准备参数
        SmsChannelCreateReqVO reqVO = randomPojo(SmsChannelCreateReqVO.class, o -> o.setStatus(randomCommonStatus()));

        // 调用
        Long smsChannelId = smsChannelService.createSmsChannel(reqVO);
        // 断言
        assertNotNull(smsChannelId);
        // 校验记录的属性是否正确
        SmsChannelDO smsChannel = smsChannelMapper.selectById(smsChannelId);
        assertPojoEquals(reqVO, smsChannel);
    }

    @Test
    public void testUpdateSmsChannel_success() {
        // mock 数据
        SmsChannelDO dbSmsChannel = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(dbSmsChannel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        SmsChannelUpdateReqVO reqVO = randomPojo(SmsChannelUpdateReqVO.class, o -> {
            o.setId(dbSmsChannel.getId()); // 设置更新的 ID
            o.setStatus(randomCommonStatus());
            o.setCallbackUrl(randomString());
        });

        // 调用
        smsChannelService.updateSmsChannel(reqVO);
        // 校验是否更新正确
        SmsChannelDO smsChannel = smsChannelMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, smsChannel);
    }

    @Test
    public void testUpdateSmsChannel_notExists() {
        // 准备参数
        SmsChannelUpdateReqVO reqVO = randomPojo(SmsChannelUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> smsChannelService.updateSmsChannel(reqVO), SMS_CHANNEL_NOT_EXISTS);
    }

    @Test
    public void testDeleteSmsChannel_success() {
        // mock 数据
        SmsChannelDO dbSmsChannel = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(dbSmsChannel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSmsChannel.getId();

        // 调用
        smsChannelService.deleteSmsChannel(id);
        // 校验数据不存在了
        assertNull(smsChannelMapper.selectById(id));
    }

    @Test
    public void testDeleteSmsChannel_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> smsChannelService.deleteSmsChannel(id), SMS_CHANNEL_NOT_EXISTS);
    }

    @Test
    public void testDeleteSmsChannel_hasChildren() {
        // mock 数据
        SmsChannelDO dbSmsChannel = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(dbSmsChannel);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSmsChannel.getId();
        // mock 方法
        when(smsTemplateService.countByChannelId(eq(id))).thenReturn(10L);

        // 调用, 并断言异常
        assertServiceException(() -> smsChannelService.deleteSmsChannel(id), SMS_CHANNEL_HAS_CHILDREN);
    }

    @Test
    public void testGetSmsChannel() {
        // mock 数据
        SmsChannelDO dbSmsChannel = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(dbSmsChannel); // @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbSmsChannel.getId();

        // 调用，并断言
        assertPojoEquals(dbSmsChannel, smsChannelService.getSmsChannel(id));
    }

    @Test
    public void testGetSmsChannelList() {
        // mock 数据
        SmsChannelDO dbSmsChannel01 = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(dbSmsChannel01);
        SmsChannelDO dbSmsChannel02 = randomPojo(SmsChannelDO.class);
        smsChannelMapper.insert(dbSmsChannel02);
        // 准备参数

        // 调用
        List<SmsChannelDO> list = smsChannelService.getSmsChannelList();
        // 断言
        assertEquals(2, list.size());
        assertPojoEquals(dbSmsChannel01, list.get(0));
        assertPojoEquals(dbSmsChannel02, list.get(1));
    }

    @Test
    public void testGetSmsChannelPage() {
        // mock 数据
        SmsChannelDO dbSmsChannel = randomPojo(SmsChannelDO.class, o -> { // 等会查询到
            o.setSignature("芋道源码");
            o.setStatus(CommonStatusEnum.ENABLE.getStatus());
            o.setCreateTime(buildTime(2020, 12, 12));
        });
        smsChannelMapper.insert(dbSmsChannel);
        // 测试 signature 不匹配
        smsChannelMapper.insert(cloneIgnoreId(dbSmsChannel, o -> o.setSignature("源码")));
        // 测试 status 不匹配
        smsChannelMapper.insert(cloneIgnoreId(dbSmsChannel, o -> o.setStatus(CommonStatusEnum.DISABLE.getStatus())));
        // 测试 createTime 不匹配
        smsChannelMapper.insert(cloneIgnoreId(dbSmsChannel, o -> o.setCreateTime(buildTime(2020, 11, 11))));
        // 准备参数
        SmsChannelPageReqVO reqVO = new SmsChannelPageReqVO();
        reqVO.setSignature("芋道");
        reqVO.setStatus(CommonStatusEnum.ENABLE.getStatus());
        reqVO.setCreateTime(buildBetweenTime(2020, 12, 1, 2020, 12, 24));

        // 调用
        PageResult<SmsChannelDO> pageResult = smsChannelService.getSmsChannelPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbSmsChannel, pageResult.getList().get(0));
    }

}
