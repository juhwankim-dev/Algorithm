package baekjoon;

import java.io.*;
import java.util.*;

public class _1992_ÄõµåÆ®¸® {
	static int[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}

		compress(0, 0, N);
		System.out.println(sb.toString());
	}

	public static void compress(int y, int x, int size) {
		if (isSameColor(y, x, size)) {
			sb.append(arr[y][x]);
		}

		else {
			sb.append("(");
			size /= 2;
			compress(y, x, size);
			compress(y, x + size, size);
			compress(y + size, x, size);
			compress(y + size, x + size, size);
			sb.append(")");
		}
	}

	public static boolean isSameColor(int y, int x, int size) {
		int color = arr[y][x];

		for (int i = y; i < y + size; i++) {
			for (int j = x; j < x + size; j++) {
				if (color != arr[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
