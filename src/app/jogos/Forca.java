package app.jogos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Forca {
	
	private static final Scanner scan = new Scanner(System.in);
	public static void jogoForca() {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("goiabadaCa");
		palavras.add("computador");
		palavras.add("brincadeira");
		palavras.add("formigueiro");
		palavras.add("abacateiro");
		palavras.add("salgadeira");
		palavras.add("desafiante");
		palavras.add("martelinho");
		palavras.add("alfinetada");
		palavras.add("encanamento");
		
		char[] tentativa = {'_','_','_','_','_','_','_','_','_','_'};
		int pointer = (int)(Math.random() * 10);
		char[] palavra = palavras.get(pointer).toCharArray();
		for (char c : palavra) {
		    System.out.print(c);
		}
		
		int count = 0;
		boolean check = false;
		
		
		while(true) {
			check = escolherLetra(palavra, tentativa, count, check);
			count ++;
			
			if(check) {
				System.out.println("Você Venceu!!!");
				break;
			}
			if(count == 10) {
				System.out.println("Você Perdeu!!!");
				System.out.println("A palavra era: "+imprimirPalavra(palavra));
				break;
			}
		}
	}
	
	public static boolean escolherLetra(char[] palavra, char[] tentativa, int count, boolean check) {
		System.out.println("\nEscolha uma letra");
		char letra = scan.next().charAt(0);
		boolean certo = false;
		for(int i = 0; i < palavra.length; i++) {
			if(palavra[i] == letra) {
				tentativa[i] = letra;
				certo = true;
			}
		}
		if(certo) {
			System.out.println("A Letra está Correta!");
		}else {
			System.out.println("Você Errou!!!");
		}
		String tentativaString = imprimirTentativa(tentativa);
		tentativaString.toUpperCase();
		System.out.println("PALAVRA: " + tentativaString);
		
		check = verificar(palavra,tentativa);
		return check;
	}
	
	public static String imprimirTentativa(char[] tentativa) {
		StringBuilder sb = new StringBuilder();
		for(char c : tentativa) {
			sb.append(c);
		}
		return sb.toString().trim();
	}
	
	public static String imprimirPalavra(char[] palavra) {
		StringBuilder sb = new StringBuilder();
		for(char c : palavra) {
			sb.append(c);
		}
		return sb.toString().trim();
	}
	
	public static boolean verificar(char[] palavra, char[] tentativa) {
		boolean check = Arrays.equals(palavra, tentativa);
		return check;
	}
	
	
}
