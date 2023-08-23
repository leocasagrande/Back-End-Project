package br.com.ucb.DAOO;

import br.com.ucb.Bean.Admin;
import br.com.ucb.Conexao.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminDAO {

	ConexaoBD conexao = new ConexaoBD();
	
	public static boolean adminExiste(String cpf, int senha) {
			
			int qnt = 0;
			
			String sql = "SELECT COUNT(*) FROM login_adm WHERE CPF = ? AND senha_funci = ?";
			
			try {
				Connection connection = ConexaoBD.conectar();
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1, cpf);
				pst.setInt(2, senha);
				ResultSet rs = pst.executeQuery();
				rs.next();
				qnt = rs.getInt(1);
			}catch (SQLException e) {
				e.printStackTrace();	
			}
			
			if(qnt == 0) {
				return false;
			}
			else {
				return true;
			}
			
		}
	
	public static void inserirPeca(int qtd, String nome, double vl_ref, double vl_venda, Admin admin) {
		
		
		String sql = "INSERT INTO pecas (id_peca, qtd_peca, nome_peca, vl_ref, vl_venda, CPF_CNPJ) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, qtd);
			pst.setString(3, nome);
			pst.setDouble(4, vl_ref);
			pst.setDouble(5,  vl_venda);
			pst.setString(6, "12.754.862/0001-01");
			pst.execute();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		
	}
	
public static boolean excluirPeca(int qtd, String nome, double vl_ref, double vl_venda, Admin admin) {
		
		int qnt = 0;
		
		String sql = "DELETE FROM pecas (id_peca, qtd_peca, nome_peca, vl_ref, vl_venda, CPF_CNPJ) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			Connection connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, 0);
			pst.setInt(2, qtd);
			pst.setString(3, nome);
			pst.setDouble(4, vl_ref);
			pst.setDouble(5,  vl_venda);
			pst.setString(6, admin.getCpf());
			ResultSet rs = pst.executeQuery();
			rs.next();
			qnt = rs.getInt(1);
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		
		if(qnt == 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
}
