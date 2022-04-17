package br.com.search.merge;

public class Merge 
{
	void sort(int[] vetor) {
		try {
			sort(vetor, 0, (vetor.length - 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void sort(int[] vetor, int inicio, int fim) throws Exception {
		if (inicio == fim)
			return;

		int length = fim - inicio + 1;
		int pivot = (inicio + fim) / 2;
		sort(vetor, inicio, pivot);
		sort(vetor, pivot + 1, fim);

		int[] working = new int[length];
		for (int i = 0; i < length; i++) {
			working[i] = vetor[inicio + i];
		}

		int m1 = 0;
		int m2 = pivot - inicio + 1;

		for (int i = 0; i < length; i++) {
			if (m2 <= fim - inicio) {
				if (m1 <= pivot - inicio) {
					if (working[m1] > working[m2]) {
						vetor[i + inicio] = working[m2++];
					} else {
						vetor[i + inicio] = working[m1++];
					}
				} else {
					vetor[i + inicio] = working[m2++];
				}
			} else {
				vetor[i + inicio] = working[m1++];
			}
		}
	}
}