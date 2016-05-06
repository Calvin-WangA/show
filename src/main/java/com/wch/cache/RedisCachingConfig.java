package com.wch.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis Cache
 * 
 * @author CasparWang
 *
 */
@Configuration
@EnableCaching
public class RedisCachingConfig
{
	@Bean
	public CacheManager cacheManager(RedisTemplate<String
			, String> redisTemplate)
	{
		return new RedisCacheManager(redisTemplate);
	}

	@Bean
	public JedisConnectionFactory redisConnectionFactory()
	{
		JedisConnectionFactory jedisFactory = 
				new JedisConnectionFactory();
		jedisFactory.afterPropertiesSet();

		return jedisFactory;
	}

	@Bean
	public RedisTemplate<String, String> redisTempate(
			RedisConnectionFactory redisCF)
	{
		RedisTemplate<String, String> redisTemplate = 
				new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(redisCF);
		redisTemplate.afterPropertiesSet();

		return redisTemplate;
	}

	/**
	 * 可以同时使用多个缓存框架
	 */
	/*@Bean
	public CacheManager cacheManager(net.sf.ehcache.CacheManager cm
			, javax.cache.CacheManager jcm)
	{
		CompositeCacheManager cacheManager = new CompositeCacheManager();
		List<CacheManager> managers = new ArrayList<CacheManager>();
		managers.add(new JCacheCacheManager(jcm));
		managers.add(new EhCacheCacheManager(cm));
		managers.add(new RedisCacheManager(redisTemplate()));
		cacheManager.setCacheManagers(managers);
		return cacheManager;
	}*/
}
