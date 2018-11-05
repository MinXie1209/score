package org.javatribe.score.conf;

import org.javatribe.score.po.MyRedisSerializer;
import org.javatribe.score.po.Score;
import org.javatribe.score.po.ScoreAvg;
import org.javatribe.score.po.Team;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;

/**
 * @ClassName RedisConfig
 * @Description TODO
 * @Author 江南小俊
 * @Date 2018/11/4 20:35
 * @Version 1.0.0
 **/
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Team> teamRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,Team> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new MyRedisSerializer());
        return template;
    }
    @Bean
    public RedisTemplate<String,List<Team>> teamListRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,List<Team>> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new MyRedisSerializer());
        return template;
    }
    @Bean
    public RedisTemplate<String,List<ScoreAvg>> scoreRedisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String,List<ScoreAvg>> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new MyRedisSerializer());
        return template;
    }

}
