package app.jogos;

import java.util.Scanner;

public class Velha {
	private static final Scanner scan = new Scanner(System.in);
	public static void jogoVelha() {
		//tabuleiro
		String[][] tabuleiro = {
				{" ","A","B","C"},
				{"1","0","0","0"},
				{"2","0","0","0"},
				{"3","0","0","0"},
	
		};
		
		imprimirTabuleiro(tabuleiro);
		System.out.println();
		
		boolean check = false;
		while(!check) {
			check =	radadas(tabuleiro, check);
		}
	}
	
	private static boolean radadas(String[][] tabuleiro, boolean check) {
		
		if(check == false) {
			escolhaX(tabuleiro);
			imprimirTabuleiro(tabuleiro);
			check = verificacao(tabuleiro);
		}

		if(check == false) {
			escolhaY(tabuleiro);
			imprimirTabuleiro(tabuleiro);
			check = verificacao(tabuleiro);
		}
		
		return check;
	}
	
	private static void escolhaX(String[][] tabuleiro) {
		int linha = 0;
		String coluna  = null;
		
		System.out.println("jogador X escolha linha (1 2 3) e Coluna (A B C )!");
		linha = scan.nextInt();
		
		scan.nextLine();
		coluna = scan.nextLine();
		
		int c  = 0;
		if(coluna.equalsIgnoreCase("A")) {c = 1;
		}else if(coluna.equalsIgnoreCase("B")) { c = 2;
		}else if (coluna.equalsIgnoreCase("C")){c = 3;}

		VerificarCasaX(tabuleiro, linha, c);

	}
	private static void VerificarCasaX(String[][] tabuleiro, int linha, int c) {
		if(tabuleiro[linha][c] != "0") {
			System.out.println("essa casa já está ocupada!");
			escolhaX(tabuleiro);
		}else {
			tabuleiro[linha][c] = "x";
		}
	}
	
	private static void escolhaY(String[][] tabuleiro) {
		int linha = 0;
		String coluna  = null;
		
		System.out.println("jogador bolinha escolha linha (1 2 3) e Coluna (A B C )!");
		linha = scan.nextInt();
		
		scan.nextLine();
		coluna  = scan.nextLine();
		
		int c  = 0;
		if(coluna.equalsIgnoreCase("A")) {c = 1;
		}else if(coluna.equalsIgnoreCase("B")) { c = 2;
		}else if (coluna.equalsIgnoreCase("C")){c = 3;}

		VerificarCasaY(tabuleiro, linha, c);
	}
	
	private static void VerificarCasaY(String[][] tabuleiro, int linha, int c) {
		if(tabuleiro[linha][c] != "0") {
			System.out.println("essa casa já está ocupada!");
			escolhaY(tabuleiro);
		}else {
			tabuleiro[linha][c] = "o";
		}
	}
	
	private static void imprimirTabuleiro(String[][] tabuleiro ) {
		for(int i = 0; i < tabuleiro.length; i++) {
			for(int j = 0; j < tabuleiro[i].length; j++) {
				System.out.print(tabuleiro[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	private static boolean verificacao(String[][] tabuleiro ) {
		if(
			//sequencia de linha
			tabuleiro[1][1].equals("x") && tabuleiro[1][2].equals("x") && tabuleiro[1][3].equals("x") ||
			tabuleiro[2][1].equals("x") && tabuleiro[2][2].equals("x") && tabuleiro[2][3].equals("x") ||
			tabuleiro[3][1].equals("x") && tabuleiro[3][2].equals("x") && tabuleiro[3][3].equals("x") ||
			//sequencia de coluna
			tabuleiro[1][1].equals("x") && tabuleiro[2][1].equals("x") && tabuleiro[3][1].equals("x") ||
			tabuleiro[1][2].equals("x") && tabuleiro[2][2].equals("x") && tabuleiro[3][2].equals("x") ||
			tabuleiro[1][3].equals("x") && tabuleiro[2][3].equals("x") && tabuleiro[3][3].equals("x") ||
			//sequencia diagonal
			tabuleiro[1][1].equals("x") && tabuleiro[2][2].equals("x") && tabuleiro[3][3].equals("x") ||
			tabuleiro[1][3].equals("x") && tabuleiro[2][2].equals("x") && tabuleiro[3][1].equals("x") 
				) {
			System.out.println("Jogador X Venceu o Jogo!");
			return true;
		}else if(
				//sequencia de linha
				tabuleiro[1][1].equals("o") && tabuleiro[1][2].equals("o") && tabuleiro[1][3].equals("o")||
				tabuleiro[2][1].equals("o") && tabuleiro[2][2].equals("o") && tabuleiro[2][3].equals("o") ||
				tabuleiro[3][1].equals("o") && tabuleiro[3][2].equals("o") && tabuleiro[3][3].equals("o") ||
				//sequencia de coluna
				tabuleiro[1][1].equals("o") && tabuleiro[2][1].equals("o") && tabuleiro[3][1].equals("o") ||
				tabuleiro[1][2].equals("o") && tabuleiro[2][2].equals("o") && tabuleiro[3][2].equals("o") ||
				tabuleiro[1][3].equals("o") && tabuleiro[2][2].equals("o") && tabuleiro[3][3].equals("o") ||
				//sequencia diagonal
				tabuleiro[1][1].equals("o") && tabuleiro[2][2].equals("o") && tabuleiro[3][3].equals("o") ||
				tabuleiro[1][3].equals("o") && tabuleiro[2][2].equals("o") && tabuleiro[1][3].equals("o")  
				){
			System.out.println("Jogador bolinha Venceu o Jogo!");
			return true;
		}
		return false;
	}
}
