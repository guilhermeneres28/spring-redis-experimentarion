package br.com.neres.redissample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.util.Arrays;
import java.util.List;

@Configuration
public class RedisPoolConfig {

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        List<String> nodes = Arrays.asList("173.18.0.5:6379", "173.18.0.6:6379", "173.18.0.7:6379");
        return new LettuceConnectionFactory(new RedisClusterConfiguration(nodes));
    }
}
