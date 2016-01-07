package org.pirat9600q.configs;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean registerSiteMeshFilter() {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new SiteMeshFilter());
        frb.addUrlPatterns("/*");
        frb.setName("default");
        return frb;
    }
}
