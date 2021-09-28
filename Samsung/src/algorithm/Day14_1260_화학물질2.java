package algorithm;

import java.io.*;
import java.util.*;

public class Day14_1260_화학물질2 {
	static HashMap<Integer, Integer> map;
	static int[][] store;
	static int[][] sorted;
	static int[][] dp;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			store = new int[N][N + 1]; // 가로의 합을 저장하려고 +1 함
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num != 0) {
						store[i][0]++; // 가로의 총합 +1
						store[i][j] = -1; // 문제에서 주어진 숫자는 쓸모 없드라..
					}
				}
			}

			map = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 1; j < N; j++) {

					if (cnt >= store[i][0]) { // 뒤쪽으로는 다 0이라서 조사할 가치가 없는 경우
						break;
					} else if (store[i][j] > 0) { // 0보다 큰 경우: 이미 조사를 마친 사각형인 경우
						cnt += store[i][j]; // 카운트하고
						j += store[i][j]; // 점프
					} else if (store[i][j] == -1) { // 사각형 발견!
						measure(i, j);
						cnt += store[i][j]; // 카운트하고
						j += store[i][j]; // 점프
					}
				}
			}
			
			// 시작 번호 구하기
			int k = 0;
			for (int key : map.keySet()) {
				if (!map.containsValue(key)) {
					k = key;
					break;
				}
			}

			// 배열로 옮겨담기
			sorted = new int[map.size()][2];
			int idx = 0;
			while (map.containsKey(k)) {
				sorted[idx][0] = k;
				sorted[idx++][1] = map.get(k);
				k = map.get(k);
			}

			dp = new int[sorted.length][sorted.length];
			for (int i = 0; i < sorted.length; i++)
				Arrays.fill(dp[i], -1);
			
			sb.append("#").append(tc).append(" ").append(dfs(0, sorted.length - 1)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void measure(int i, int j) {
		int h = 0, w = 0;

		// 세로길이 측정
		int y=i, x=j;
		while (y < N && store[y][x] != 0) {
			h++;
			y++;
		}

		y=i; x=j;
		// 가로길이 측정
		while (x < N + 1 && store[y][x] != 0) {
			w++;
			x++;
		}

		// 사각형 크기 저장
		//pq.add(new Square(h, w));
		map.put(h, w);
		
		// 사각형의 첫 행에 건너뛸 칸수를 저장해둠
		for (y = i; y < i + h; y++) {
			store[y][j] = w;
		}
	}
	
	public static int dfs(int start, int end) {
		if(start == end) {
			return 0;
		}
		if (dp[start][end] != -1) {
			return dp[start][end];
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=start; i<end; i++) {
			int left = dfs(start, i);
			int right = dfs(i + 1, end);
			int sum = sorted[start][0] * sorted[i][1] * sorted[end][1];
			min = Math.min(left + right + sum, min);
		}
		
		return dp[start][end] = min;
	}
}