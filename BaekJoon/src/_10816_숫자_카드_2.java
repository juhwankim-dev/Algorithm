package baekjoon;

import java.io.*;
import java.util.*;

public class _10816_숫자_카드_2 {
	static int[] card;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		card = new int[N];

		HashMap<Integer, Integer> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			hm.put(key, hm.getOrDefault(key, 0) + 1);
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(M);
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(hm.getOrDefault(key, 0)).append(" ");
		}

		System.out.println(sb.toString());
	}
}
