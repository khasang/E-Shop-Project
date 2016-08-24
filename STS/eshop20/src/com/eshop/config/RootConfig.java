package com.eshop.config;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@ComponentScan(basePackages={"com.eshop"})
@PropertySource("classpath:database.properties")
public class RootConfig {
	@Autowired
	private Environment environment;
	
	@Bean(name="dataSource")
	public DataSource getDataSource()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalStateException {
		Driver driver = (Driver) Class.forName(environment.getProperty("db.driver")).newInstance();
		String url = environment.getProperty("db.url"),
				username = environment.getProperty("db.username"),
				password = environment.getProperty("db.password");		
		return new SimpleDriverDataSource(driver, url, username, password);
	}
	
	 @Bean(name = "jdbcTemplate")
     public JdbcTemplate jdbcTemplate() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalStateException {
	        return new JdbcTemplate(getDataSource());
    }
}
