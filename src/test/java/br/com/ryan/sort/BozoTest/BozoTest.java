package br.com.ryan.sort.BozoTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class BozoTest {
	
	@Test
	public void sortNull() {
		assertThrows(NullPointerException.class, () -> Bozo.sort(null));
	}
	
	@Test
	public void sortEmpty() {
		int[] inteiros = new int[0];
		assertArrayEquals(new int[] {}, Bozo.sort(inteiros));
	}
	
	@Test
	public void sortOne() {
		int[] inteiros = new int[] {0};
		assertArrayEquals(new int[] {0}, Bozo.sort(inteiros));
	}
	
	@Test
	public void sortSome() {
		int[] inteiros = new int[] {0,20,90,2,3,1,54,43,65,7,4};
		assertArrayEquals(new int[] {0,1,2,3,4,7,20,43,54,65,90}, Bozo.sort(inteiros));
	}
	
	@Test
	public void sortRandom() {
		final int SIZE = 10;
		int[] inteiros = new int[SIZE];
		
		for (int i=0; i<SIZE; i++) {
			int value = (int) Math.abs(Math.random()) + 1;
			inteiros[i] = value;
		}
		
		assertEquals(SIZE, inteiros.length);
		
		for (int i = 1; i<SIZE; i++) {
			assertFalse(inteiros[i - 1] > inteiros[i]);
		}
	}
}