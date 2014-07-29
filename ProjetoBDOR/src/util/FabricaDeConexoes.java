package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {  
	private static Connection connection = null;  

	private static String url       = "jdbc:oracle:thin:@localhost";     
	private static String username  = "administrador";  
	private static String password  = "123456";  

	private FabricaDeConexoes(){    

	}  

	public static Connection getConnection() throws ClassNotFoundException{  

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException exception) { 
			exception.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException exception) {
			exception.printStackTrace();
		}

		return connection;
	}

	public void closeConnection(){  
		if(connection != null){  
			try {     
				connection.close();   
			}   
			catch (SQLException e) {  
				System.out.println("\n>> Problema ao fechar conexao\n");  
				e.printStackTrace();  
			}  
		}  
	}  

	public void finalize(){  
		closeConnection();  
	}  
}  