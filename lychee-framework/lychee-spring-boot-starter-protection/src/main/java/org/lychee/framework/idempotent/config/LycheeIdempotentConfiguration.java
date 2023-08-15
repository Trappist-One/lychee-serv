package org.lychee.framework.idempotent.config;

import org.lychee.framework.idempotent.core.aop.IdempotentAspect;
import org.lychee.framework.idempotent.core.keyresolver.impl.DefaultIdempotentKeyResolver;
import org.lychee.framework.idempotent.core.keyresolver.impl.ExpressionIdempotentKeyResolver;
import org.lychee.framework.idempotent.core.keyresolver.IdempotentKeyResolver;
import org.lychee.framework.idempotent.core.redis.IdempotentRedisDAO;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.lychee.framework.redis.config.LycheeRedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@AutoConfiguration(after = LycheeRedisAutoConfiguration.class)
public class LycheeIdempotentConfiguration {

    @Bean
    public IdempotentAspect idempotentAspect(List<IdempotentKeyResolver> keyResolvers, IdempotentRedisDAO idempotentRedisDAO) {
        return new IdempotentAspect(keyResolvers, idempotentRedisDAO);
    }

    @Bean
    public IdempotentRedisDAO idempotentRedisDAO(StringRedisTemplate stringRedisTemplate) {
        return new IdempotentRedisDAO(stringRedisTemplate);
    }

    // ========== 各种 IdempotentKeyResolver Bean ==========

    @Bean
    public DefaultIdempotentKeyResolver defaultIdempotentKeyResolver() {
        return new DefaultIdempotentKeyResolver();
    }

    @Bean
    public ExpressionIdempotentKeyResolver expressionIdempotentKeyResolver() {
        return new ExpressionIdempotentKeyResolver();
    }

}
