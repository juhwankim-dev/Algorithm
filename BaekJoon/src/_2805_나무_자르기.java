package baekjoon;

import java.io.*;
import java.util.*;

public class _2805_����_�ڸ��� {
	static int[] tree;
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if (max < tree[i]) {
				max = tree[i];
			}
		}

		binarySearch(max);
		System.out.println(answer);
	}

	public static void binarySearch(int max) {
		int low = 0, high = max;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			long woods = getWoods(mid);

			// ��ǥġ���� ���� ���
			if (M > woods) {
				high = mid - 1;
			}

			// ��ǥġ���� ���ų� ���� ���
			else {
				low = mid + 1;
				answer = mid;
			}
		}
	}

	public static long getWoods(int h) {
		long sum = 0;
		for (int i = 0; i < N; i++) {
			int wood = (tree[i] <= h) ? 0 : tree[i] - h;
			sum += wood;
		}

		return sum;
	}
}
