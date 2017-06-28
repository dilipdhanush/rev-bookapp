package com.revature.booksweb;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class BooksWebApplication {

	 @Bean
	 public JdbcTemplate getJdbcTemplate(DataSource dataSource){
		 JdbcTemplate jt=new JdbcTemplate();
		 jt.setDataSource(dataSource);
		 return jt;
	 }
	public static void main(String[] args) {
		SpringApplication.run(BooksWebApplication.class, args);
	}
}
