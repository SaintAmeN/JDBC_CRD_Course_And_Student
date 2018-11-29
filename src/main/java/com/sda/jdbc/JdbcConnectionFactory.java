package com.sda.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcConnectionFactory {

    private JdbcConfig jdbcConfig;
    private MysqlDataSource mysqlDataSource;

    public JdbcConnectionFactory() throws SQLException {
        this.jdbcConfig = new JdbcConfig();
        this.mysqlDataSource = loadDataSource();
    }

    private MysqlDataSource loadDataSource() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setServerName(jdbcConfig.getProperty("jdbc.host"));
        mysqlDataSource.setPort(Integer.parseInt(jdbcConfig.getProperty("jdbc.port")));
        mysqlDataSource.setUser(jdbcConfig.getProperty("jdbc.user"));
        mysqlDataSource.setPassword(jdbcConfig.getProperty("jdbc.pass"));
        mysqlDataSource.setDatabaseName(jdbcConfig.getProperty("jdbc.dbName"));
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setCharacterEncoding("UTF-8");
        mysqlDataSource.setServerTimezone("UTC");

        return mysqlDataSource;
    }

    public Connection getConnection() throws SQLException {
        return mysqlDataSource.getConnection();
    }
}
