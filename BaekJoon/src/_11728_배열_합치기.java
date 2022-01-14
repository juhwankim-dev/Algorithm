package baekjoon;

import java.io.*;
import java.util.*;

public class _11728_배열_합치기 {
	static int[] arr;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + M];

		st = new StringTokenizer(br.readLine());
		int i = 0;
		while (i < N) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		while (i < N + M) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < N + M; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
}
