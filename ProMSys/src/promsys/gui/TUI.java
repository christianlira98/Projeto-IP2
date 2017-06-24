package promsys.gui;

import promsys.fachada.*;
import promsys.negocio.*;
import promsys.negocio.beans.*;
import java.util.Scanner;

public class TUI {

	private Fachada fachada;
	
	public TUI() {
		this.fachada = Fachada.getInstance();
	}
	
	public final static void clearConsole()	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	
	private boolean login() {
		
		Scanner input = new Scanner(System.in);
		boolean logged = false;		
		String resposta = "";
		
		do{

			System.out.println("Entre com seu login e senha: ");
			
			System.out.print("Login: ");
			String login = input.nextLine();
			
			System.out.print("Senha: ");
			String senha = input.nextLine();
			
			if (this.fachada.fazLoginProfessor(login, senha) == true) {
				System.out.println("Bem-Vindo, Servidor!");
				logged = true;
				// espera enter e limpa tela
			}
			else if (this.fachada.fazLoginProfessor(login, senha) == true) {
				System.out.println("Bem-Vindo, Professor!");
				logged = true;
				// espera enter e limpa tela
			}
			
			else {
				System.out.println("Usuário ou senha incorretos.\nDigitar novamente? s - SIM	|	n - NÃO");
				do{
					resposta = input.nextLine();
				}while(resposta != "n" && resposta != "s");
				
				if (resposta == "n"){
					logged = true;
				}
			}
		}while(logged == false);
		
		input.close();
		return logged;
	}
	
	private void criaServidor() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nNome: ");
		String nome = input.nextLine();
		
		System.out.print("\nCrie seu Login: ");
		String login = input.nextLine();
		
		System.out.print("\nCrie sua senha: ");
		String senha = input.nextLine();
		
