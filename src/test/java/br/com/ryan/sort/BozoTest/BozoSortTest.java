package br.com.ryan.sort.BozoTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.ryan.sort.simple.bozo.BozoSort;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Ordenation list by method Bozo")
class BozoSortTest {
	
	@Test @DisplayName("Order with null list")
	void sortNull() {
		assertThrows(NullPointerException.class, () -> BozoSort.sort(null));
	}
	
	@Test @DisplayName("Order with empty list")
	void sortEmpty() {
		final int[] INTEGERS_EMPTY = new int[0];
		assertArrayEquals(new int[] {}, BozoSort.sort(INTEGERS_EMPTY));
	}
	
	@Test @DisplayName("Order with one element list")
	void sortOne() {
		final int[] INTEGERS_ONE = new int[] {0};
		assertArrayEquals(new int[] {0}, BozoSort.sort(INTEGERS_ONE));
	}
	
	@Test @DisplayName("Order with random elements list")
	void sortRandom() {
		final int SIZE = 10;
		int[] integers = new int[SIZE];
		
		for (int i=0; i<SIZE; i++) {
			final int VALUE = (int) Math.abs(Math.random()) + 1;
			integers[i] = VALUE;
		}
		
		assertEquals(SIZE, integers.length);
		
		for (int i = 1; i<SIZE; i++) {
			assertFalse(integers[i - 1] > integers[i]);
		}
	}
	
	@Test @DisplayName("Order with bad condition elements list")
	void sortBadSome() {
		final int[] INTEGERS_BAD = new int[] {10,9,8,7,6,5,4,3,2,1,0};
		assertArrayEquals(new int[] {0,1,2,3,4,5,6,7,8,9,10}, BozoSort.sort(INTEGERS_BAD));
	}
	
	@Test @DisplayName("Order with mid condition elements list")
	void sortMidSome() {
		final int[] INTEGERS_MID = new int[] {0,20,90,2,3,1,54,43,65,7,4};
		assertArrayEquals(new int[] {0,1,2,3,4,7,20,43,54,65,90}, BozoSort.sort(INTEGERS_MID));
	}
	
	@Test @DisplayName("Order with best condition elements list")
	void sortBestSome() {
		final int[] INTEGERS_BEST = new int[] {0,1,2,3,4,5,6,7,8,9,10};
		assertArrayEquals(new int[] {0,1,2,3,4,5,6,7,8,9,10}, BozoSort.sort(INTEGERS_BEST));
	}
}