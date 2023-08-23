package br.com.ucb.DAOO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.ucb.Bean.Admin;
import br.com.ucb.Bean.Comprador;
import br.com.ucb.Bean.Pecas;
import br.com.ucb.Conexao.*;

public class CompradorDAO {

	ConexaoBD conexao = new ConexaoBD();
	
	public static boolean compradorExiste(String cpf, int senha) {
		
		int qnt = 0;
		
		String sql = "SELECT COUNT(*) FROM login_comprador WHERE CPF_CNPJ = ? AND senha_funci = ?";
		try {
			Connection connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, cpf);
			pst.setInt(2, senha);
			ResultSet rs = pst.executeQuery();
			rs.next();
			qnt = rs.getInt(1);
			rs.close();
			pst.close();
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
	
	public static void inserirComprador(String nome, int senha, String cpf) {
			
			String sql = "INSERT INTO comprador VALUES (?,?,?)";
			Connection connection = null;
			
			try {
				connection = ConexaoBD.conectar();
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1, nome);
				pst.setInt(2, senha);
				pst.setString(3, cpf);
				pst.execute();
				pst.close();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
			
		}
	
	
	public static void inserirLoginComprador(String cpf, int senha) {
		
		String sql = "INSERT INTO login_comprador VALUES (?,?)";
		Connection connection = null;
		
		try {
			connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, cpf);
			pst.setInt(2, senha);
			pst.execute();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		
	}
	
	
	public static void comprar(int id, Comprador comprador) {
			
			Pecas pecaa = pecaPeloId(id);
			String sql = "INSERT INTO compra (id_venda, id_peca, preco_venda, qtd_venda, CPF_CNPJ) VALUES (?, ?, ?, ?, ?)";
			
			try {
				Connection connection = ConexaoBD.conectar();
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setInt(1, 0);
				pst.setInt(2, pecaa.getId());
				pst.setDouble(3, pecaa.getValor());
				pst.setInt(4, 1);
				pst.setString(5, comprador.getCpf());
				pst.execute();
			}catch (SQLException e) {
				e.printStackTrace();	
			}
			
		}
	
	public static Pecas pecaPeloId(int id) {
		String sql = "SELECT id_peca, nome_peca, vl_venda FROM pecas WHERE id_peca = ?";
		Pecas peca = new Pecas();
		try {
			Connection connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			peca.setId(rs.getInt("id_peca"));
			peca.setNome(rs.getString("nome_peca"));
			peca.setValor(rs.getDouble("vl_venda"));
			rs.close();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		return peca;
	}
	
		
	}
