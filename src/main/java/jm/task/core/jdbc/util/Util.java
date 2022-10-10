package jm.task.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static Connection conn;
    private static Util instance;
    private static final String URL = "jdbc:mysql://localhost:3307/users";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        try {
            return conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
   public  static Util getInstance() throws SQLException {
       if (instance == null) {
           synchronized (Util.class) {
               if (instance == null) {
                   instance = new Util();
               }
           }
       }
       return instance;
   }



}
