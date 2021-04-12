package _16_greedyAlgorithm;

import java.io.*;
import java.util.*;

public class _1_Coin0 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] price = new int[N];
		
		// ������ ��ġ
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		int coins = 0;
		
		while(K != 0) {
			N--;
			if(K/price[N] != 0) {
				coins += K/price[N];
				K %= price[N];
			}
		}

		System.out.println(coins);
	}

}

// ���� �а� Ǯ�� 6��
// �� ���� �˰��� �����غ��� 3��
