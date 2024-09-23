package com.atmitvision.restapicruddemo.security;

import com.atmitvision.restapicruddemo.datasource.CustomDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource customDataSource() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/employee_directory";
        String username = "springstudent";
        String password = "springstudent";

        return new CustomDataSource(jdbcUrl, username, password);
    }
}
