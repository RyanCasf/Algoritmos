package br.com.ryan.game.dama;

import java.util.Scanner;

public class Damas {
	
	private static final String POSICAO_BRANCA = "[]";
	private static final String POSICAO_PRETA = "█";
	private static final String PECA_BRANCA = "M";
	private static final String PECA_PRETA = "@";
	private static boolean isVezPreta = true;
	
	private static String[][] tabuleiro = {
		{POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA},
		{PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA},
		{POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA, POSICAO_BRANCA, PECA_PRETA},
		{POSICAO_PRETA, POSICAO_BRANCA, POSICAO_PRETA, POSICAO_BRANCA, POSICAO_PRETA, POSICAO_BRANCA, POSICAO_PRETA, POSICAO_BRANCA},
		{POSICAO_BRANCA, POSICAO_PRETA, POSICAO_BRANCA, POSICAO_PRETA, POSICAO_BRANCA, POSICAO_PRETA, POSICAO_BRANCA, POSICAO_PRETA},
		{PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA},
		{POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA},
		{PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA, PECA_BRANCA, POSICAO_BRANCA}
	};
	
	public static void main(String... args) {
		imprimirTabuleiro();
		
		do {
			try {
				jogada();
			}
			catch (AvisoException e) {
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println("Opção inválida!");
			}
		} while (continuar());
	}
	
	private static void imprimirTabuleiro() {
		final int TAMANHO = tabuleiro.length;
		
		System.out.print("     0        1         2         3        4         5        6        7");
		int posicaoColuna = 0;
		
		for (int i=0; i<TAMANHO; i++) {
			for (int j=0; j<TAMANHO; j++)
				System.out.print((j == 0 ? "\n" : "") + "|———" + (j == TAMANHO-1 ? "|" : ""));
			
			for (int j=0; j<TAMANHO; j++) {
				System.out.print((j == 0 ? "\n" : "") + "|" + valorPosicaoImprimir(i,j) + (j == TAMANHO-1 ? "| " + posicaoColuna++ : ""));
			}
		}
		
		for (int j=0; j<TAMANHO; j++)
			System.out.print((j == 0 ? "\n" : "") + "|———" + (j == TAMANHO-1 ? "|" : ""));
		
		System.out.print("\n\n");
	}
	
	private static String valorPosicaoImprimir(int i, int j) {
		String valorPosicao = tabuleiro[i][j];
		
		if (valorPosicao.equals(POSICAO_BRANCA)) {
			return "         ";
		}
		else if (valorPosicao.equals(POSICAO_PRETA)) {
			return POSICAO_PRETA + POSICAO_PRETA + POSICAO_PRETA;
		}
		else if (valorPosicao.equals(PECA_PRETA)) {
			return POSICAO_PRETA + PECA_PRETA + POSICAO_PRETA;
		}
		else if (valorPosicao.equals(PECA_BRANCA)) {
			return POSICAO_PRETA + PECA_BRANCA + POSICAO_PRETA;
		}
		
		return "ERRO";
	}
	
	private static void jogada() {
		Scanner scanner = new Scanner(System.in);
		String pecaAtual = (isVezPreta ? PECA_PRETA : PECA_BRANCA);
		
		System.out.println("Digite a linha da peça que deseja mover: " + "(" + pecaAtual + ")");
		Integer linhaPecaInicio = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Digite a coluna da peça que deseja mover: " + "(" + pecaAtual + ")");
		Integer colunaPecaInicio = Integer.parseInt(scanner.nextLine());
		
		verificarSelecionarPeca(linhaPecaInicio, colunaPecaInicio, pecaAtual);
		
		System.out.println("Digite a coluna para onde deseja mover: " + "(" + pecaAtual + ")");
		Integer colunaPecaFinal = Integer.parseInt(scanner.nextLine());
		
		verificarMoverPeca(linhaPecaInicio, colunaPecaInicio, colunaPecaFinal);
		
		scanner.close();
		isVezPreta = false;
		imprimirTabuleiro();
	}
	
	private static void verificarSelecionarPeca(int linhaPecaInicio, int colunaPecaInicio, String peca) {
		String valorPosicao = tabuleiro[linhaPecaInicio][colunaPecaInicio];
		
		if (!valorPosicao.equals(peca)) {
			throw new AvisoException("Posição selecionada não é da peça (" + peca + ")!");
		}
	}
	
	private static void verificarMoverPeca(int linhaPecaInicio, int colunaPecaInicio, int colunaPecaFinal) {
		if (colunaPecaFinal < 0 || colunaPecaFinal > (tabuleiro.length - 1)) {
			throw new AvisoException("Coluna escolhida para o movimento é inválida!!");	
		}
		
		String valorPosicao = tabuleiro[linhaPecaInicio][colunaPecaInicio];
	}
	
	private static boolean continuar() {
		final int TAMANHO = tabuleiro.length;
		boolean existePecaBraca = existePeca(TAMANHO, PECA_BRANCA);
		boolean existePecaPreta = existePeca(TAMANHO, PECA_PRETA);
		
		if (existePecaBraca && existePecaPreta) {
			limparTela();
			imprimirTabuleiro();
			return true;
		}
		else if (existePecaBraca) {
			System.out.println("\n\nBRANCAS VENCERAM!");
			return false;
		} 
		else {
			System.out.println("\n\nPRETAS VENCERAM!");
			return false;
		}
	}
	
	private static boolean existePeca(final int TAMANHO, final String PECA) {
		for (int i=0; i<TAMANHO; i++) {
			for (int j=0; j<TAMANHO; j++) {
				
				if (tabuleiro[i][j].equals(PECA)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static void limparTela() {
		for (byte i=0; i<100; i++) {
			System.out.println();
		}
	}
	
	public static class AvisoException extends RuntimeException {
		
		public AvisoException(String message) {
			super(message);
		}
	}
}