package br.com.matriz;

import java.util.Scanner;

public class GerandoMatriz {
	public static void main(String[] args) {
		System.out.println("\tMATRIZ");

		try {
			Scanner in = new Scanner(System.in);

			System.out.println("Dígite a qtde. de Colunas para a matriz: ");
			Integer firts = Integer.parseInt(in.next());

			System.out.println("Dígite a qtde. de Linhas para a matriz: ");
			Integer end = Integer.parseInt(in.next());

			gerarMatriz(++firts, ++end);
			in.close();
		} catch (Exception e) {
			System.out.println("Opção inválida!");
		}
	}

	public static void gerarMatriz(int firts, int end) {
		if (firts > 0 && end > 0) {
			System.out.println("\n\n\tOrdem " + firts+"x"+end);

			for (int i=1; i <firts; i++) {
				System.out.print("\n"+i);

				for (int j=2; j <end; j++) {
					System.out.print("\t" + j);
				}
			}
		} 
		else {
			System.out.println("Matriz incorreta...");
		}
	}
}