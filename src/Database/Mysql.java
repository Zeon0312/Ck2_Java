/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author MSI GF63 11UC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class Mysql {
    public static Connection connection;
    
    public static Connection getConnection(){
        if(connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                try {
                    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login" ,"root" ,"Nhat@2005");
                } catch (Exception ex) {
                    Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
}