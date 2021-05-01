package _11_brueteForce;

import java.io.*;
import java.util.*;

public class _1_BlackJack {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // ī���� ����
		int M = Integer.parseInt(st.nextToken()); // �����ϰ� ������ �� ���� M
		
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

// ���� �б� 5��
// ���� Ǯ�� 13��