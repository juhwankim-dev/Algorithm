package baekjoon;

import java.io.*;
import java.util.*;

public class _10815_숫자_카드 {
	static int[] card;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		card = new int[N];

		HashSet<Integer> hs = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(M);
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(st.nextToken());
			sb.append(hs.contains(n) ? 1 : 0).append(" ");
		}

		System.out.println(sb.toString());
	}

}
