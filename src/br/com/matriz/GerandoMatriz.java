package br.com.matriz;
import java.util.Scanner;

public class GerandoMatriz
{
	public static void main(String args[])
	{
		System.out.println("\tMATRIZ.:");
		
		try
		{
			Scanner in = new Scanner(System.in);
		
			System.out.println("Digite a quantidade de colunas para a matriz: ");
			Integer firts = in.nextInt();

			System.out.println("Digite a quantidade de linhas para a matriz: ");
			Integer end = in.nextInt();

			gerarMatriz(firts, end);
			in.close();
		}
		catch(Exception e) { System.out.println("Op��o inv�lida!"); }
	}

	public static void gerarMatriz(int firts, int end)
	{
		if (firts > 0 && end > 0) {
			System.out.println("\n\n\tOrdem "+firts);

			for (int i=1; i<(firts+1) ; i++) {
				System.out.print("\n"+i);
			
				for (int j=2; j<(end+1) ; j++) {
					System.out.print("\t"+j);
				}
			}
		}
		else
		{
			System.out.println("Matriz incorreta...");
		}
	}
}