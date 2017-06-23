package promsys.gui;

import promsys.fachada.*;
import promsys.negocio.*;
import promsys.negocio.beans.*;

import java.util.Scanner;
import java.util.Scanner.*;

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
		
		System.out.print("Nome: ");
		String nome = input.nextLine();
		
		System.out.print("Crie seu Login: ");
		String login = input.nextLine();
		
		System.out.print("Crie sua senha: ");
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
	
	private void ProfessoresUI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		
		do{
			System.out.println("1. Criar novo professor;");
			System.out.println("2. Remover um professor;");
			System.out.println("3. Atualizar um professor;");
			System.out.println("4. Ver professores cadastrados.");
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
				clearConsole();
				System.out.println("Entre com o ID do professor:");
				
			}
		}
	}
	
	private void UI() {
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
			
		}
		
	}
		
	public void showUserInterface() {
	}
}
