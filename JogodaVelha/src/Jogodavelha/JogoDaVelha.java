package Jogodavelha;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JogoDaVelha {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		String[][] matriz = new String[3][3];
        String opc;
        int posicao_y;
        int posicao_x;
        String jogador1;
        String jogador2;
        String simbolo = "X";
        boolean sair = false;

         System.out.print("Jogador X: ");
         jogador1 = input.next();
         System.out.print("Jogador O: ");
         jogador2 = input.next();

         try {
         	do {    
        		 for (int cont = 0; cont < 9; cont++) { 
        			 do {
	                     System.out.print("Digite a posição vertical: ");
	                     posicao_y = input.nextInt();
	                     System.out.print("Digite a posição horizontal: ");
	                     posicao_x = input.nextInt();
	                 } while (posicao_y <= 0 || posicao_y > 3 ||
	                          posicao_x <= 0 || posicao_x > 3 ||
	                          matriz[posicao_y - 1][posicao_x - 1] != null);
	
	                 matriz[posicao_y - 1][posicao_x - 1] = simbolo;
	
	                 for (int y = 0; y < 3; y++) {
	                     for (int x = 0; x < 3; x++) {
	                    	 if ((matriz[y][0] == "X" && matriz[y][1] == "X" && matriz[y][2] == "X") ||
		                             (matriz[y][0] == "O" && matriz[y][1] == "O" && matriz[y][2] == "O") ||
		                             (matriz[0][x] == "X" && matriz[1][x] == "X" && matriz[2][x] == "X") ||
		                             (matriz[0][x] == "O" && matriz[1][x] == "O" && matriz[2][x] == "O") ||
		                             (matriz[0][0] == "X" && matriz[1][1] == "X" && matriz[2][2] == "X") ||
		                             (matriz[0][0] == "O" && matriz[1][1] == "O" && matriz[2][2] == "O") ||
		                             (matriz[0][2] == "X" && matriz[1][1] == "X" && matriz[2][0] == "X") ||
		                             (matriz[0][2] == "O" && matriz[1][1] == "O" && matriz[2][0] == "O")) {
		                             sair = true;
		                             break;
		                     }
	                    	 
	                         if (matriz[y][x] == null)
	                             System.out.print("[_]");
	                         else
	                             System.out.print("[" + matriz[y][x] + "]");
	                     }
	
	                     if (sair == true)
	                         break;
	
	                     System.out.println();
	                 }
	
	                 if (sair == true) 
	                     break;
	
	                 if (simbolo == "X") {
	                     simbolo = "O";
	                 } else {
	                     simbolo = "X";
	                 }
	             }
	
	             if (sair == true) {
	                 if(simbolo == "X")
	                     System.out.println(jogador1 + " ganhou!!");
	                 else
	                     System.out.println(jogador2 + " ganhou!!");
	             }
	
	             System.out.print("Deseja começar novamente [S] ou [N]? ");
	             opc = input.next();
	
	             sair = false;
	             simbolo = "X";
	             for (int y = 0; y < 3; y++) {
	                 for (int x = 0; x < 3; x++)
	                     matriz[y][x] = null;
	             }
         	} while (opc.toUpperCase().equals("S"));
        } catch (InputMismatchException e) {
   			System.out.println("Você digitou o valor errado!");
   			main(null);
   		} catch (Exception e) {
   			System.out.println("ERRO!");
   			e.printStackTrace();
   		} 
         	
        System.out.println("Obrigado por testar o programa!");	
     	input.close();
	}
	
}