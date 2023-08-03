package br.com.ToDoList.functions;

import java.util.Scanner;

public class CreateParameter {
	
	public Scanner scanner;
	
	public CreateParameter() {
		scanner = new Scanner(System.in);
	}
	
	
	public String CreateString(String mensagem) {
		System.out.print(mensagem);
		return scanner.next();
	}
	
	public int CreateInt(String mensagem) {
        int numero = 0 ;
        while(true){
            System.out.print(mensagem);
            if (scanner.hasNextInt()){
                numero = scanner.nextInt();
                break;

            }else{
                System.out.println("Por favor digite um número!");            
                scanner.nextLine();
            }
        }
        return numero;
	}
	
	public double CreateDouble(String mensagem) {
		double numeroDouble = 0.0;
		while (true) {
			System.out.print(mensagem);
			
			if(scanner.hasNextDouble()) {
				numeroDouble = scanner.nextDouble();
				break;
			}else {
				System.out.println("Por favor digite um numero!");
				scanner.nextLine();
			}
		}
		return numeroDouble;
	}
	
    public String title(String mensagem, int numero) {
        String linha = "==".repeat(numero);
        return linha + "\n" + mensagem + "\n" + linha;
    }

    public String line(int numero) {
        return "==".repeat(numero);
    }
}




