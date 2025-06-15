package app.jogos;

import java.util.Scanner;

public class BatalhaNaval {
	private static final Scanner scan = new Scanner(System.in);
	public static void jogoBatalhaNaval() {
		String[][] tabuleiro = {
				{"   ","A","B","C","D","E","F","G","H","I","J"},
				{"1 -","0","0","0","0","0","0","0","0","0","0"},
				{"2 -","0","0","0","0","0","0","0","0","0","0"},
				{"3 -","0","0","0","0","0","0","0","0","0","0"},
				{"4 -","0","0","0","0","0","0","0","0","0","0"},
				{"5 -","0","0","0","0","0","0","0","0","0","0"},
				{"6 -","0","0","0","0","0","0","0","0","0","0"},
				{"7 -","0","0","0","0","0","0","0","0","0","0"},
				{"8 -","0","0","0","0","0","0","0","0","0","0"},
				{"9 -","0","0","0","0","0","0","0","0","0","0"},
				{"10-","0","0","0","0","0","0","0","0","0","0"},
		};
		
//		este tabuleiro é uma cópia sem os navils, será aprentado ao jogador
		String[][] tabuleiro2 = new String[tabuleiro.length][];
		for(int i = 0; i < tabuleiro.length; i++) {
			tabuleiro2[i] = tabuleiro[i].clone();
		}
		System.out.println("BATALHA NAVAL - Derrube 5 navils para Vencer\n");
		
//		esse tabuleironão será exibido
		gerarNavils(tabuleiro);
		imprimir(tabuleiro2);
		
		int count = 0; //numero de chances
		boolean check = false;
		int ship = 0; // numero de acerto em navils
		int water = 0; // numero de acerto na aguá
		System.out.println("\nAcertos na água: "+ water + " Navils Derrubados: " + ship+"\n");
		while(count < 10 || water < 5) {
			check = escolher(tabuleiro, tabuleiro2, check);
			count++;
			
			if(check == true) {
				ship++;
			}else {
				water++;
			}
			
			if(count == 10) {
				System.out.println("\nVocê Cedeu suas tentativas e Perdeu!!!");
			}else if(water == 5) {
				System.out.println("\nVocê Acertou a água 5 vezes e Perdeu!!!");
			}else if(ship == 10){
				System.out.println("\nParabéns Marinheiro Você derrubou 5 Navils e Ganhou!!!");
			}
			
			System.out.println("\nAcertos na água: "+ water + " Navils Derrubados: " + ship);
		}
	}
	
//	Gerar Navils Aleatórios
	private static String[][] gerarNavils(String[][] tabuleiro) {
		for(int i = 0; i <= 30; i++ ) {
			int line = (int)(Math.random() * 10) + 1;
			int raw = (int)(Math.random() * 10) + 1;
			
			if(tabuleiro[line][raw] == "X") {
				i--;
				continue;
			}else {
				tabuleiro[line][raw] = "X";
			}
		}
		return tabuleiro;
	}
	
//	Imprimir Tabuleiro
	private static void imprimir(String[][] tabuleiro) {
		for (String[] linha : tabuleiro) {
			for(String elemento : linha) {
				System.out.print(elemento + " ");
			}
			System.out.println();
		}
	}
	
//	Jogador Escolhe Campo para atacar
//	retorna boolean para crsh ou hit
	private static boolean escolher(String[][] tabuleiro, String[][] tabuleiro2, boolean check) {
		System.out.println("\nEscolha um campo! (linha (ENTER) e Coluna(ENTER)\n");
		int linhaEscolhida = scan.nextInt();
		scan.nextLine();
		String coluna = scan.nextLine();
		int colunaEscolhida = 0;
		
		if(coluna.equalsIgnoreCase("a")) {colunaEscolhida = 1;
		}else if(coluna.equalsIgnoreCase("b")) {colunaEscolhida = 2;}
		 else if(coluna.equalsIgnoreCase("c")) {colunaEscolhida = 3;}
		 else if(coluna.equalsIgnoreCase("d")) {colunaEscolhida = 4;}
		 else if(coluna.equalsIgnoreCase("e")) {colunaEscolhida = 5;}
		 else if(coluna.equalsIgnoreCase("f")) {colunaEscolhida = 6;}
		 else if(coluna.equalsIgnoreCase("g")) {colunaEscolhida = 7;}
		 else if(coluna.equalsIgnoreCase("h")) {colunaEscolhida = 8;}
		 else if(coluna.equalsIgnoreCase("i")) {colunaEscolhida = 9;}
		 else if(coluna.equalsIgnoreCase("j")) {colunaEscolhida = 10;}
		
		if(tabuleiro[linhaEscolhida][colunaEscolhida] == "X"){
			tabuleiro2[linhaEscolhida][colunaEscolhida] = "X";
			check = true; // crash ship
			System.out.println("\nBoa Jogada Marinheiro!\n");
		}else {
			tabuleiro2[linhaEscolhida][colunaEscolhida] = "A";
			System.out.println("\nVocê Acertou Água!\n");
			check = false; // water
		}
		imprimir(tabuleiro2);
		
		return check;
	}
}	
