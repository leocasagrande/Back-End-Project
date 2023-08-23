package br.com.ucb.Bean;

public class Pecas {
	
	private int id;
	private String nome;
	private Double valor;


		public Pecas() {
			
		}

			
		public Pecas(int id, String nome, Double valor) {
			super();
			this.id = id;
			this.nome = nome;
			this.valor = valor;
		}


		public String getNome() {
				return nome;
	}
		
			
		public void setNome(String nome) {
				this.nome = nome;
	}

		
		public Double getValor() {
			return valor;
	}

		public void setValor(Double valor) {
			this.valor = valor;
	}
			
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

}

