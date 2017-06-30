package promsys.gui;

import promsys.fachada.*;
import promsys.negocio.*;
import promsys.negocio.beans.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TUI {
//
	private Fachada fachada;
	
	public TUI() {
		this.fachada = Fachada.getInstance();
	}
	
	public final static void clearConsole()	{
	    for(int i = 0; i<100000; i++) {
	    	System.out.println();
	    }
	}
	
	private int login() {
		
		Scanner input = new Scanner(System.in);
		boolean fezLogin = false;		
		boolean falhou = false;
		int tipoLogin = -1;
			
		do{			
			System.out.println("Entre com seu login e senha: ");
			
			System.out.print("Login: ");
			String login = input.nextLine();
					
			System.out.print("Senha: ");
			String senha = input.nextLine();
		
			if (this.fachada.fazLoginServidor(login, senha) == true) {
				System.out.println("Bem-Vindo, Servidor!");
				fezLogin = true;
				tipoLogin = 1;
				input.nextLine();
			}
			else if (this.fachada.fazLoginProfessor(login, senha) == true) {
				System.out.println("Bem-Vindo, Professor!");
				fezLogin = true;
				tipoLogin = 2;
				input.nextLine();
			}
			
			else {
				System.out.print("Usuário ou senha incorretos.\nDigitar novamente?");
								
				if (simOuNao() == false){
					fezLogin = false;
					falhou = true;
				}
			}
		}while(fezLogin == false && falhou == false);
		
		return tipoLogin;
	}
	
	private void criaServidor() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nNome: ");
		String nome = input.nextLine();
		
		System.out.print("Crie seu Login: ");
		String login = input.nextLine();
		
		System.out.print("Crie sua senha: ");
		String senha = input.nextLine();
		
		this.fachada.cadastroServidor(nome, login, senha);
	}
	
	private boolean simOuNao() {
		Scanner input = new Scanner(System.in);
		System.out.print("1 - SIM	|	2 - NÃO");
		int resposta = 0;
		boolean ans = false;
		
		do{
			resposta = input.nextInt();
			input.nextLine();
		}while(resposta != 1  && resposta != 2);

		if (resposta == 1) {
			ans = true;
		}
		return ans;
	}
	
	private void professoresUI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		
		System.out.println("1. Criar novo professor;");
		System.out.println("2. Remover um professor;");
		System.out.println("3. Atualizar um professor;");
		System.out.println("4. Ver professores cadastrados;");
		System.out.println("5. Sair.");
		
		
		do{
			resposta = input.nextInt();
			input.nextLine();
		}while(resposta >= 1 && resposta <= 5);
		
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
				long id = input.nextInt();
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
				long id = input.nextInt();
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
				input.nextLine();
			}while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7);
			
			switch(opcao){
			case 1:{
				clearConsole();
				System.out.print("Entre com o nome da discplina: ");
				String nome = input.nextLine();
				
				System.out.print("Entre com a carga horária da disciplina: ");
				double carga = input.nextDouble();
				
				Disciplina d = new Disciplina(nome, carga);
				fachada.salvarDisciplina(d);
				break;
			}
			case 2:{
				clearConsole();
				System.out.print("Entre com o id da Disciplina:");
				long id = input.nextInt();
				input.nextLine();
				
				System.out.println();
				System.out.print(fachada.procurarDisciplina(id));
				if(fachada.procurarDisciplina(id) == null) {
					System.out.print("Disciplina não encontrada.");
				}
				input.nextLine();
				break;
			}
			case 3:{
				boolean a = false;
				do{
					
					System.out.print("Entre com o id da Disciplina:");
					long id = input.nextInt();
					input.nextLine();
					
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						System.out.print("Entre com o novo nome: ");
						String novoNome = input.nextLine();
						
						System.out.printf("Confirma Atualização do nome %s para %s? ", fachada.procurarDisciplina(id).getNome(), novoNome);
						if(simOuNao() == true) {
							fachada.atualizarDisciplina(id, novoNome);
							System.out.print("Nome atualizado.");
							input.nextLine();
						}
						else{
							System.out.print("Nome não atualizado.");
							input.nextLine();
						}
					}
					else{
						System.out.print("Id não encontrado. Digitar novamente? ");
						a = simOuNao();
					}
				}while(a != false);
				
				break;
			}
			case 4:{
				boolean a = false;
				do{
					clearConsole();
					System.out.print("Entre com o id da Disciplina:");
					long id = input.nextInt();
					input.nextLine();
					
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						System.out.print("Entre com a nova carga horaria: ");
						double novaCargaHoraria = input.nextDouble();
						input.nextLine();
						
						System.out.printf("Confirma atualização da carga horária %.0f para %.0f? ", fachada.procurarDisciplina(id).getCargaHoraria(), novaCargaHoraria);
						if(simOuNao() == true) {
							fachada.atualizarCargaHoraria(id, novaCargaHoraria);
							System.out.print("Carga horaria atualizada.");
							input.nextLine();
						}
						else{
							System.out.print("Carga horaria não atualizada.");
							input.nextLine();
						}
						
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
					System.out.print("Entre com o id da Disciplina: ");
					long id = input.nextInt();
					input.nextLine();
					
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						
						System.out.print("Remover disciplina?");
						a = simOuNao();
						if(a == true){
							fachada.deletarDisciplina(id);
							a = false;
							System.out.print("Disciplina deletada");
							input.nextLine();
						}
						else{
							System.out.print("Disciplina não deletada");
							input.nextLine();
						}
					}
					else{
						System.out.print("Id não encontrado. Digitar novamente?");
						a = simOuNao();
					}
				}while(a != false);
				break;
			}
			case 6:{
				clearConsole();
				if(fachada.listarDisciplinas() == "") {
					System.out.print("Ainda não existem disciplinas cadastradas.");
					input.nextLine();
				}
				else{
					System.out.print(fachada.listarDisciplinas());
					input.nextLine();	
				}
				break;
			}
			case 7:{
				clearConsole();
				System.out.print("Voltando...");
				input.nextLine();
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
	
		clearConsole();
		
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
				alocacaoUI();
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
	
	private void alocacaoUI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		do {
		do{
			System.out.println("1. Realizar nova Alocação;");
			System.out.println("2. Remover uma Alocação;");
			System.out.println("3. Atualizar alocado;");
			System.out.println("4. Ver alocado;");
			System.out.println("5. Sair.");
			resposta = input.nextInt();
		}while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4 && resposta!= 5);
		
		
		switch(resposta) {
			case 1:
				clearConsole();
				System.out.println("Escolha um entre os professores para ser alocado e entre com seu id: ");
				System.out.println(fachada.listaProfessores());
				
				long idProf = input.nextLong();
				Professor prof = fachada.procurarProf(idProf);		
				
				System.out.print("Escolha uma entre as disciplinas para ser alocada e entre com o seu id: ");
				System.out.println(fachada.listarDisciplinas());
				
				long idDis = input.nextLong();
				Disciplina dis = fachada.procurarDisciplina(idDis);			
				
				System.out.print("Perído: ");
				String periodo = input.nextLine();
				
				System.out.print("Entre com o horario de início: ");
				int horaIncio = input.nextInt();
				System.out.print("Entre com o horario de fim: ");
				int horaFim = input.nextInt();
				System.out.print("Entre com a quantidade de dias por semana(máx. 2): ");
				int qtdDias;
				do{
					 qtdDias = input.nextInt();
				}while(qtdDias > 2);
				
				ArrayList<String> dias = new ArrayList<String>();
				
				for(int i = 0; i < qtdDias; i++) {
					System.out.print("Entre com o dia da semana: ");
					dias.add(input.nextLine());
				}
				
				Horario hora = new Horario(horaIncio, horaFim, dias.get(0));
				hora.addDiaDaSemana(dias.get(1));
				
				Alocacao nova = new Alocacao(prof, dis, periodo, hora);
				
				boolean c = fachada.salvaAlocacao(nova);
				if(c == true) {
					System.out.println("Salvo com sucesso");
					input.nextLine();
				}else {
					System.out.println("Erro ao tentar salvar");
					input.nextLine();
				}
				break;
			
		case 2:
			clearConsole();
			Professor prof1 = new Professor("alfredo", "alfredo", "alfredo");
			Disciplina dis1 = new Disciplina("Programação", 40.5);
			String periodo1 = "2010.2";
			double carga1 = 40.4;
			Horario hora1 = new Horario(2, 4, "Quarta-feira");
			Alocacao novo1 = new Alocacao(prof1, dis1, periodo1, hora1);
			fachada.salvaAlocacao(novo1);
			long id = novo1.getId();
			System.out.print("Removendo Alocado de id: "+id);
			
			boolean b = fachada.removeAlocacao(id);
			
			if(b == true) {
				System.out.println("Removido com sucesso.");
			}else {
				System.out.println("Erro ao tentar remover");
			}
			
			break;
		case 3:
			clearConsole();
			int op = 0;
			do{
			do {
				System.out.println("1.Atualiza professor;");
				System.out.println("2.Atualiza Disciplina;");
				System.out.println("3.Atualiza Horário");
				System.out.println("4.Atualiza Período");
				System.out.println("5.Atualiza Carga Horária");
				System.out.println("6.Sair;");
				op = input.nextInt();
			}while(op!=1 && op!= 2 && op!=3&&op!=4 && op!= 5 && op!=6);
				switch(op) {
				case 1:
					clearConsole();
					long id5;
					boolean e5;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar Professor: ");
						id5 = input.nextLong();
						e5 = fachada.verificaExistenciaAlocacao(id5);
						if(!e5) {
							System.out.println("esse ID não existe.");
						}
					}while(!e5);
					System.out.println(fachada.lerAlocacoPorID(id5));
					
					System.out.print("\nDigite o nome do novo Professor: ");
					String novaProf = input.nextLine();
					Professor profnovato = new Professor(novaProf, novaProf, novaProf);
					
					fachada.updateProfessorAlocacao(id5, profnovato);
					
					System.out.println(fachada.lerAlocacoPorID(id5));
					break;
				case 2:
					clearConsole();
					long id3;
					boolean e3;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar disciplina: ");
						id3 = input.nextLong();
						e3 = fachada.verificaExistenciaAlocacao(id3);
						if(!e3) {
							System.out.println("esse ID não existe.");
						}
					}while(!e3);
					
					System.out.println(fachada.lerAlocacoPorID(id3));
					
					System.out.print("\nDigite a nova disciplina: ");
					String novaDis = input.nextLine();
					Disciplina disciplina = new Disciplina(novaDis, 40.5);
					
					fachada.updateDisciplinaAlocacao(id3, disciplina);
					
					System.out.println(fachada.lerAlocacoPorID(id3));
					
					break;
				case 3:
					clearConsole();
					long id4;
					boolean e4;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar Horario: ");
						id4 = input.nextLong();
						e4 = fachada.verificaExistenciaAlocacao(id4);
						if(!e4) {
							System.out.println("esse ID não existe.");
						}
					}while(!e4);
					
					System.out.println(fachada.lerAlocacoPorID(id4));
					
					System.out.print("\nDigite a nova Hora de inicio: ");
					int novaHora = input.nextInt();
					System.out.print("\nDigite a nova Hora de fim: ");
					int novaHoraf = input.nextInt();
					Horario hora4 = new Horario(novaHora, novaHoraf, "Quinta-feira");
					
					fachada.updateHorarioAlocacao(id4, hora4);
					
					System.out.println(fachada.lerAlocacoPorID(id4));
					break;
					
				case 4:
					clearConsole();
					long id6;
					boolean e6;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar o Periodo: ");
						id6 = input.nextLong();
						e6 = fachada.verificaExistenciaAlocacao(id6);
						if(!e6) {
							System.out.println("esse ID não existe.");
						}
					}while(!e6);
					
					System.out.println(fachada.lerAlocacoPorID(id6));
					
					System.out.print("\nDigite o novo Período: ");
					String novaPeriodo = input.nextLine();
					fachada.updatePeriodo(id6, novaPeriodo);
					
					System.out.println(fachada.lerAlocacoPorID(id6));
					break;
					
				case 5:
					clearConsole();
					long id7;
					boolean e7;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar a Carga Horária: ");
						id7 = input.nextLong();
						e7 = fachada.verificaExistenciaAlocacao(id7);
						if(!e7) {
							System.out.println("esse ID não existe.");
						}
					}while(!e7);
					
					System.out.println(fachada.lerAlocacoPorID(id7));
					
					System.out.print("\nDigite a nova Carga horária: ");
					double novaCarga = input.nextDouble();
					fachada.updateCargaHoraria(id7, novaCarga);
					
					System.out.println(fachada.lerAlocacoPorID(id7));
					break;
				}
				
				}while(op!=6);
				
		case 4:
			clearConsole();
			long id1;
			boolean e;
			do {
				System.out.print("\nDigite o ID do alocado que deseja visualizar: ");
				id1 = input.nextLong();
				e = fachada.verificaExistenciaAlocacao(id1);
				if(!e) {
					System.out.println("esse ID não existe.");
				}
			}while(!e);
			
			System.out.println(fachada.lerAlocacoPorID(id1));
			
			break;
		}
		}while(resposta!=5);
		input.close();
	}
	
	private void professorUserI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		
		System.out.print("*************************");
		System.out.print("*ALOCAÇÃO DE PROFESSORES*");
		System.out.print("*************************");
		
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
				clearConsole();
				break;
			}
		}
	}
	
	
		
	public void showUserInterface() {
		criaServidor();
		int tipoUsuario = login();
		
		if(tipoUsuario == 1) {
			servidorUI();
		}
		else if(tipoUsuario == 2) {
			professorUserI();
		}
	}
}
