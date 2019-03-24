/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author bactv
 */
import Exception.MyException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    public static Connection createConnection() throws MyException {
        Connection conn = null;
        String serverName = "localhost";
        String dbName = "Survey";
        String portNumber = "1433";
        String userID = "sa";
        String password = "abc123";
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //create connection
            conn = DriverManager.getConnection(url, userID, password);

        } catch (ClassNotFoundException ex) {
            throw new MyException(1001, ex);
        } catch (SQLException ex) {
            throw new MyException(1002, ex);
        }

        return conn;
    }

}
