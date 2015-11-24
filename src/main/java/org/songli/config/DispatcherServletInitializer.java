package org.songli.config;

import org.songli.web.WebUrls;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{WebUrls.WEB_CONTEXT_PATH};
    }

    @Override
    protected String getServletName() {
        return WebUrls.WEB_SERVLET_NAME;
    }
}
