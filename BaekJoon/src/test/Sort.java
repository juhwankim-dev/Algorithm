package test;

import java.util.*;

public class Sort {
	public static int[] tmp; // 배열의 값을 잠시 복사해둘 공간
	public static final int DATASIZE = 2000;

	public static void main(String[] args) {
		System.out.println("[데이터 개수: 2000개]\n");

		int[] arr = makeRandomNumbers();
		int[] copiedArr;

		long startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		bubbleSort(copiedArr);
		long endTime = System.currentTimeMillis();
		System.out.println("버블 정렬: " + (endTime - startTime) / 1000.0 + "초");

		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		selectionSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("선택 정렬: " + (endTime - startTime) / 1000.0 + "초");

		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		insertionSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("삽입 정렬: " + (endTime - startTime) / 1000.0 + "초");

		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		shellSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("셸 정렬: " + (endTime - startTime) / 1000.0 + "초");
		
		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		quickSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("퀵 정렬: " + (endTime - startTime) / 1000.0 + "초");
		
		startTime = System.currentTimeMillis();
		copiedArr = arr.clone();
		mergeSort(copiedArr);
		endTime = System.currentTimeMillis();
		System.out.println("합병 정렬: " + (endTime - startTime) / 1000.0 + "초");

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

			// 삽일할 위치를 찾으면서 이전 값들을 땡겨옴
			while (j > 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}

			// 삽입할 위치를 찾았으니 삽입!
			arr[j + 1] = temp;
		}
	}

	public static void shellSort(int[] arr) {
		int len = arr.length;

		// gap의 크기를 정해준다.
		for (int gap = len / 2; gap > 0; gap /= 2) {

			// gap이 짝수면 1을 더해 홀수로 만들어준다.
			if (gap % 2 == 0)
				gap++;

			// 삽입 정렬
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
		// 더 이상 분할이 되지 않으면 종료
		if (left >= right)
			return;

		int mid = partition(arr, left, right);
		quickSort(arr, left, mid - 1);
		quickSort(arr, mid, right);
	}

	// 분할
	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];

		// 엇갈리지 않으면 계속 반복
		while (left <= right) { // 1. 배열에 값이 중복해서 들어가는 경우는 <=

			// left와 right 찾기
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;

			// 엇갈리지 않으면 swap
			if (left <= right) { // 2. 1과 동일
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
		// 원소가 2개 이상이라면
		if(start < end) {
			// 중앙 값을 구하고
			int mid = (start + end) / 2;
			// 중앙을 기준으로 2개의 그룹으로 분할
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			// 정렬 후 병합
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		// 배열 복사
		tmp = arr.clone();
		
		for(int i=0; i<arr.length; i++) {
			tmp[i] = arr[i];
		}
		
		/*
		 * part1: 왼쪽 그룹의 시작 인덱스
		 * part2: 오른쪽 그룹의 시작 인덱스
		 * index: 정렬된 값을 병합된 배열의 어떤 위치에 넣어야하는 지
		 */
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		
		// 두 그룹중 한쪽의 원소가 오링날때까지 반복 (정렬 & 합병)
		while(part1 <= mid && part2 <= end) {
			if(tmp[part1] <= tmp[part2]) {
				arr[index++] = tmp[part1++];
			} else {
				arr[index++] = tmp[part2++];
			}
		}
		
		// 왼쪽 그룹의 원소가 남는 경우 처리
		// (오른쪽 그룹의 원소가 남는 경우는 따로 처리하지 않아도 된다)
		for(int i=0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
	}
}
