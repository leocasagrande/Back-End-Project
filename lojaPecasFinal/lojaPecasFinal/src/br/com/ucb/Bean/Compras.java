package br.com.ucb.Bean;

public class Compras {

	private int id_venda;
	private int id_peca;
	private float preco_venda;
	private int qtd_venda;
	private String cpf;
	
	
		public Compras(int id_venda, int id_peca, float preco_venda, int qtd_venda, String cpf) {
			super();
			this.id_venda = id_venda;
			this.id_peca = id_peca;
			this.preco_venda = preco_venda;
			this.qtd_venda = qtd_venda;
			this.cpf = cpf;
		}
	
	
		public int getId_venda() {
			return id_venda;
		}
	
	
		public void setId_venda(int id_venda) {
			this.id_venda = id_venda;
		}
	
	
		public int getId_peca() {
			return id_peca;
		}
	
	
		public void setId_peca(int id_peca) {
			this.id_peca = id_peca;
		}
	
	
		public float getPreco_venda() {
			return preco_venda;
		}
	
	
		public void setPreco_venda(float preco_venda) {
			this.preco_venda = preco_venda;
		}
	
	
		public int getQtd_venda() {
			return qtd_venda;
		}
	
	
		public void setQtd_venda(int qtd_venda) {
			this.qtd_venda = qtd_venda;
		}
	
	
		public String getCpf() {
			return cpf;
		}
	
	
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		
	
	
}
