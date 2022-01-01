package baekjoon;

import java.io.*;
import java.util.*;

public class _1780_종이의_개수 {
	static int[][] paper;
	static int[] cnt = new int[3];
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		countPapers(0, 0, N);
		for (int i = 0; i < 3; i++) {
			System.out.println(cnt[i]);
		}
	}

	public static void countPapers(int y, int x, int N) {
		if (isSameColor(y, x, N)) {
			cnt[paper[y][x] + 1]++;
			return;
		}

		N /= 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				countPapers(y + N * i, x + N * j, N);
			}
		}
	}

	public static boolean isSameColor(int y, int x, int N) {
		int color = paper[y][x];

		for (int i = y; i < y + N; i++) {
			for (int j = x; j < x + N; j++) {
				if (paper[i][j] != color) {
					return false;
				}
			}
		}

		return true;
	}
}
