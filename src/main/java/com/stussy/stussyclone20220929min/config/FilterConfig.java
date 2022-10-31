package com.stussy.stussyclone20220929min.config;

import com.stussy.stussyclone20220929min.filter.JWTFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;

@Configuration
public class FilterConfig {

    public FilterRegistrationBean filter1() {
        FilterRegistrationBean reg = new FilterRegistrationBean(new JWTFilter());
        reg.setOrder(Integer.MIN_VALUE);
        reg.addUrlPatterns("/api/*");
        return reg;
    }
}
