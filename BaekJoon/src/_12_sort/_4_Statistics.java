package _12_sort;

import java.io.*;
import java.util.*;

public class _4_Statistics {

	static final int MAX = 8001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[MAX];
		
		// 산술평균: 다 더해서 N으로 나눈 값
		// 중앙값: 오름차순으로 정렬했을 때 가장 중앙에 위치하는 값
		// 최빈값: 가장 많이 나타나는 값
		// 범위: 최댓값과 최솟값의 차이
		int sum=0, mean, median=0, mode=0, diff; 
		int min=4000, max=-4000;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) + 4000;
			arr[num]++;
			if(min > num) min = num;
			if(max < num) max = num;
		}
		
		for(int i=0; i<MAX; i++) {
			if(arr[i] > 0) {
				count += arr[i];
				if(median == 0 && count > N/2) median = i; 
				
				if(arr[i] > mode) {
					mode = i;
				}
				
				while(arr[i]-- > 0) {
					sum += arr[i];
				}
			}
		}
		mean = sum/N;
		diff = max-min;
		
		System.out.println(mean);
		System.out.println(median-4000);
		System.out.println(mode-4000);
		System.out.println(diff);
	}

}



// -4000~4000 그리고 최대 500,000개

// 문제 읽고 생각하기 3분 30초
// 문제 풀기 19분 졸려서 잠시 스탑..내일할래