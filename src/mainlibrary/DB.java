/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author bikash
 */
public class DB {


    public static Connection getConnection() {
        Connection con = null;
        try {
            Config cfg = new Config();
            Properties props = new Properties();
            String connection = cfg.getProperty("ConnStr"); //"jdbc:mysql://172.17.0.1:3306/library";
            props.put("user", cfg.getProperty("UserName"));
            props.put("password", cfg.getProperty("Password"););
            props.put("useUnicode", cfg.getProperty("useUnicode"););
            props.put("useSSL", cfg.getProperty("useSSL"););
            props.put("useServerPrepStmts", "false"); // use client-side prepared statement
            props.put("characterEncoding", "UTF-8"); // ensure charset is utf8 here

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connection, props);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