		this.fachada.cadastroServidor(nome, login, senha);
		input.close();
	}
	
	private boolean simOuNao() {
		clearConsole();
		Scanner input = new Scanner(System.in);
		System.out.println("s - SIM	|	n - NÃO");
		String resposta = null;
		boolean ans = false;
		
		do{
			resposta = input.nextLine();
		}while(resposta != "s" && resposta != "n");
		
		if (resposta == "s") {
			ans = true;
		}
		input.close();
		return ans;
	}
	
	private void professoresUI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		
		do{
			System.out.println("1. Criar novo professor;");
			System.out.println("2. Remover um professor;");
			System.out.println("3. Atualizar um professor;");
			System.out.println("4. Ver professores cadastrados;");
			System.out.println("5. Sair.");
		}while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4);
		
		switch(resposta){
			case 1:{
				clearConsole();
				System.out.print("Nome do professor: ");
				String nome = input.nextLine();
				Professor p = new Professor(nome, nome, nome);
				fachada.cadastraProf(p);
				clearConsole();
				break;
			}
			case 2:{
				clearConsole();
				System.out.print("Entre com o ID do professor:");
				int id = input.nextInt();
				Professor p = fachada.procurarProf(id);
				clearConsole();
				System.out.println("Remover: ");
				System.out.println(p);
				System.out.println();
				boolean ans = simOuNao();
				
				if (ans == true) {
					fachada.removeProf(p.getId());
					System.out.println("Professor Removido.");
					input.nextLine();
					clearConsole();
				}
				else{
					System.out.println("Professor não removido");
					input.nextLine();
					clearConsole();
				}
				break;				
			}
			case 3:{
				boolean a = true;
				do{
				clearConsole();
				System.out.println("Entre com o ID do professor:");
				int id = input.nextInt();
				int ans = 0;
				Professor p = fachada.procurarProf(id);
				if (p != null && p instanceof Professor) {
					clearConsole();
					do{
						
						do{
							System.out.println("1. Atualizar nome;");
							System.out.println("2. Adcionar Disciplinas aptas;");
							System.out.println("3. Sair.");						
							System.out.println();
							ans = input.nextInt();
						}while(ans != 1 && ans != 2 && ans != 3);
						
						switch(ans){
							case 1:{
								clearConsole();
								System.out.print("Entre com o novo nome: ");
								String novoNome = input.nextLine();
								clearConsole();
								System.out.printf("Confirma troca de %s para %s?", p.getNome(), novoNome);
								boolean b = simOuNao();
								if(b == true) {
									fachada.updateNomeProfessor(novoNome, p.getId());
									System.out.println("Nome atualizado.");
									input.nextLine();
									clearConsole();
								}
								else{
									System.out.println("Nome não atualizado.");
									input.nextLine();
									clearConsole();
								}
								break;
							}
							case 2:{
								clearConsole();
								System.out.println("Escolha uma entre as disciplinas, para ser adcionada:");
								System.out.println(fachada.listarDisciplinas());
								String disciplina = input.nextLine();
								if(fachada.procurarNomeDisciplina(disciplina) != null) {
									fachada.addPossivelDisciplina(p.getId(), fachada.procurarNomeDisciplina(disciplina));
									System.out.println("Disciplina adcionada.");
									input.nextLine();
									clearConsole();
								}
								else{
									System.out.println("Disciplina digitada não existe.");
									clearConsole();
								}
							}
							case 3:{
								System.out.println("Voltando para a tela inicial...");
								input.nextLine();
								break;
							}
						}
					}while(ans != 3);
				}
				
				else{
					clearConsole();
					System.out.println("Professor não encontrado. Entrar com ID novamente?");
					a = simOuNao();
				}
				}while(a != false);
				break;
			}
			
			case 4:{
				clearConsole();
				fachada.listaProfessores();
				input.nextLine();
				break;
			}
			
			case 5:{
				clearConsole();
				System.out.println("Voltando...");
				input.nextLine();
				break;
			}
		}
		input.close();
	}
	
	private void disciplinasUI() {
		
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		do{
			do{
				clearConsole();
				System.out.println("1. Adcionar nova disciplina;");
				System.out.println("2. Procurar uma disciplina;");
				System.out.println("3. Atualizar nome de uma disciplina;");
				System.out.println("4. Atualizar carga horaria de uma disciplina");
				System.out.println("5. Remover uma disciplina;");
				System.out.println("6. Ver todas as disciplinas cadastradas;");
				System.out.println("7. Sair.");
				opcao = input.nextInt();
			}while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6);
			
			switch(opcao){
			case 1:{
				System.out.print("Entre com o nome da discplina: ");
				String nome = input.nextLine();
				
				System.out.print("Entre com a carga horária da disciplina");
				double carga = input.nextDouble();
				
				Disciplina d = new Disciplina(nome, carga);
				fachada.salvarDisciplina(d);
				break;
			}
			case 2:{
				clearConsole();
				System.out.println("Entre com o id da Disciplina:");
				int id = input.nextInt();
				System.out.println(fachada.procurarDisciplina(id));
				input.nextLine();
				break;
			}
			case 3:{
				boolean a = false;
				do{
					clearConsole();
					System.out.println("Entre com o id da Disciplina:");
					int id = input.nextInt();
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						System.out.println("Entre com o novo nome");
						String novoNome = input.nextLine();
						fachada.atualizarDisciplina(id, novoNome);
					}
					else{
						System.out.println("Id não encontrado. Digitar novamente?");
						a = simOuNao();
					}
				}while(a != false);
				break;
			}
			case 4:{
				boolean a = false;
				do{
					clearConsole();
					System.out.println("Entre com o id da Disciplina:");
					int id = input.nextInt();
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						System.out.println("Entre com a nova carga horaria");
						double novaCargaHoraria = input.nextDouble();
						fachada.atualizarCargaHoraria(id, novaCargaHoraria);
					}
					else{
						System.out.println("Id não encontrado. Digitar novamente?");
						a = simOuNao();
					}
				}while(a != false);
				break;
			}
			case 5:{
				boolean a = false;
				do{
					clearConsole();
					System.out.println("Entre com o id da Disciplina:");
					int id = input.nextInt();
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						Disciplina d = fachada.procurarDisciplina(id);
						System.out.println("Remover disciplina?");
						a = simOuNao();
						if(a == true){
							fachada.deletarDisciplina(d.getId());
							a = false;
						}
						else{
							System.out.println("Disciplina não deletada");
						}
					}
					else{
						System.out.println("Id não encontrado. Digitar novamente?");
						a = simOuNao();
					}
				}while(a != false);
				break;
			}
			case 6:{
				clearConsole();
				fachada.listarDisciplinas();
				input.nextLine();
				break;
			}
			case 7:{
				clearConsole();
				System.out.println("Voltando...");
				break;
			}
			}
		}while(opcao != 7);
		clearConsole();
	}
	
	private void servidorUI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		
		System.out.print("*************************");
		System.out.print("*ALOCAÇÃO DE PROFESSORES*");
		System.out.print("*************************");
	
		criaServidor();
		login();
		
		do{		
			System.out.println(" Escolha sua operação:");
			System.out.println("1. Alocação;");
			System.out.println("2. Professores;");
			System.out.println("3. Disciplinas");
			System.out.println("4. Sair");
			System.out.println();
			resposta = input.nextInt();
		}while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4);
		
		switch(resposta){
			case 1:{
				//
				break;
			}
			case 2:{
				professoresUI();
				break;
			}
			case 3:{
				disciplinasUI();
				break;
			}
			case 4:{
				clearConsole();
				System.out.println("Saindo...");
				break;
			}
		}
	}
	
	private void professorUserI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		
		System.out.print("*************************");
		System.out.print("*ALOCAÇÃO DE PROFESSORES*");
		System.out.print("*************************");
		
		login();
		
		do{		
			System.out.println(" Escolha sua operação:");
			System.out.println("1. Ver alocações;");
			System.out.println("2. Ver professores cadastrados;");
			System.out.println("3. Ver disciplinas");
			System.out.println("4. Sair");
			System.out.println();
			resposta = input.nextInt();
		}while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4);
		
		switch(resposta){
			case 1:{
				clearConsole();
				//System.out.println(fachada.listaAlocacoes);
			}
			case 2:{
				clearConsole();
				System.out.println(fachada.listaProfessores());
				break;
			}
			case 3:{
				clearConsole();
				System.out.println(fachada.listarDisciplinas());
				break;
			}
			case 4:{
				clearConsole();
				System.out.println("Saindo...");
				break;
			}
		}
		
	}
		
	public void showUserInterface() {
		servidorUI();
	}
}
