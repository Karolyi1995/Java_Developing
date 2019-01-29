package spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value="classpath:${environment}.properties")
public class SpringLoginConfig {

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public Map<String,String> userMap(){
        Map<String,String> users = new HashMap<>();
        users.put(username,password);
        return users;
    }

    /*@Bean
    public static PropertyPlaceholderConfigurer properties(){
        PropertyPlaceholderConfigurer prop = new PropertyPlaceholderConfigurer();
        prop.setLocation(new ClassPathResource(System.getProperty("environment") + ".properties"));
        return prop;
    }*/


}
