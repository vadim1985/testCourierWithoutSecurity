package config;

import DAO.OrderNumberDao;
import DAO.OrderNumberDaoImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import service.OrderNumberService;
import service.OrderNumberServiceImpl;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String jdbcURL;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcURL);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public OrderNumberDao getOrderNumberDao(){
        return new OrderNumberDaoImpl(getJdbcTemplate());
    }
    @Bean
    public OrderNumberService getOrderNumberService(){
    return new OrderNumberServiceImpl();
    }
}
