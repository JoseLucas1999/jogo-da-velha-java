package app;

import java.util.Arrays;
import java.util.Scanner;

public class Forca {
	private static final Scanner scan = new Scanner(System.in);
	public static void jogoForca() {
		char[] palavra = {'G','O','I','A','B','A','D','A'};
		char[] tentativa = {'_','_','_','_','_','_','_','_'};
		
		String palavraString = imprimirpalavra(palavra);
		
		int count = 0;
		boolean check = false;
		while(count < 10 || check == false) {
			check = escolherLetra(palavra, tentativa, count, check);
			count ++;
			if(count == 10) {
				System.out.println("Você Perdeu!!!");
				System.out.println("A palavra era: "+palavraString);
			}
		}
	}
	
	public static boolean escolherLetra(char[] palavra, char[] tentativa, int count, boolean check) {
		System.out.println("\nEscolha uma letra");
		char letra = Character.toUpperCase(scan.next().charAt(0));
		boolean certo = false;
		for(int i = 0; i < palavra.length; i++) {
			if(palavra[i] == letra) {
				tentativa[i] = palavra[i];
				certo = true;
			}
		}
		if(certo) {
			System.out.println("A Letra está Correta!");
		}else {
			System.out.println("Você Errou!!!");
		}
		String tentativaString = imprimirTentativa(tentativa);
		System.out.println("PALAVRA: " + tentativaString);
		
		check = verificar(palavra,tentativa);
		if(check == true) {
			System.out.println("Você Venceu!!!");
		}
		return check;
	}
	
	public static String imprimirTentativa(char[] tentativa) {
		String tentativaString = "";
		for(int i = 0; i < tentativa.length; i++) {
			tentativaString += tentativa[i];
		}
		return tentativaString;
	}
	
	public static String imprimirpalavra(char[] palavra) {
		String palavraString = "";
		for(int i = 0; i < palavra.length; i++) {
			palavraString += palavra[i];
		}
		return palavraString;
	}
	
	public static boolean verificar(char[] palavra, char[] tentativa) {
		boolean check = Arrays.equals(palavra, tentativa);
		return check;
	}
	
	
}
