package app;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import objetos.Veiculo;

public class Main {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int op;
		do {
			System.out.println("*****SISTEMA DE GERENCIAMENTO DE ESTACIONAMENTO*****\n");
			System.out.println("[1]Vaga | [2]Veículo | [3]Saída de veículo | [0]Sair");
			op = scan.nextInt();
			scan.nextLine();
			switch(op) {
			case 1: 
				int op1;
				do {
					System.out.println("[1]Adicionar vaga | [2]Listar vaga | [0]Sair");
					op1 = scan.nextInt();
					scan.nextLine();
					switch(op1) {
					case 1:
						logica.logicaVaga.cadastroVaga();
						break;
					case 2:
						logica.logicaVaga.listarVaga();
						break;
					}
				}while(op1 != 0);
			break;
			case 2:
				int op2;
				do {
					System.out.println("[1]Adicionar veículo | [2]Listar veículo | [0]Sair");
					op2 = scan.nextInt();
					scan.nextLine();
					switch(op2) {
					case 1:
						System.out.println("\nVagas disponíveis:");
						logica.logicaVaga.listarVaga();
						logica.logicaVeiculo.cadastroVeiculo();
						break;
					case 2:
						logica.logicaVeiculo.listarVeiculo();
						break;
					}
				}while(op2 != 0);
			break;
			case 3:
				System.out.println("\n*****SAÍDA DE VEÍCULO*****");
				logica.logicaVaga.listarVaga();
				
				logica.logicaVaga.numeroSaidaVeiculo();
				
				logica.logicaVaga.horaSaidaLogica();
                break;
			}
			
		}while(op != 0);
		System.out.println("Sistema finalizado!!");
	}
	
	public static Scanner sc() {
		return scan;
	}

}
