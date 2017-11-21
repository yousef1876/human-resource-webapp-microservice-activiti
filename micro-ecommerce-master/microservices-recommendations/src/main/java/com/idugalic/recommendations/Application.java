package com.idugalic.recommendations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.idugalic.recommendations.repositories")
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Configuration
	@EnableResourceServer
	static class ResourceServer extends ResourceServerConfigurerAdapter {

		@Override
		public void configure(HttpSecurity http) throws Exception {
			http.requestMatchers().and().authorizeRequests().antMatchers(HttpMethod.GET, "/recommendations/**")
					.access("#oauth2.hasScope('read_recommendations') and (hasRole('ROLE_ADMIN') or hasRole('ROLE_USER'))")
					.antMatchers(HttpMethod.GET, "/products/**")
					.access("#oauth2.hasScope('read_recommendations') and (hasRole('ROLE_ADMIN') or hasRole('ROLE_USER'))")
					.antMatchers(HttpMethod.POST, "/**")
					.access("#oauth2.hasScope('write_recommendations') and hasRole('ROLE_ADMIN')")
					.antMatchers(HttpMethod.PUT, "/**")
					.access("#oauth2.hasScope('write_recommendations') and hasRole('ROLE_ADMIN')")
					.antMatchers(HttpMethod.DELETE, "/**")
					.access("#oauth2.hasScope('write_recommendations') and hasRole('ROLE_ADMIN')")

					// .antMatchers("/health/**").anonymous()
					// .antMatchers("/info/**").anonymous()
					.antMatchers("/metrics/**").access("#oauth2.hasScope('metrics')").antMatchers("/trace/**")
					.access("#oauth2.hasScope('trace')").antMatchers("/dump/**").access("#oauth2.hasScope('dump')")
					.antMatchers("/shutdown/**").access("#oauth2.hasScope('shutdown')").antMatchers("/beans/**")
					.access("#oauth2.hasScope('beans')").antMatchers("/autoconfig/**")
					.access("#oauth2.hasScope('autoconfig')").antMatchers("/configprops/**")
					.access("#oauth2.hasScope('configprops')").antMatchers("/env/**").access("#oauth2.hasScope('env')")
					.antMatchers("/mappings/**").access("#oauth2.hasScope('mappings')");

		}

	}

}
