
import java.util.*;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] array1 = {2, -1, 3, 4, -2, 6, -7, 49, 2, 8, 5, 1, 4};
		int[] array2 = {9, 8, 2, 10, 6, 5, 1, 3, 14, 4};
		int[] array3 = {9, 10, 12, 9, 6, 9, 10, 7, 12, 9, 10, 6, 9, 6, 10};
		int[] array4 = {7, 9, 12, 10, 6};
		int[] array5 = {3, 10, 65, 8, 45, 23, 9, 24, 18, 58, 69, 9, 2};
		int[] array6 = {2, 6, 4, 3, 7, 1, 5};
		int[] array7 = {85, 21, 43, 51, 68, 48, 24, 18, 91, 86, 1, 10, 35, 45, 16, 19, 14, 93, 99, 42, 57, 15, 23, 38, 50, 28, 84, 27, 67, 
				58, 44, 3, 6, 17, 22, 30, 33, 36, 47, 71, 29, 61, 73, 97, 4, 20, 83, 13, 90, 7};
		heapSort(array1);
		heapSort(array2);
		heapSort(array3);
		heapSort(array4);
		heapSort(array5);
		heapSort(array6);
		heapSort(array7);
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		System.out.println(Arrays.toString(array3));
		System.out.println(Arrays.toString(array4));
		System.out.println(Arrays.toString(array5));
		System.out.println(Arrays.toString(array6));
		System.out.println(Arrays.toString(array7));
		int[] array8 = new int[1000];
		Random rand = new Random();
		for (int i = 0; i < 1000; i++) {
			array8[i] = rand.nextInt(1000);
		}
		System.out.println(Arrays.toString(array8));
		heapSort(array8);
		for (int i = 0; i < array8.length - 1; i++) {
			if (array8[i] > array8[i + 1]) {
				System.out.println("false");
			}
		}
		System.out.println("true");
	}
	
	public static boolean isLeftChild(int start, int end) {
		return (2 * start + 1 <= end);
	}
	
	public static boolean isRightChild(int start, int end) {
		return (2 * start + 2 <= end);
	}
	
	public static void buildMaxHeap(int[] a, int endIndex) {
		int focus = 0;
		while (focus <= endIndex) {
			int leftChild = 2 * focus + 1;
			int rightChild = 2 * focus + 2;
			if (isLeftChild(focus, endIndex)) {
				if (a[leftChild] > a[focus]) {
					swap(a, focus, leftChild);
				}
			} if (isRightChild(focus, endIndex)) { 
				if (a[rightChild] > a[focus]) {
					swap(a, focus, rightChild);
				}
			}
			int curr = focus;
			int parent = (curr - 1) / 2;
			while (parent >= 0 && a[parent] < a[curr]) {
				swap(a, parent, curr);
				curr = parent;
				parent = (parent - 1) / 2;
			}
			focus++;
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
	}
	
	public static void restoreHeap(int[] a, int heapEnd) {
		int node = 0;
		while (isLeftChild(node, heapEnd) || isRightChild(node, heapEnd)) {
			int leftChild = 2 * node + 1;
			int rightChild = 2 * node + 2;
			if (isLeftChild(node, heapEnd) && isRightChild(node, heapEnd)) {
				if (a[leftChild] < a[rightChild]) {
					if (a[rightChild] > a[node]) {
						swap(a, node, rightChild);
					}
					node = rightChild;
				} else {
					if (a[leftChild] > a[node]) {
						swap(a, node, leftChild);
					}
					node = leftChild;
				}
			} else {
				if (a[leftChild] > a[node]) {
					swap(a, node, leftChild);
				}
				node = leftChild;
			}
		}
	}
	
	public static void heapSort(int[] a) {
		int heapEnd = a.length - 1;
		buildMaxHeap(a, heapEnd);
		while (heapEnd > 0) {
			swap(a, 0, heapEnd);
			heapEnd--;
			restoreHeap(a, heapEnd);
		}
	}

}
