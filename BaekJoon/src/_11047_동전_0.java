package baekjoon;

import java.io.*;
import java.util.*;

public class _11047_µ¿Àü_0 {
	static int[] cash;
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cash = new int[N];
		for (int i = 0; i < N; i++) {
			cash[i] = Integer.parseInt(br.readLine());
		}

		int idx = N - 1;
		int coin = 0;
		while (K > 0) {
			int cnt = K / cash[idx];
			if (cnt > 0) {
				K -= cash[idx] * cnt;
				coin += cnt;
			}
			idx--;
		}

		System.out.println(coin);
	}

}
