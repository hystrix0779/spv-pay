package com.icbc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.PropertySources;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * <p></p>
 *
 * @author Tony.niu (hystrix0779@yeah.net)
 **/
@Configuration
@Slf4j
public class BeanCreate {
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        //File引入
        yaml.setResources(new ClassPathResource("icbc-config.yml"));
        configurer.setProperties(Objects.requireNonNull(yaml.getObject()));
        return configurer;
    }
    @Resource
    private ApplicationContext applicationContext;

    @Bean
    public ICBCConfig icbcConfig(@Qualifier("properties") PropertySourcesPlaceholderConfigurer properties) {
        PropertySources sources = properties.getAppliedPropertySources();
        String active=applicationContext.getEnvironment().getActiveProfiles()[0];
        PropertySource<?> source = sources.get("localProperties");
        ICBCConfig icbcConfig=new ICBCConfig();
        String prefix="icbc."+active+".";
        if (Objects.nonNull(source)) {
            icbcConfig.setVersion((String) source.getProperty(prefix + "version"));
            icbcConfig.setMerId((String) source.getProperty(prefix + "mer_id"));
            icbcConfig.setAppId((String) source.getProperty(prefix + "app_id"));
            icbcConfig.setCharset((String) source.getProperty(prefix + "charset"));
            icbcConfig.setPriKey((String) source.getProperty(prefix + "pri_key"));
            icbcConfig.setApiUrl((String) source.getProperty(prefix + "api_url"));
            icbcConfig.setApiNamePrefix((String) source.getProperty(prefix + "api_name_prefix"));
        }else {
            log.error("icbc配置加载失败");
        }
        return icbcConfig;
    }
}
