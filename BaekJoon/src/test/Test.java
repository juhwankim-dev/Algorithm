package test;

import java.io.*;
import java.util.*;

public class Test {
	public static void main(String[] args) throws IOException {
		int[] arr = { 3, 1, 7, 4, 5, 6, 8, 2 };

		heapSort(arr);
		for (int a : arr) {
			System.out.println(a);
		}
	}
	
	public static void heapSort(int[] arr) {
		// �ִ� �� �����
		heapSort(arr, arr.length);
		
		for(int i = arr.length - 1 ; i >= 0 ; i--){		
			// root ��� <-> ������ ��� 
			swap(arr, 0, i);
			
			// ������ ��带 �����ϰ� �ٽ� �ִ� ������ �����
			heapSort(arr, i);
		}
	}

	public static void heapSort(int[] arr, int size) {
		for(int i = 1 ; i < size ; i++){
			int currentNode = i;
			
			while(currentNode != 0) {
				int currentRoot = (currentNode - 1) / 2;
				
				// (�θ� ��� < �ڽ� ���) �̸� swap
				if(arr[currentRoot] < arr[currentNode]){
					swap(arr, currentRoot, currentNode);
				} else {
					break; // �� �̻� ���� �ö󰡸� �˻��� �ʿ䰡 ����
				}
				
				// ���� �� ĭ �ö�.
				currentNode = currentRoot;
			}
		}
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}