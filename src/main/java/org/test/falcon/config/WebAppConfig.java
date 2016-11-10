package org.test.falcon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableMongoRepositories(basePackages = "org.test.falcon")
public class WebAppConfig extends WebMvcConfig {

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/apidocs").setViewName("ui");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/swagger/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/lib/**").addResourceLocations("/WEB-INF/swagger/lib/");
        resourceHandlerRegistry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/swagger/css/");
        resourceHandlerRegistry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/swagger/fonts/");
        resourceHandlerRegistry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/swagger/images/");
        resourceHandlerRegistry.addResourceHandler("/**").addResourceLocations("/WEB-INF/swagger/");
    }

}
