package Jogodavelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		String vetor[][] = new String[3][3];
		int l = 0;
		int c = 0;
		
		vetor[0][0] = "_1_";
		vetor[0][1] = "_2_";
		vetor[0][2] = "_3_";
		vetor[1][0] = "_4_";
		vetor[1][1] = "_5_";
		vetor[1][2] = "_6_";
		vetor[2][0] = "_7_";
		vetor[2][1] = "_8_";
		vetor[2][2] = "_9_";
		
		System.out.println("Jogo da Velha");
		for(l = 0; l < 3; l++) {
			for(c = 0; c < 3; c++)
				System.out.print(vetor[l][c]);
			System.out.println("");
		}
		// impress�o das posi��es da matriz
		String option = "1";
		
		Scanner input = new Scanner (System.in);
		try {
			while (option.equals("1")) {
				for(int y = 1; y <= 5; y++) { 
					System.out.print("Digite a posi��o da O: "); 
						
					int o = input.nextInt(); 
					
					while (o <= 0 || o > 9) {
						System.out.print("Voc� digitou o n�mero errado. Tente novamente: ");
						o = input.nextInt();
					} // mensagem de erro
						
					switch(o) { // caso o valor da o for de 1 a 9, ent�o ser� substitu�do
						case 1: 
							vetor[0][0] = "_O_";
							break;
						case 2:
							vetor[0][1] = "_O_";
							break;
						case 3:
							vetor[0][2] = "_O_";
							break;
						case 4:
							vetor[1][0] = "_O_";
							break;
						case 5:
							vetor[1][1] = "_O_";
							break;
						case 6:
							vetor[1][2] = "_O_";
							break;
						case 7:
							vetor[2][0] = "_O_";
							break;
						case 8:
							vetor[2][1] = "_O_";
							break;
						case 9:
							vetor[2][2] = "_O_";
							break;
					}
						
					System.out.println("Jogo da Velha"); 
					for(l = 0; l < 3; l++) {
						for(c = 0; c < 3; c++)
							System.out.print(vetor[l][c]);
						System.out.println("");
					}
					// imprimir o novo valor da matriz
				
					
					if (y == 5)  // se o contador de y chegar a 5 ele para a linha de execu��o abaixo
						continue;
					
					System.out.print("Digite a posi��o do X: "); 
					int x = input.nextInt();
					
					while (x <= 0 || x > 9) {
						System.out.print("Voc� digitou o n�mero errado. Tente novamente: ");
						x = input.nextInt();
					} // mensagem de erro
					
					switch(x) {
						case 1: 
							vetor[0][0] = "_X_";
							break;
						case 2:
							vetor[0][1] = "_X_";
							break;
						case 3:
							vetor[0][2] = "_X_";
							break;
						case 4:
							vetor[1][0] = "_X_";
							break;
						case 5:
							vetor[1][1] = "_X_";
							break;
						case 6:
							vetor[1][2] = "_X_";
							break;
						case 7:
							vetor[2][0] = "_X_";
							break;
						case 8:
							vetor[2][1] = "_X_";
							break;
						case 9:
							vetor[2][2] = "_X_";
							break;
					}
					
					System.out.println("Jogo da Velha");
					for(l = 0; l < 3; l++) {
						for(c = 0; c < 3; c++)
							System.out.print(vetor[l][c]);
						System.out.println("");
					}
					// impress�o da matriz
				}
				System.out.print("Digite 1 para continuar jogando: ");
				option = input.next();
			}
		}
		catch (InputMismatchException e) {
			System.out.println("Voc� digitou o valor errado!");
			main(null);
		}
		catch (Exception e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}
		
		System.out.println("Obrigado por testar o programa!");	
		input.close();
	}
	
}