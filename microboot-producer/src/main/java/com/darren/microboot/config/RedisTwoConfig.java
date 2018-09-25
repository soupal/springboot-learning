package com.darren.microboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.darren.microboot.serializer.RedisObjectSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisTwoConfig {

	@Bean("redisTwo")
	public RedisTemplate<String, Object> getRedisTemplate(@Value("${spring.redis-two.host}") String hostName,
			@Value("${spring.redis-two.password}") String password, @Value("${spring.redis-two.port}") int port,
			@Value("${spring.redis-two.database}") int database, @Value("${spring.redis-two.pool.max-active}") int maxActive,
			@Value("${spring.redis-two.pool.max-idle}") int maxIdle, @Value("${spring.redis-two.pool.min-idle}") int minIdle,
			@Value("${spring.redis-two.pool.max-wait}") int maxWait) {
		RedisConnectionFactory factory = getRedisConnectionFactory(hostName, password, port, maxActive, maxIdle, minIdle, maxWait,
				database);
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(factory);
		// key的序列化类型
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		// value的序列化类型
		redisTemplate.setValueSerializer(new RedisObjectSerializer());
		return redisTemplate;
	}

	public RedisConnectionFactory getRedisConnectionFactory(String hostname, String password, int port, int maxTotal, int maxIdle,
			int minIdle, long maxWaitMillis, int database) {
		JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
		jedisFactory.setHostName(hostname);
		jedisFactory.setPort(port);
		jedisFactory.setPassword(password);
		jedisFactory.setDatabase(database);
		JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
		poolConfig.setMaxTotal(maxTotal);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxWaitMillis(maxWaitMillis);
		jedisFactory.setPoolConfig(poolConfig);
		jedisFactory.afterPropertiesSet(); // 初始化连接池配置
		return jedisFactory;
	}

}
