package br.com.ucb.Home;

import java.util.Scanner;
import java.util.ArrayList;

import br.com.ucb.Home.*;
import br.com.ucb.DAOO.AdminDAO;
import br.com.ucb.DAOO.CompradorDAO;
import br.com.ucb.DAOO.PecasDAO;
import br.com.ucb.Bean.*;

public class Home {

		public static void Inicial() {

		    // Exibição para o cliente
			System.out.println("===================================================");
		    System.out.println("===============MarketPlace-Bicicletas==============");
		    System.out.println("===================================================");
		    System.out.println("Selecione uma opção digitando seu número:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("1 - Ofertas:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("2 - Recomendações:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("3 - Login");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("0. Sair");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		    // Ler a entrada do usuário
		    Scanner scanner = new Scanner(System.in);
		    int opcao = scanner.nextInt();
		
		    // Processar a opção escolhida
		    switch (opcao) {
		    
		        case 1:
		            System.out.println("Opção selecionada: Ofertas");//escolha do produto 1 nas ofertas
		            System.out.println(" ");
		            ArrayList<Pecas> pecas = PecasDAO.ofertasPecas(); 
		            for(Pecas peca : pecas) { 
		            	System.out.println(peca.getNome() + " - " + peca.getValor() + " R$");
		            }
		            System.out.println(" ");
		            Home.Inicial();
		            break;
		        case 2:
		            System.out.println("Opção selecionada: Recomendações");
		            System.out.println(" ");
		            ArrayList<Pecas> pecass = PecasDAO.recomendacoesPecas(); 
		            for(Pecas peca : pecass) {
		            	System.out.println(peca.getNome() + " - " + peca.getValor() + " R$");
		            }
		            System.out.println(" ");
		            Home.Inicial();
		            break;
		        case 3:
		            Login.main(null);
		            break;
		        case 0:
		            System.out.println("Opção selecionada: Sair");//sair do programa              
		            
		            break;
		        default:
		            System.out.println("Opção inválida");
		            break;
		    }
		
		    scanner.close();
		}
		
		public static void inicialComprador(Comprador comprador) {

		    // Exibição para o cliente
			System.out.println("===================================================");
		    System.out.println("===============MarketPlace-Bicicletas==============");
		    System.out.println("===================================================");
		    System.out.println("Selecione uma opção digitando seu número:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("1 - Ofertas:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("2 - Recomendações:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("3 - Voltar para tela de Login");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("0. Sair");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		    // Ler a entrada do usuário
		    Scanner scanner = new Scanner(System.in);
		    int opcao = scanner.nextInt();
		    int id;
		
		    // Processar a opção escolhida
		    switch (opcao) {
		    
		        case 1:
		            System.out.println("Opção selecionada: Ofertas");//escolha do produto 1 nas ofertas
		            System.out.println(" ");
		            ArrayList<Pecas> pecas = PecasDAO.ofertasPecas(); 
		            for(Pecas peca : pecas) {
		            	System.out.println(peca.getId() + " " + peca.getNome() + " - " + peca.getValor());
		            }
		            System.out.println(" ");
		            System.out.println("Informe o id do produto que deseja comprar: ");
		            id = scanner.nextInt();
		            CompradorDAO.comprar(id, comprador);
		            Home.inicialComprador(comprador);
		            break;
		        case 2:
		            System.out.println("Opção selecionada: Recomendações");
		            System.out.println(" ");
		            ArrayList<Pecas> pecass = PecasDAO.recomendacoesPecas(); 
		            for(Pecas peca : pecass) {
		            	System.out.println(peca.getId() + " " + peca.getNome() + " - " + peca.getValor());
		            }
		            System.out.println(" ");
		            System.out.println("Informe o id do produto que deseja comprar: ");
		            id = scanner.nextInt();
		            CompradorDAO.comprar(id, comprador);
		            Home.inicialComprador(comprador);
		            break;
		        case 3:
		        	Login.main(null);
		            break;
		        case 0:
		            System.out.println("Opção selecionada: Sair");//sair do programa              
		            
		            break;
		        default:
		            System.out.println("Opção inválida");
		            break;
		    }
		
		    scanner.close();
		}
		
		public static void inicialAdmin(Admin admin) {

		    // Exibição para o cliente
			System.out.println("===================================================");
		    System.out.println("===============MarketPlace-Bicicletas==============");
		    System.out.println("===================================================");
		    System.out.println("Selecione uma opção digitando seu número:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("1 - Adicionar produtos:");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("2 - Voltar ao menu de Login.");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		    System.out.println("0. Sair");
		    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		    // Ler a entrada do usuário
		    Scanner scanner = new Scanner(System.in);
		    int opcao = scanner.nextInt();
		    int qtd;
		    String nome;
		    double vl_ref;
		    double vl_venda;
		
		    // Processar a opção escolhida
		    switch (opcao) {
		    
		        case 1:
		            System.out.println("Informe a quantidade de produtos para inserir: ");
		            qtd = scanner.nextInt();
		            System.out.println("Informe o nome da peça: ");
		            scanner.nextLine();
		            nome = scanner.nextLine();
		            System.out.println("Informe o valor de referencia: ");
		            vl_ref = scanner.nextDouble();
		            System.out.println("Informe o valor de compra: ");
		            vl_venda = scanner.nextDouble();
		        	AdminDAO.inserirPeca(qtd, nome, vl_ref, vl_venda, admin);
		        	System.out.println("Produto adicionado com sucesso.");
		        	System.out.println("-------------------------------");
		        	Home.inicialAdmin(admin);
		            break;
		        case 2:
		            Login.main(null);;
		            break;
		        case 0:
		            System.out.println("Opção selecionada: Sair");//sair do programa                          
		            break;
		        default:
		            System.out.println("Opção inválida");
		            break;
		    }
		
		    scanner.close();
		}
		

	}	
