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
		// 최대 힙 만들기
		heapSort(arr, arr.length);
		
		for(int i = arr.length - 1 ; i >= 0 ; i--){		
			// root 노드 <-> 마지막 노드 
			swap(arr, 0, i);
			
			// 마지막 노드를 제외하고 다시 최대 힙으로 만들기
			heapSort(arr, i);
		}
	}

	public static void heapSort(int[] arr, int size) {
		for(int i = 1 ; i < size ; i++){
			int currentNode = i;
			
			while(currentNode != 0) {
				int currentRoot = (currentNode - 1) / 2;
				
				// (부모 노드 < 자식 노드) 이면 swap
				if(arr[currentRoot] < arr[currentNode]){
					swap(arr, currentRoot, currentNode);
				} else {
					break; // 더 이상 위로 올라가며 검사할 필요가 없음
				}
				
				// 위로 한 칸 올라감.
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