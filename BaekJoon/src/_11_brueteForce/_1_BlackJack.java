package _11_brueteForce;

import java.io.*;
import java.util.*;

public class _1_BlackJack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 카드의 개수
		int M = Integer.parseInt(st.nextToken()); // 근접하게 만들어야 할 숫자 M
		
		int[] cards = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getHighestNumber(N, M, cards));
	}

	public static int getHighestNumber(int N, int M, int[] cards) {
		int highestNumber = 0;
		int sum = 0;
		
		for(int i=0; i<N-2; i++) {
			for(int j=1; j<N-1; j++) {
				for(int k=2; k<N; k++) {
					sum = cards[i] + cards[j] + cards[k];
					if( sum <= M && sum > highestNumber) {
						highestNumber = sum;
					}
				}
			}
		}
		
		return highestNumber;
	}
}

// 문제 읽기 5분
// 문제 풀기 13분