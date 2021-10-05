package algorithm;

import java.io.*;
import java.util.*;

public class Day17_탈주범_검거 {
	static int[][] map;
	static int[][] log;
	static Pipe[] pipes = new Pipe[8];
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, M, L, pos;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		init();

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
			L = Integer.parseInt(st.nextToken()); // 시간

			map = new int[N][M];
			log = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					log[i][j] = Integer.MAX_VALUE;
				}
			}

			pos = 0;
			dfs(R, C, 1);

			sb.append("#").append(tc).append(" ").append(pos).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void init() {
		pipes[1] = new Pipe(true, true, true, true);
		pipes[2] = new Pipe(true, true, false, false);
		pipes[3] = new Pipe(false, false, true, true);
		pipes[4] = new Pipe(true, false, false, true);
		pipes[5] = new Pipe(false, true, false, true);
		pipes[6] = new Pipe(false, true, true, false);
		pipes[7] = new Pipe(true, false, true, false);
	}

	public static void dfs(int y, int x, int hour) {
		if (hour > L) return;
		if (log[y][x] == Integer.MAX_VALUE) pos++; // 초기값이 아니라면 처음 들르는 곳이니 pos++
		log[y][x] = hour;

		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (check(y, x, newY, newX, i) && hour + 1 < log[newY][newX]) {
				dfs(newY, newX, hour + 1);
			}
		}
	}

	public static boolean check(int y, int x, int newY, int newX, int direc) {
		// 범위 초과 검사
		if (newY < 0 || newX < 0 || newY >= N || newX >= M) {
			return false;
		}

		// 파이프 없는 곳인지 검사
		if (map[newY][newX] == 0) {
			return false;
		}

		// 연결 가능한 상태인지 검사
		if (pipes[map[y][x]].isConnected(pipes[map[newY][newX]], direc)) {
			return true;
		}

		return false;
	}
}

class Pipe {
	boolean U;
	boolean D;
	boolean L;
	boolean R;

	public Pipe(boolean U, boolean D, boolean L, boolean R) {
		this.U = U;
		this.D = D;
		this.L = L;
		this.R = R;
	}

	public boolean isConnected(Pipe p, int direc) {
		if (direc == 0 && this.U && p.D) {
			return true;
		} else if (direc == 1 && this.D && p.U) {
			return true;
		} else if (direc == 2 && this.L && p.R) {
			return true;
		} else if (direc == 3 && this.R && p.L) {
			return true;
		}

		return false;
	}
}