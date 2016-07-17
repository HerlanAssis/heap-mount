
public class HeapTeste {

	public static void main(String[] args) {
		Integer[] a = { 4, 7, 7, 7, 5, 0, 2, 3, 5, 1 };
		Heap<Integer> heap = new Heap<Integer>(a);
		heap.heapSort(a);
		// System.out.println(Arrays.toString(a));
		for (int i = 0; i < a.length; i++) {
			System.out.print("[" + a[i] + "]");
		}
	}

}
