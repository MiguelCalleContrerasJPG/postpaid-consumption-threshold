package com.telefonica.postpaidconsumption.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Configuracion base para consultar bd redis
 * 
 * @Author: Moises Zarate G.
 * @Datecreation: 15/12/2020 03:22:03 PM
 * @FileName: RedisConfig.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: description details
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
	RedisTemplate<?, ?> template = new RedisTemplate<>();
	template.setConnectionFactory(connectionFactory);
	return template;
    }

}