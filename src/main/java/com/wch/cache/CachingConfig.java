package com.wch.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

/**
 * cache config
 * @author CasparWang
 *
 */
@Configuration
@EnableCaching
public class CachingConfig
{
	/*@Bean
	public CacheManager cacheManager()
	{
		return new ConcurrentMapCacheManager();
	}*/
	
	@Bean
	public  EhCacheCacheManager cacheManager(CacheManager cm)
	{
		return new EhCacheCacheManager(cm);
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehcache()
	{
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = 
				new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(
            new ClassPathResource(""));
		
		return ehCacheManagerFactoryBean;
	}

}
