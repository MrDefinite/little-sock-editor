package org.songli.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.GzipResourceResolver;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration("webConfig")
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${static.resource.cache.expiration:31536000}")
    private Integer STATIC_RESOURCE_CACHE_EXPIRATION;

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

    @Bean
    public FreeMarkerConfigurer createFreeMarkerFactory(){
        FreeMarkerConfigurer freeMarkerFactoryBean = new FreeMarkerConfigurer();
        freeMarkerFactoryBean.setTemplateLoaderPaths("classpath:/public/");
        freeMarkerFactoryBean.setDefaultEncoding("UTF-8");
        return freeMarkerFactoryBean;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        CacheControl cacheControl = CacheControl
                .maxAge(STATIC_RESOURCE_CACHE_EXPIRATION, TimeUnit.SECONDS)
                .sMaxAge(STATIC_RESOURCE_CACHE_EXPIRATION, TimeUnit.SECONDS)
                .noTransform()
                .cachePublic();

        registry.addResourceHandler("/*")
                .addResourceLocations("/public/", "classpath:/public/")
                .setCacheControl(cacheControl)
                .resourceChain(true)
                .addResolver(new GzipResourceResolver())
                .addResolver(new PathResourceResolver());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new InternalResourceViewResolver());
    }

}
