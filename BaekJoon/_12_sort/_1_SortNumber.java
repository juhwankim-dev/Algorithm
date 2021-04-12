package _12_sort;

import java.io.*;
import java.util.*;

public class _1_SortNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int count;
	
		do {
			count = 0;
			for(int i=0; i<N-1; i++) {
				if(arr[i] > arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}while(count != 0);
		
		for(int a : arr) {
			System.out.println(a);
		}
	}
}

// 문제 읽기 30초 버블정렬로 하자!
// 풀기 5분
