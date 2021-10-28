package baekjoon;

import java.util.*;
import java.io.*;

public class 단지번호붙이기_2667번 {
	static int N;
	static boolean[][] house;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int houseCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		house = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = input.charAt(j);
				if (ch == '1') {
					house[i][j] = true;
				}
			}
		}

		PriorityQueue<Integer> answer = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (house[i][j]) {
					houseCnt = 0;
					house[i][j] = true;
					DFS(i, j);
					if(houseCnt == 0) {
						answer.add(1);
					} else {
						answer.add(houseCnt);
					}
				}
			}
		}

		System.out.println(answer.size());
		while(!answer.isEmpty()) {
			System.out.println(answer.poll());
		}
	}

	public static void DFS(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (check(newY, newX)) {
				house[newY][newX] = false;
				houseCnt++;
				DFS(newY, newX);
			}
		}
	}

	public static boolean check(int y, int x) {
		if (x < 0 || y < 0 || x >= N || y >= N) {
			return false;
		}

		return house[y][x];
	}
}
