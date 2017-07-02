package promsys.gui;

import promsys.fachada.*;
import promsys.negocio.beans.*;

import java.util.ArrayList;
import java.util.Scanner;

public class TUI {
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
			clearConsole();
			System.out.print("\nEntre com seu login e senha: ");
			
			System.out.print("\nLogin: ");
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
	
	private int ehNumero(String entrada) {
		int ehNumero = -1;
		int count = 0;
		int countNumero = 0;
		int countPonto = 0;
		for(int i = 0; i < entrada.length(); i++) {
			if(Character.isDigit(entrada.charAt(i)) == true) {
				countNumero++;
			}
			else if(entrada.equals(".") ) {
				countPonto++;
			}
			else{
				count++;
			}
		}
		if(countNumero > 0 && count == 0) {
			ehNumero = 1;
		}
		else if(countNumero > 2 && countPonto == 1) {
			ehNumero = 2;
		}
		else if(count > 0) {
			ehNumero = 0;
		}
		return ehNumero;
	}
	
	private int ehInt(String res) {
		int r = 0;
		if(ehNumero(res) == 1) {
			r = Integer.parseInt(res);
		}
		return r;
	}
	
	private double ehDouble(String res) {
		double d = 0;
		if(ehNumero(res) == 2) {
			d = Double.parseDouble(res);
		}
		return d;
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
		System.out.print("\n1 - SIM  |  2 - NÃO  ");
		int resposta = 0;
		boolean ans = false;
		do{
			resposta = ehInt(input.nextLine());
		}while(resposta != 1  && resposta != 2);

		if (resposta == 1) {
			ans = true;
		}
		return ans;
	}
	
