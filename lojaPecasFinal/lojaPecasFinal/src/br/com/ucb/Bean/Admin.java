package br.com.ucb.Bean;

public class Admin {
	
	private String cpf;
	private int senha;
	
	public Admin(String cpf, int senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	
	
}
