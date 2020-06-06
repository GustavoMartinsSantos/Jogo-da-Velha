package Jogodavelha;

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
		// impressão das posições da matriz
		
		Scanner input = new Scanner (System.in);
		for(int y = 1; y <= 5; y++) { //irá ocorrer 9 vezes
			for(int z = 1; z < 2; z++) { // somente 1 vez
				System.out.print("Digite a posição da O: "); // Digitar a posição da O
					
				int o = input.nextInt(); 
				// entrada de dados da bolinha
				
				while (o <= 0 || o > 9) {
					System.out.print("Você digitou o número errado. Tente novamente: ");
					o = input.nextInt();
				}
				// mensagem de erro
				
				switch(o) { // caso o valor da O for de 1 a 9, então será substituído
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
					default:
						main(null);
						// o código tenta rodar de novo se acontecer algum erro na entrada de dados
				}
					
				System.out.println("Jogo da Velha"); 
				for(l = 0; l < 3; l++) {
					for(c = 0; c < 3; c++)
						System.out.print(vetor[l][c]);
					System.out.println("");
				}
				// imprimir o novo valor da matriz
			}
				
			if (y == 5)  // se o contador de y chegar a 5 ele para a linha de execução abaixo
				continue;
				
			System.out.print("Digite a posição do X: "); 
			int x = input.nextInt();
				
			while (x <= 0 || x > 9) {
				System.out.print("Você digitou o número errado. Tente novamente: ");
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
				default: 
					main(null);
					// o código tenta rodar de novo se acontecer algum erro na entrada de dados
			}
				
			System.out.println("Jogo da Velha");
			for(l = 0; l < 3; l++) {
				for(c = 0; c < 3; c++)
					System.out.print(vetor[l][c]);
				System.out.println("");
			}
				// impressão da matriz
		}
		input.close();
	}

}
