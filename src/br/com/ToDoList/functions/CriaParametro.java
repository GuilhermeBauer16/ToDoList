package br.com.ToDoList.functions;

import java.util.Scanner;

public class CriaParametro {
	
	public Scanner scanner;
	
	public CriaParametro() {
		scanner = new Scanner(System.in);
	}
	
	
	public String CriaString(String mensagem) {
		System.out.print(mensagem);
		return scanner.next();
	}
	
	public int CriaInt(String mensagem) {
		int numero = 0;
		while (true) {
			System.out.print(mensagem);
			
			if(scanner.hasNextInt()) {
				numero = scanner.nextInt();
				break;
			}else {
				System.out.println("Por favor digite um numero!");
			}
		}
		return numero;
	}
	
	public double CriaDouble(String mensagem) {
		double numeroDouble = 0.0;
		while (true) {
			System.out.print(mensagem);
			
			if(scanner.hasNextDouble()) {
				numeroDouble = scanner.nextDouble();
				break;
			}else {
				System.out.println("Por favor digite um numero!");
			}
		}
		return numeroDouble;
	}
}




