package com.hr.framework.config;

import com.hr.framework.interceptor.LogInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

  @Override public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(logInterceptor);
  }

  private final LogInterceptor logInterceptor;

  @Autowired public WebMvcConfiguration(LogInterceptor logInterceptor) {
    this.logInterceptor = logInterceptor;
  }
}
