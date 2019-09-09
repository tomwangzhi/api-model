package com.wz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


import java.io.Serializable;


@Configuration
public class RedisConfig {


    @Bean
    RedisTemplate<Serializable,Serializable> redisTemplate() {
        /**
         * 初始化操作redis的关键类
         */
        RedisTemplate redisTemplate = new RedisTemplate();
        // 使用jdk自带的序列化方式
        redisTemplate.setEnableDefaultSerializer(true);
        // 这里必须要传RedisConnectionFactory这个实例，否则 继承接口InitializingBean的方法中有校验RedisConnectionFactory
        // 是否存在  afterPropertiesSet 我们自己的类也可以继承这个，对于属性设置之后的类进行参数校验
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    RedisConnectionFactory redisConnectionFactory() {
        /**
         * 实例化连接工厂类
         * 1. 可以得到连接相关的信息
         * 2. 可以得到集群配置连接相关的信息，这里可以设置集群相关的
         */
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        return jedisConnectionFactory;
    }

}
