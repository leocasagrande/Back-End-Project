package br.com.ucb.Home;

import br.com.ucb.DAOO.*;
import java.util.Scanner;
import br.com.ucb.Bean.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login {
	

    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        String nome;
        String dt_nasc;
        String cpf;
        Date date;
        int senha;
        int opcaoEntrada = 0;
        Comprador comprador = null;
        Admin admin = null;
        
        System.out.println("BEM VINDO AO PEDAL DE OURO");
        System.out.println("Selecione uma opção de entrada:");
        System.out.println("[ 1 ] - Continuar como visitante");
        System.out.println("[ 2 ] - Fazer login");
        System.out.println("[ 3 ] - Cadastrar-se");
        System.out.println("[ 4 ] - Admin");
        opcaoEntrada = sc.nextInt();
        switch (opcaoEntrada) {
            case 1:                
                Home.Inicial();
                break;
                
            case 2:
                
                boolean loginValidado = false;
                
                do {
                    System.out.print("CPF: ");
                    sc.nextLine();
                    cpf = sc.nextLine();
                    System.out.print("Senha: ");
                    senha = sc.nextInt();
                    loginValidado = CompradorDAO.compradorExiste(cpf, senha);
                    if (loginValidado) {
                        comprador = new Comprador(cpf, senha);  
                    }
                    Clear.clearConsole();
                } while(loginValidado != true);
                System.out.println("Bem-Vindo, " + comprador.getCpf());
                Home.inicialComprador(comprador);
                break;
                
            case 3:
            	System.out.println("----------------------Informe----------------------");
            	System.out.println("Seu nome: ");
            	sc.nextLine();
            	nome = sc.nextLine();
                System.out.print("CPF: ");
                cpf = sc.nextLine();
                System.out.print("Senha: ");
                senha = sc.nextInt();
                System.out.println("");
                CompradorDAO.inserirComprador(nome, senha, cpf);
                CompradorDAO.inserirLoginComprador(cpf, senha);
                Clear.clearConsole();
                Login.main(args);
                break;
                
            case 4:
                System.out.print("CPF: ");
                sc.nextLine();
                cpf = sc.nextLine();
                System.out.print("Senha: ");
                senha = sc.nextInt();
                loginValidado = AdminDAO.adminExiste(cpf, senha);
                if (loginValidado) {
                    admin = new Admin(cpf, senha);
                }
                Home.inicialAdmin(admin);
                break;
        }

        
        
        
        
//
//        do {
//
//
//
//
//        } while (saida != 99)

    }
}