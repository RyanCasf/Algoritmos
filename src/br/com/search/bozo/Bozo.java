package br.com.search.bozo;

import java.util.Arrays;
import java.util.Random;

public class Bozo 
{
	private static Random random = new Random();
	
	static int[] sort(int array[]) throws Exception 
	{
		while (!sorted(array)) 
		{
			int index1 = random.nextInt(array.length);
			int index2 = random.nextInt(array.length);

			int temp = array[index2];
			array[index2] = array[index1];
			array[index1] = temp;
		}
		
		return array;
	}
	
	static boolean sorted(int array[]) {
		for (int i=1; i<array.length; i++)  {
			if (array[i-1] > array[i]) {
				return false;
			}
	    }
		return true;
	}
	
	public static void main(String[] args) 
	{
		int[] array = {5, 11, 0, 0, 7, 10, 5, 2, 2, 0, 10, 20};
		
		try 
		{
			array = sort(array);
			System.out.println("TAM.: "+array.length+" ORDER : "+Arrays.toString(array));
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}