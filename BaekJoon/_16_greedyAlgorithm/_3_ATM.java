package _16_greedyAlgorithm;

import java.io.*;
import java.util.*;

public class _3_ATM {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] minute = new int[N];
		
		for(int i=0; i<N; i++) {
			minute[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(minute);
		int sum = 0;
		
		for(int i=1; i<N; i++) {
			minute[i] += minute[i-1];
			sum += minute[i-1];
		}
		
		
		System.out.println(sum + minute[N-1]);
	}

}
