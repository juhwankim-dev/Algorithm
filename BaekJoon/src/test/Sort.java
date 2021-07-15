package test;

import java.util.*;

public class Sort {
	public static int[] tmp; // �迭�� ���� ��� �����ص� ����
	public static final int DATASIZE = 2000;

	public static void main(String[] args) {
		System.out.println("[������ ����: 2000��]\n");

		int[] arr = makeRandomNumbers();
		int[] copiedArr;

		long startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		bubbleSort(copiedArr);
		long endTime = System.currentTimeMillis();
		System.out.println("���� ����: " + (endTime - startTime) / 1000.0 + "��");

		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		selectionSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("���� ����: " + (endTime - startTime) / 1000.0 + "��");

		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		insertionSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("���� ����: " + (endTime - startTime) / 1000.0 + "��");

		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		shellSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("�� ����: " + (endTime - startTime) / 1000.0 + "��");
		
		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		quickSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("�� ����: " + (endTime - startTime) / 1000.0 + "��");
		
		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		mergeSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("�պ� ����: " + (endTime - startTime) / 1000.0 + "��");

		System.out.println();
	}

	public static int[] makeRandomNumbers() {
		Random random = new Random();
		HashSet<Integer> hs = new HashSet<>();
		int[] arr = new int[DATASIZE];

		for (int i = 0; i < DATASIZE; i++) {
			int number = random.nextInt(DATASIZE);

			if (hs.contains(number)) {
				i--;
				continue;
			} else {
				hs.add(number);
				arr[i] = number;
			}
		}

		return arr;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, arr[j - 1], arr[j]);
				}
			}
		}
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int indexMin = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[indexMin]) {
					indexMin = j;
				}
			}
			swap(arr, arr[i], arr[indexMin]);
		}
	}

	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;

			// ������ ��ġ�� ã���鼭 ���� ������ ���ܿ�
			while (j > 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			// ������ ��ġ�� ã������ ����!
			arr[j + 1] = temp;
		}
	}

	public static void shellSort(int[] arr) {
		int len = arr.length;

		// gap�� ũ�⸦ �����ش�.
		for (int gap = len / 2; gap > 0; gap /= 2) {

			// gap�� ¦���� 1�� ���� Ȧ���� ������ش�.
			if (gap % 2 == 0)
				gap++;

			// ���� ����
			for (int i = gap; i < len; i++) {
				int temp = arr[i];
				int j = i - gap;

				while (j >= 0 && arr[j] > temp) {
					arr[j + gap] = arr[j];
					j -= gap;
				}
				arr[j + gap] = temp;
			}
		}
	}

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int left, int right) {
		// �� �̻� ������ ���� ������ ����
		if (left >= right)
			return;

		int mid = partition(arr, left, right);
		quickSort(arr, left, mid - 1);
		quickSort(arr, mid, right);
	}

	// ����
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];

		// �������� ������ ��� �ݺ�
		while (left <= right) { // 1. �迭�� ���� �ߺ��ؼ� ���� ���� <=

			// left�� right ã��
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;

			// �������� ������ swap
			if (left <= right) { // 2. 1�� ����
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void mergeSort(int[] arr) {
		tmp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
	}

	private static void mergeSort(int[] arr, int start, int end) {
		// ���Ұ� 2�� �̻��̶��
		if(start < end) {
			// �߾� ���� ���ϰ�
			int mid = (start + end) / 2;
			// �߾��� �������� 2���� �׷����� ����
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			// ���� �� ����
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		// �迭 ����
		tmp = arr.clone();
		
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		/*
		 * part1: ���� �׷��� ���� �ε���
		 * part2: ������ �׷��� ���� �ε���
		 * index: ���ĵ� ���� ���յ� �迭�� � ��ġ�� �־���ϴ� ��
		 */
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		
		// �� �׷��� ������ ���Ұ� ������������ �ݺ� (���� & �պ�)
		while(part1 <= mid && part2 <= end) {
			if(tmp[part1] <= tmp[part2]) {
				arr[index++] = tmp[part1++];
			} else {
				arr[index++] = tmp[part2++];
			}
		}
		
		// ���� �׷��� ���Ұ� ���� ��� ó��
		// (������ �׷��� ���Ұ� ���� ���� ���� ó������ �ʾƵ� �ȴ�)
		for(int i=0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
	}
}