	private void professoresUI() {
		Scanner input = new Scanner(System.in);
		String res = null;
		int resposta = 0;	
		
		do{
			do{
				clearConsole();
				System.out.println("1. Criar novo professor;");
				System.out.println("2. Remover um professor;");
				System.out.println("3. Atualizar um professor;");
				System.out.println("4. Ver professores cadastrados;");
				System.out.print("5. Sair.");
				resposta = ehInt(input.nextLine());
				input.nextLine();
			}while(resposta < 1 && resposta > 5);
			
			switch(resposta){
				case 1:{
					clearConsole();
					System.out.print("Nome do professor: ");
					String nome = input.nextLine();
					System.out.print("Login do professor: ");
					String login = input.nextLine();
					System.out.print("Senha do professor: ");
					String senha = input.nextLine();
					Professor p = new Professor(nome, login, senha);
					fachada.cadastraProf(p);
					break;
				}
				case 2:{
					clearConsole();
					System.out.print("Entre com o ID do professor:");
					long id = ehInt(input.nextLine());
					Professor p = fachada.procurarProf(id);
					clearConsole();
					System.out.println("Confirma remoção de: ");
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
					long id = ehInt(input.nextLine());
					int ans = 0;
					Professor p = fachada.procurarProf(id);
					if (p != null && p instanceof Professor) {
						do{
							
							do{
								clearConsole();
								System.out.println(p+"\n");
								System.out.println("1. Atualizar nome;");
								System.out.println("2. adicionar Disciplinas aptas;");
								System.out.println("3. Sair.");						
								ans = ehInt(input.nextLine());
								input.nextLine();
							}while(ans != 1 && ans != 2 && ans != 3);
							
							switch(ans){
								case 1:{
									clearConsole();
									System.out.print("Entre com o novo nome: ");
									String novoNome = input.nextLine();
									clearConsole();
									System.out.printf("Confirma Atualização de nome %s para %s?", p.getNome(), novoNome);
									boolean b = simOuNao();
									if(b == true) {
										fachada.updateNomeProfessor(novoNome, p.getId());
										System.out.println("Nome atualizado.");
										input.nextLine();
									}
									else{
										System.out.print("Nome não atualizado.");
										input.nextLine();
									}
									break;
								}
								case 2:{
									clearConsole();
									System.out.println("Escolha uma entre as disciplinas, para ser adcionada:");
									System.out.print(fachada.listarDisciplinas());
									long idDis = input.nextLong();
									input.nextLine();
									
									if(fachada.procurarDisciplina(idDis) != null) {
										ArrayList<Disciplina> d = p.getDisciplinasPossiveis();
										boolean existe = false;
										for(int i = 0; i < d.size(); i++) {
											if(fachada.procurarDisciplina(idDis).equals(d.get(i)) ) {
												existe = true;
											}
										}
										if(existe == false) {
											fachada.addPossivelDisciplina(p.getId(), fachada.procurarDisciplina(idDis));
											System.out.print("Disciplina adcionada.");
											input.nextLine();
											clearConsole();
										}
										else if(existe == true) {
											System.out.print("Disciplina já contida na lista de disciplinas aptas.");
											input.nextLine();
											clearConsole();
										}
									}
									else{
										System.out.println("Disciplina digitada não existe.");
										input.nextLine();
									}
									break;
								}
								case 3:{
									System.out.println("Voltando para a tela inicial...");
									input.nextLine();
									break;
								}
							}
						}while(ans != 3);
						break;
					}
					
					else{
						clearConsole();
						System.out.print("Professor não encontrado. Entrar com ID novamente?");
						a = simOuNao();
					}
					}while(a != false);
					break;
				}
				
				case 4:{
					clearConsole();
					if(fachada.listaProfessores() == "") {
						System.out.print("Ainda não existem professores cadastrados.");
						input.nextLine();
					}
					else{
						System.out.print(fachada.listaProfessores());
						input.nextLine();	
					}
					break;
				}
				
				case 5:{
					clearConsole();
					System.out.println("Voltando...");
					input.nextLine();
					break;
				}
			}
		}while(resposta != 5);
	}
	
	private void disciplinasUI() {
		
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		do{
			do{
				clearConsole();
				
				System.out.println("1. adicionar nova disciplina;");
				System.out.println("2. Procurar uma disciplina;");
				System.out.println("3. Atualizar nome de uma disciplina;");
				System.out.println("4. Atualizar carga horaria de uma disciplina");
				System.out.println("5. Remover uma disciplina;");
				System.out.println("6. Ver todas as disciplinas cadastradas;");
				System.out.println("7. Sair.");
				opcao = ehInt(input.nextLine());
				input.nextLine();
			}while(opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4 && opcao != 5 && opcao != 6 && opcao != 7);
			
			switch(opcao){
			case 1:{
				clearConsole();
				System.out.print("Entre com o nome da disciplina: ");
				String nome = input.nextLine();
				
				System.out.print("Entre com a carga horária da disciplina: ");
				double carga = ehDouble(input.nextLine());
				
				Disciplina d = new Disciplina(nome, carga);
				fachada.salvarDisciplina(d);
				break;
			}
			case 2:{
				clearConsole();
				System.out.print("Entre com o id da Disciplina:");
				long id = ehInt(input.nextLine());
				input.nextLine();
				
				System.out.println();
				if(fachada.procurarDisciplina(id) != null) {
					System.out.print(fachada.procurarDisciplina(id));
				}
				if(fachada.procurarDisciplina(id) == null) {
					System.out.print("Disciplina não encontrada.");
				}
				input.nextLine();
				break;
			}
			case 3:{
				boolean a = false;
				do{
					clearConsole();
					System.out.print("Entre com o id da Disciplina:");
					long id = ehInt(input.nextLine());
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
					long id = ehInt(input.nextLine());
					input.nextLine();
					
					if(fachada.procurarDisciplina(id) != null){
						
						System.out.print("Entre com a nova carga horaria: ");
						double novaCargaHorariaT = ehDouble(input.nextLine());
						input.nextLine();
						
						System.out.printf("Confirma atualização da carga horária %.2f para %.2f? ", fachada.procurarDisciplina(id).getCargaHoraria(), novaCargaHorariaT);
						if(simOuNao() == true) {
							fachada.atualizarCargaHoraria(id, novaCargaHorariaT);
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
					long id = ehInt(input.nextLine());
					input.nextLine();
					
					if(fachada.procurarDisciplina(id) != null){
						clearConsole();
						
						System.out.print("Remover disciplina?");
						System.out.print(fachada.procurarDisciplina(id));
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
	
		do{
			do{
				clearConsole();
				System.out.println("*************************");
				System.out.println("*ALOCAÇAO DE PROFESSORES*");
				System.out.println("*************************");
				System.out.println("\n");
				System.out.println(" Escolha sua operação:");
				System.out.println("1. Alocação;");
				System.out.println("2. Professores;");
				System.out.println("3. Disciplinas;");
				System.out.println("4. Sair.");
				System.out.println();
				resposta = ehInt(input.nextLine());
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
		}while(resposta!=4);
		
	}
	
	private void alocacaoUI() {
		Scanner input = new Scanner(System.in);
		int resposta = 0;
		do {
		do{
			clearConsole();
			System.out.println("1. Realizar nova Alocação;");
			System.out.println("2. Remover uma Alocação;");
			System.out.println("3. Atualizar alocado;");
			System.out.println("4. Ver alocado;");
			System.out.println("5. Listar Alocados;");
			System.out.print("6. Sair.");
			resposta = ehInt(input.nextLine());
			input.nextLine();
		}while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4 && resposta!= 5 && resposta!= 6);
		
		
		switch(resposta) {
			case 1:
				clearConsole();
				System.out.println("Escolha um entre os professores para ser alocado e entre com seu id: ");
				System.out.println(fachada.listaProfessores());	
				long idProf = input.nextLong();
				Professor prof = fachada.procurarProf(idProf);
				
				if(prof != null) {
					boolean permitido = false;
					for(int i = 0; i<prof.getDisciplinasPossiveis().size(); i++) {
						if(fachada.procurarDisciplina(prof.getDisciplinasPossiveis().get(i).getId() ) != null ) {
							permitido = true;
						}
					}
					
					if(permitido == true) {
						boolean permitido2 = false;
						boolean a = true;
						Disciplina dis = null;
						do{
							clearConsole();
							System.out.println("Escolha uma entre as disciplinas para ser alocada e entre com o seu id: ");
							System.out.println(fachada.listarDisciplinas());
							
							long idDis = input.nextLong();
							dis = fachada.procurarDisciplina(idDis);
							
							for(int i = 0; i < prof.getDisciplinasPossiveis().size(); i++) {
								if(dis.equals(prof.getDisciplinasPossiveis().get(i)) ){
									permitido2 = true;
								}
							}
							if(permitido2 == false) {
								System.out.print("Disciplina não permitida para esse professor. Tentar adicionar outra disciplina?");
								a = simOuNao();
							}
						}while(permitido2 == false && a == true);
						
						if(permitido2 == true) {
							input.nextLine();
							System.out.print("Período: ");
							String periodo = input.nextLine();
							
							System.out.print("Entre com o horario de início: ");
							int horaIncio = ehInt(input.nextLine());
							System.out.print("Entre com o horario de fim: ");
							int horaFim = ehInt(input.nextLine());
							System.out.print("Entre com a quantidade de dias por semana(máx. 2): ");
							int qtdDias;
							do{
								 qtdDias = ehInt(input.nextLine());
							}while(qtdDias < 0 && qtdDias > 2);
							input.nextLine();
							
							String[] dias = new String[2];
							dias[0] = null;
							dias[1] = null;
							int i = 0;
							do{
								
								System.out.print("Entre com o dia da semana: ");
								if(dias[i] ==null){
									dias[i] = input.nextLine();
									i++;
								}else {
									break;
								}
							}while(i<qtdDias);
							
							Horario hora = new Horario(horaIncio, horaFim, dias[0]);
							
							if(qtdDias > 1) {
							hora.addDiaDaSemana(dias[1]);
							}
							
							Alocacao nova = new Alocacao(prof, dis, periodo, hora);
							int tam = 1;
							if(fachada.lerAlocacaoPorPeriodo(periodo) != null) {
								tam = fachada.lerAlocacaoPorPeriodo(periodo).length;
							}
							Alocacao[] existentes = new Alocacao[tam];
							
							if(fachada.lerAlocacaoPorPeriodo(periodo) != null) {
								for(int z = 0; z< tam; z++) {
									existentes[z] = fachada.lerAlocacaoPorPeriodo(periodo)[z];
								}
								
							}else {
								existentes=null;
							}
							

							boolean permiteSalvamento = true;
							if(existentes != null) {
								for(int j = 0; j<existentes.length; j++) {
									System.out.print("Entrou");
									int count = 0;
									for(int k = 0; k < hora.getDiaDaSemana().size(); k++) {
										for(int w = 0; w < existentes[j].getHorario().getDiaDaSemana().size();w++) {
											if(hora.getDiaDaSemana().get(k).equals(existentes[j].getHorario().getDiaDaSemana().get(w)) ) {
												System.out.println("1Dentro do laço !");
												count++;
											}
										}
									}
									if(nova.getProfessor().equals(existentes[j].getProfessor()) == true && nova.getDisciplina().equals(existentes[j].getDisciplina()) == true && count > 0) {
										System.out.println("2Dentro do laço !");
										permiteSalvamento = false;
									}
									else if(nova.getProfessor().equals(existentes[j].getProfessor()) == true && (nova.getDisciplina().equals(existentes[j].getDisciplina()) == false) && count > 0){
										System.out.println("3Dentro do laço !");
										permiteSalvamento = false;
									}
								}
							}
							
							if(permiteSalvamento == true) {
								boolean c = fachada.salvaAlocacao(nova);
								if(c == true) {
									System.out.println("Salvo com sucesso");
									input.nextLine();
								}else {
									System.out.println("Erro ao tentar salvar");
									input.nextLine();
								}
							}
							else{
								System.out.print("Duas alocações não podem ter o mesmo professor, horario e disciplina.");
								input.nextLine();
							}
							
						}
						else{
							System.out.print("Alocação não realizada");
							input.nextLine();
						}
					}
				}
				else{
					System.out.print("Professor não encontado.");
					input.nextLine();
				}
				
				break;
			
		case 2:
			clearConsole();
			System.out.println("Digite o ID do professor a ser removido: ");
			long id = input.nextLong();
			input.nextLine();
			System.out.println("Confirma essa operação?");
			boolean ans6 = simOuNao();
			boolean b = false;
			if(ans6 == true) {
				b = fachada.removeAlocacao(id);
			} else {
				System.out.println("Operação cancelada...");
			}
			
			if(b == true && ans6 == false) {
				System.out.println("Removido com sucesso.");
			}else {
				System.out.println("Erro ao tentar remover");
			}
			input.nextLine();
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
				System.out.println("5.Sair;");
				op = ehInt(input.nextLine());
				input.nextLine();
			}while(op!=1 && op!= 2 && op!=3&&op!=4 && op!= 5);
				switch(op) {
				case 1:
					clearConsole();
					long id5;
					boolean e5;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar Professor: ");
						id5 = input.nextLong();
						input.nextLine();
						e5 = fachada.verificaExistenciaAlocacao(id5);
						if(e5 == false) {
							System.out.print("Este ID não existe.");
						}
					}while(e5 == false);
					System.out.println(fachada.lerAlocacoPorID(id5).toString());
					
					System.out.print("\nDigite o ID do novo professor: ");
					Long novaProf = input.nextLong();
					input.nextLine();
				
					System.out.println("Confirma essa operação?");
					boolean ans0 = simOuNao();
					clearConsole();
					if(ans0 == true) {
						fachada.updateProfessorAlocacao(id5, fachada.procurarProf(novaProf));
						
						System.out.println("Operação realizada com sucesso");
					
					}else {
						System.out.println("Operação Cancelada...");
					}
					clearConsole();
					break;
				case 2:
					clearConsole();
					long id3;
					boolean e3;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar disciplina: ");
						id3 = input.nextLong();
						input.nextLine();
						e3 = fachada.verificaExistenciaAlocacao(id3);
						if(!e3) {
							System.out.println("Este ID não existe.");
						}
					}while(!e3);
					
					System.out.println(fachada.lerAlocacoPorID(id3).toString());
					
					System.out.print("\nDigite o ID da nova disciplina: ");
					long novaDis = input.nextLong();
					input.nextLine();
					System.out.println("Confirma essa operação?");
					boolean ans5 = simOuNao();
					if(ans5 == true ) {
						fachada.updateDisciplinaAlocacao(id3, fachada.procurarDisciplina(novaDis));
						System.out.println("Operação realizada com sucesso");
					}else {
						System.out.println("Operação Cancelada...");
					}
					
					break;
				case 3:
					clearConsole();
					long id4;
					boolean e4;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar Horario: ");
						id4 = input.nextLong();
						input.nextLine();
						e4 = fachada.verificaExistenciaAlocacao(id4);
						if(!e4) {
							System.out.println("Este ID não existe.");
						}
					}while(!e4);
					
					System.out.println(fachada.lerAlocacoPorID(id4).toString());
					
					System.out.print("\nDigite a nova Hora de início: ");
					int novaHora = ehInt(input.nextLine());
					input.nextLine();
					System.out.print("\nDigite a nova Hora de fim: ");
					int novaHoraf = ehInt(input.nextLine());
					input.nextLine();
					System.out.print("\nDigite o novo Dia da semana: ");
					String novoDia = input.nextLine();
					Horario hora4 = new Horario(novaHora, novaHoraf, novoDia);
					System.out.println("Confirma essa operação?");
					boolean ans = simOuNao();
					if(ans==true){
						fachada.updateHorarioAlocacao(id4, hora4);
						System.out.println("Operação realizada com sucesso");
						input.nextLine();
					}else {
						System.out.println("Operação Cancelada...");
						input.nextLine();
					}
					break;
					
				case 4:
					clearConsole();
					long id6;
					boolean e6;
					do {
						System.out.print("\nDigite o ID do alocado que deseja atualizar o Periodo: ");
						id6 = input.nextLong();
						input.nextLine();
						e6 = fachada.verificaExistenciaAlocacao(id6);
						if(!e6) {
							System.out.println("Este ID não existe.");
						}
					}while(!e6);
					
					System.out.println(fachada.lerAlocacoPorID(id6).toString());
					
					System.out.print("\nDigite o novo Período: ");
					String novaPeriodo = input.nextLine();
					System.out.println("Confirma essa operação?");
					boolean ans2 = simOuNao();
					if(ans2==true){
						fachada.updatePeriodo(id6, novaPeriodo);
						System.out.println(fachada.lerAlocacoPorID(id6).toString());
					
					}else {
						System.out.println("Operação Cancelada...");
						input.nextLine();
					}
					break;
					
				
				case 5:
					clearConsole();
					System.out.print("Voltando...");
					input.nextLine();
					break;
				}
				
				}while(op!=5);
				break;
				
		case 4:
			clearConsole();
			System.out.print("Entre com o id do Alocado:");
			long id1 = ehInt(input.nextLine());
			input.nextLine();
			
			System.out.println();
			System.out.print(fachada.lerAlocacoPorID(id1));
			if(fachada.lerAlocacoPorID(id1) == null) {
				System.out.print("Alocado não encontrado.");
			}
			input.nextLine();
			break;
		case 5:
			clearConsole();
			if(fachada.listaAlocacao() == "") {
				System.out.print("Ainda não existem professores alocados.");
				input.nextLine();
			}
			else{
				System.out.print(fachada.listaAlocacao());
				input.nextLine();
				clearConsole();
			}
			break;
		
		case 6:
			clearConsole();
			System.out.print("Voltando...");
			input.nextLine();
			break;
		}
		
		}while(resposta!=6);
		clearConsole();
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
			resposta = ehInt(input.nextLine());
		}while(resposta != 1 && resposta != 2 && resposta != 3 && resposta != 4);
		
		switch(resposta){
			case 1:{
				clearConsole();
				System.out.println(fachada.listaAlocacao());
			}
			case 2:{
				clearConsole();
				System.out.println(fachada.listaProfessores());
				input.nextLine();
				break;
			}
			case 3:{
				clearConsole();
				System.out.println(fachada.listarDisciplinas());
				input.nextLine();
				break;
			}
			case 4:{
				clearConsole();
				System.out.println("Saindo...");
				clearConsole();
				System.exit(0);
				break;
			}
		}
		input.close();
	}
	
	
		
	public void showUserInterface() {
		System.out.println("------Entre com as Informações requeridas e crie seu Usuário------");
		System.out.println();
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
