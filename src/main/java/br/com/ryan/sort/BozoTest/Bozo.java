package br.com.ryan.sort.BozoTest;

import java.util.Random;

public class Bozo {
	
	static int[] sort(int[] array) throws NullPointerException {
		if (array == null) {
			throw new NullPointerException("Array to sort is null!");
		}
		
		final Random random = new Random();
		
		while (!sorted(array)) {
			int index1 = random.nextInt(array.length);
			int index2 = random.nextInt(array.length);

			int temp = array[index2];
			array[index2] = array[index1];
			array[index1] = temp;
		}
		
		return array;
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