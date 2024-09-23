package com.atmitvision.restapicruddemo.datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

public class CustomDataSource implements DataSource {

    private String jdbcUrl;
    private String username;
    private String password;
    private LinkedList<Connection> connectionPool = new LinkedList<>();

    public CustomDataSource(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;

        // Pre-populating the connection pool
        for (int i = 0; i < 10; i++) {
            try {
                connectionPool.add(createNewConnection());
            } catch (SQLException e) {
                throw new RuntimeException("Error creating a new connection", e);
            }
        }
    }

    private Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,username,password);
    }


    @Override
    public Connection getConnection() throws SQLException {
        if(connectionPool.isEmpty()){
            return createNewConnection();
        }else {
            return connectionPool.removeFirst();
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return DriverManager.getConnection(jdbcUrl,username,password);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        DriverManager.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return DriverManager.getLoginTimeout();
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public ShardingKeyBuilder createShardingKeyBuilder() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}

