
public class Heap<T extends Comparable<T>> {
	private static final int CAPACITY = 2;

	private int size;
	private T[] heap;

	public Heap() {
		size = 0;
		heap = (T[]) new Comparable[CAPACITY];
	}

	public Heap(T[] array) {
		size = array.length;
		heap = (T[]) new Comparable[array.length + 1];

		System.arraycopy(array, 0, heap, 1, array.length);

		ConstruirHeap();
	}

	private void ConstruirHeap() {
		for (int k = size / 2; k > 0; k--) {
			corrigeDescendo(k);
		}
	}

	private void corrigeDescendo(int k) {
		T tmp = heap[k];
		int filho;

		for (; 2 * k <= size; k = filho) {
			filho = 2 * k;

			if (filho != size && heap[filho].compareTo(heap[filho + 1]) > 0)
				filho++;

			if (tmp.compareTo(heap[filho]) > 0)
				heap[k] = heap[filho];
			else
				break;
		}
		heap[k] = tmp;
	}

	/**
	 * Ordena com o HeapSort
	 */
	public void heapSort(T[] array) {
		size = array.length;
		heap = (T[]) new Comparable[size + 1];
		System.arraycopy(array, 0, heap, 1, size);
		ConstruirHeap();

		for (int i = size; i > 0; i--) {
			T tmp = heap[i];
			heap[i] = heap[1];
			heap[1] = tmp;
			size--;
			corrigeDescendo(1);
		}
		for (int k = 0; k < heap.length - 1; k++)
			array[k] = heap[heap.length - 1 - k];
	}

}