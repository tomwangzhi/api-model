package com.wz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;


import java.lang.reflect.Method;

/**
 * 缓存实现策略配置  可以用各种存储形式
 * 只要是实现 CacheManager这个类的都行，可以用redis或者是内存
 */

@Slf4j
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Override
    public CacheManager cacheManager() {
        /**
         *  1. 用内存来维护缓存
         */
//        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        /**
         *  2. 用redis来维护缓存
         */

        RedisCacheManager redisCacheManager = RedisCacheManager.create(redisConnectionFactory);
        return redisCacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new MyKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }

    public static class MyKeyGenerator implements KeyGenerator{

        @Override
        public Object generate(Object target, Method method, Object... params) {
            log.info("##########缓存进来###########");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(target.getClass().getName());
            stringBuilder.append(":");
            stringBuilder.append(method.getName());
            stringBuilder.append(":");
            for (int i = 0; i < params.length; i++) {
                Object param = params[i];
                stringBuilder.append(param);
                stringBuilder.append(",");
            }
            return stringBuilder;
        }
    }
}
