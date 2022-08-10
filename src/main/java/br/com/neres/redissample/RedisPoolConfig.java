package br.com.neres.redissample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;


import java.util.Arrays;
import java.util.List;

@Configuration
public class RedisPoolConfig {

    /*
    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        List<String> nodes = Arrays.asList("173.18.0.5:6379", "173.18.0.6:6379", "173.18.0.7:6379");
        return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
    }
     */

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxIdle(1000);
        jedisPoolConfig.setMinIdle(100);

        List<String> nodes = Arrays.asList("173.18.0.5:6379", "173.18.0.6:6379", "173.18.0.7:6379");
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(new RedisClusterConfiguration(nodes), jedisPoolConfig);
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
}
