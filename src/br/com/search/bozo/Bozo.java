package br.com.search.bozo;

import java.util.Arrays;
import java.util.Random;

public class Bozo {
	private static final Random random = new Random();

	public static void main(String[] args) {
		int[] array = { 5, 11, 0, 0, 7, 10, 5, 2, 2, 0, 10, 20 };

		try {
			sort(array);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("TAM.: " + array.length + " ORDER : " + Arrays.toString(array));
	}
	
	static void sort(int[] array) {
		while (!sorted(array)) {
			int index1 = random.nextInt(array.length);
			int index2 = random.nextInt(array.length);

			int temp = array[index2];
			array[index2] = array[index1];
			array[index1] = temp;
		}
	}

	static boolean sorted(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1] > array[i]) {
				return false;
			}
		}
		return true;
	}
}