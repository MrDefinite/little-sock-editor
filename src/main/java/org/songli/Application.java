package org.songli;

import org.songli.web.WebUrls;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean(name = WebUrls.WEB_SERVLET_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean(name = WebUrls.WEB_SERVLET_REG_BEAN)
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(
                dispatcherServlet(),
                WebUrls.WEB_CONTEXT_PATTERN);
        registrationBean.setName(WebUrls.WEB_SERVLET_NAME);
        return registrationBean;
    }

}




