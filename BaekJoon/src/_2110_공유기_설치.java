package baekjoon;

import java.io.*;
import java.util.*;

public class _2110_공유기_설치 {
	static int[] house;
	static int N, C, answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		house = new int[N];
		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		binarySearch();
		System.out.println(answer);
	}

	public static void binarySearch() {
		int low = 0, high = house[N - 1];
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (isProperDist(mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

	}

	public static boolean isProperDist(int dist) {
		int modem = C - 1;
		int pre = house[0];
		int closest = Integer.MAX_VALUE;

		for (int i = 1; i < N; i++) {
			if (house[i] - pre >= dist) {
				if (house[i] - pre < closest) {
					closest = house[i] - pre;
				}

				modem--;
				pre = house[i];
			}

			if (modem == 0) {
				answer = Math.max(answer, closest);
				return true;
			}
		}

		return false;
	}
}
