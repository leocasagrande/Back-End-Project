package br.com.ucb.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

	public static Connection conectar(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}	catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/bco_loja", "root", "khrys");
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
