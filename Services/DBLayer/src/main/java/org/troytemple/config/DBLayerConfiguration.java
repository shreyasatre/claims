package org.troytemple.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.troytemple.dao.UserRepository;
import org.troytemple.security.impl.SecurityServiceImpl;
import org.troytemple.service.authentication.AuthenticationImpl;
import org.troytemple.transformer.SubmitClaimsTransformer;

/**
 * Created by bt_te on 2/14/2016.`
 */
@SpringBootApplication(scanBasePackages = "org.troytemple")
public class DBLayerConfiguration extends SpringBootServletInitializer {

    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate();
    }

    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public AuthenticationImpl authenticationImpl() {
        return new AuthenticationImpl();
    }

    @Bean
    public SecurityServiceImpl securityServiceImpl() {
        return new SecurityServiceImpl();
    }

    @Bean
    public SubmitClaimsTransformer submitClaimsTransformer() {
        return new SubmitClaimsTransformer();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DBLayerConfiguration.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DBLayerConfiguration.class);
    }

}
