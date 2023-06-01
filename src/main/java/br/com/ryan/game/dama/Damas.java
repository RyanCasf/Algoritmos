package br.com.ryan.game.dama;

public class Damas {
	
	private static String POSICAO_BRANCA = "[]", POSICAO_PRETA = "█";
	private static String PECA_BRANCA = "M", PECA_PRETA = "@";
	
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
		final int TAMANHO = tabuleiro.length;
		
		imprimirTabuleiro(TAMANHO);
	}
	
	private static void imprimirTabuleiro(final int TAMANHO) {
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
}