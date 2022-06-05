package driverprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDriverProvider {

    private static JDBCDriverProvider jdbcDriver;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/searchingResults";
    private Connection connection;


    private JDBCDriverProvider() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JDBCDriverProvider getJdbcDriver() {
        if (jdbcDriver == null) {
            jdbcDriver = new JDBCDriverProvider();
        }
        return jdbcDriver;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
