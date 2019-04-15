package connection.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBC {
public Connection getConnection() throws SQLException {
    System.out.println("-------- Oracle JDBC Connection Testing ------");

    try {

        Class.forName("oracle.jdbc.driver.OracleDriver");

    } catch (ClassNotFoundException e) {

        System.out.println("Where is your Oracle JDBC Driver?");
        e.printStackTrace();
    }

    System.out.println("Oracle JDBC Driver Registered!");

    Connection connection = null;

    try {

        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@172.16.0.175:1521:dbad", "dbad_src", "src.getConnection()");

    } catch (SQLException e) {

        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();

    }

    if (connection != null) {
        System.out.println("You made it, take control your database now!");
    } else {
        System.out.println("Failed to make connection!");
    }

    return connection;
}
}
