package algorithm;

import java.io.*;
import java.util.*;

public class Day16_4012_요리사 {
	static int N;
	static int min;
	static int[][] synergy;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			synergy = new int[N][N];
			visited = new boolean[N];
			
			// 시너지 구하기
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if (i < j) {
						synergy[i][j] += Integer.parseInt(st.nextToken());
					} else if (i > j) {
						synergy[j][i] += Integer.parseInt(st.nextToken());
					} else {
						st.nextToken();
					}
				}
			}

			min = Integer.MAX_VALUE;
			subSet();

			sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean subSet() {
		for (int i = 1; i < 1 << N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					cnt++;
					visited[j] = true;
					
					if (cnt == N / 2) {
						solve();
						visited[j] = false;
						cnt--;
						break;
					}
				}
			}
		}

		return false;
	}

	public static void solve() {
		ArrayList<Integer> ingredA = new ArrayList<>();
		ArrayList<Integer> ingredB = new ArrayList<>();
		int foodA = 0;
		int foodB = 0;

		for (int i = 0; i < N; i++) {
			if (visited[i])
				ingredA.add(i);
			else
				ingredB.add(i);
		}


		for (int i = 0; i < ingredA.size() - 1; i++) {
			for (int j = i; j < ingredB.size(); j++) {
				foodA += synergy[ingredA.get(i)][ingredA.get(j)];
				foodB += synergy[ingredB.get(i)][ingredB.get(j)];
			}
		}

		min = Math.min(Math.abs(foodA - foodB), min);
	}
}


/*

*/