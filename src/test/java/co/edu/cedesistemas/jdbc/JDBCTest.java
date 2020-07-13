package co.edu.cedesistemas.jdbc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    private final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "root";
    private final static String CHECK_QUERY = "SELECT version()";

    @Test
    public void testJDBCLoadDriver() throws Exception {
        Class.forName(JDBC_DRIVER);
    }

    @Test
    public void testJDBCConnection() throws Exception {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWORD);
        DatabaseMetaData metaData = connection.getMetaData();
        assertThat(connection.getMetaData(), notNullValue());
        assertThat(metaData.getDatabaseProductName(), equalTo("MySQL"));
    }

    @Test
    public void testJDBCQuery() throws Exception {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DB_USER, DB_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(CHECK_QUERY);
        while (resultSet.next()) {
            assertThat(resultSet.getString(1), startsWith("5.7"));
        }
    }
}