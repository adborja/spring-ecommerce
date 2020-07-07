package co.edu.cedesistemas.ecommerce.config;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import co.edu.cedesistemas.ecommerce.model.Store;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class CommerceConfig {
    private static final String CONNECTOR_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    @Bean
    public BasicDataSource basicDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(CONNECTOR_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);

        return dataSource;
    }

    @Bean
    public Map<String, Store> storeMap() {
        return new HashMap<>();
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(BasicDataSource basicDataSource) {
        return new NamedParameterJdbcTemplate(basicDataSource);
    }
}
