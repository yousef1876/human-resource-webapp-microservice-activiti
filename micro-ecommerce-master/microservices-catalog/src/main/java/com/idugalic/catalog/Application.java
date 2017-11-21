package com.idugalic.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import com.idugalic.catalog.models.Category;
import com.idugalic.catalog.models.Product;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class Application

{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Configuration
	static class RestMvc extends RepositoryRestMvcConfiguration {

		@Override
		protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
			config.exposeIdsFor(Product.class, Category.class);
		}

	}

	@Configuration
	@EnableResourceServer
	static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.requestMatchers().and().authorizeRequests().antMatchers(HttpMethod.GET, "/products/**")
					.access("#oauth2.hasScope('read_catalog') and (hasRole('ROLE_ADMIN') or hasRole('ROLE_USER'))")
					.antMatchers(HttpMethod.GET, "/categories/**")
					.access("#oauth2.hasScope('read_catalog') and (hasRole('ROLE_ADMIN') or hasRole('ROLE_USER'))")
					.antMatchers(HttpMethod.POST, "/**")
					.access("#oauth2.hasScope('write_catalog') and hasRole('ROLE_ADMIN')")
					.antMatchers(HttpMethod.PUT, "/**")
					.access("#oauth2.hasScope('write_catalog') and hasRole('ROLE_ADMIN')")
					.antMatchers(HttpMethod.DELETE, "/**")
					.access("#oauth2.hasScope('write_catalog') and hasRole('ROLE_ADMIN')")

			// .antMatchers("/health/**").anonymous()
			// .antMatchers("/info/**").anonymous()
			// .antMatchers("/metrics/**").access("#oauth2.hasScope('metrics')")
			// .antMatchers("/trace/**").access("#oauth2.hasScope('trace')")
			// .antMatchers("/dump/**").access("#oauth2.hasScope('dump')")
			// .antMatchers("/shutdown/**").access("#oauth2.hasScope('shutdown')")
			// .antMatchers("/beans/**").access("#oauth2.hasScope('beans')")
			// .antMatchers("/autoconfig/**").access("#oauth2.hasScope('autoconfig')")
			// .antMatchers("/configprops/**").access("#oauth2.hasScope('configprops')")
			// .antMatchers("/env/**").access("#oauth2.hasScope('env')")
			// .antMatchers("/mappings/**").access("#oauth2.hasScope('mappings')")
			;

		}

	}

}
