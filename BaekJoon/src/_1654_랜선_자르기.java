package baekjoon;

import java.io.*;
import java.util.*;

public class _1654_랜선_자르기 {
	static int K, N, max = Integer.MIN_VALUE;
	static long answer = 0;
	static int[] lan;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		lan = new int[K];

		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if (lan[i] > max) {
				max = lan[i];
			}
		}

		binaraySearch();
		System.out.println(answer);
	}

	public static void binaraySearch() {
		long low = 0, mid, high = max;
		int cnt = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			cnt = getLanCount(mid);

			if (cnt >= N) {
				answer = Math.max(answer, mid);
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
	}

	public static int getLanCount(long len) {
		int cnt = 0;
		if (len == 0) {
			len = 1;
		}

		for (int i = 0; i < K; i++) {
			cnt += (lan[i] / len);
		}

		return cnt;
	}
}
