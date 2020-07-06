package co.edu.cedesistemas.ecommerce.config;

import co.edu.cedesistemas.ecommerce.model.Store;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.security.spec.NamedParameterSpec;
import java.util.HashMap;
import java.util.Map;

public class CommerceConfig {
    private static final String CONNECTOR_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    //@Bean
    public BasicDataSource basicDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(CONNECTOR_DRIVER);
        dataSource.setUrl(DB_URL);
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);

        return dataSource;
    }

    //@Bean
    public Map<String, Store> storeMap(){
        return new HashMap<>();

    }

    //@Bean
    public NamedParameterJdbcTemplate jdbcTemplate(BasicDataSource basicDataSource){
        return new NamedParameterJdbcTemplate(basicDataSource);
    }
}
