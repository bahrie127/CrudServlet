/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bahri.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bahrie
 */
public class ConnectionUtils {
    
    private static Connection conn;
    
    public static Connection getConnection(){
        try {
            Class.forName(JdbcProperties.driver);
            conn=DriverManager.getConnection(JdbcProperties.url, JdbcProperties.username, JdbcProperties.password);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    }
    
}
