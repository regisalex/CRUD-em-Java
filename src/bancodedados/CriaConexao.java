/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DEBYREGIS
 */
public class CriaConexao {
    
    public Connection getConnection() {
        
        try {
            /*Até a versão 3 do JDBC, antes de chamar o DriverManager.getConnection() 
            era necessário registrar o driver JDBC que iria ser utilizado através do 
            método Class.forName("com.mysql.jdbc.Driver"), 
            no caso do MySQL, que carregava essa classe, 
            e essa se comunicava com o DriverManager.
            A partir do JDBC 4, que está presente no Java 6, esse passo não é mais necessário.*/
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Conectando ao banco");
            return DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
        
        } catch (SQLException | ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
        
    }
}
