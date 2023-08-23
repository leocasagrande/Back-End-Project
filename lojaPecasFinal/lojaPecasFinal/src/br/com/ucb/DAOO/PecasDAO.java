package br.com.ucb.DAOO;

import br.com.ucb.Conexao.*;
import br.com.ucb.Bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PecasDAO {

	ConexaoBD conexao = new ConexaoBD();
	
	
	public static ArrayList<Pecas> ofertasPecas() {
		
		String sql = "SELECT id_peca, nome_peca, vl_venda FROM pecas WHERE id_peca <=5";
		
		ArrayList<Pecas> peca = new ArrayList<Pecas>();
		
		try {
			Connection connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Pecas pecas = new Pecas();
				pecas.setId(rs.getInt("id_peca"));
				pecas.setNome(rs.getString("nome_peca"));
				pecas.setValor(rs.getDouble("vl_venda"));
				peca.add(pecas);
			}
			rs.close();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return peca;
		
	}
	
public static ArrayList<Pecas> recomendacoesPecas() {
		
		String sql = "SELECT id_peca, nome_peca, vl_venda FROM pecas WHERE id_peca > 5";
		
		ArrayList<Pecas> peca = new ArrayList<Pecas>();
		
		try {
			Connection connection = ConexaoBD.conectar();
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Pecas pecas = new Pecas();
				pecas.setId(rs.getInt("id_peca"));
				pecas.setNome(rs.getString("nome_peca"));
				pecas.setValor(rs.getDouble("vl_venda"));
				peca.add(pecas);
			}
			rs.close();
			pst.close();
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return peca;
		
	}
	
	
}
