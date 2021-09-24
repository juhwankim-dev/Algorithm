package algorithm;

import java.io.*;
import java.util.*;

public class Day14_1258_행렬찾기 {
	static PriorityQueue<Square> pq;
	static int[][] store;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		Comparator<Square> comparator = new Comparator<Square>() {

			@Override
			public int compare(Square o1, Square o2) {
				return o1.compareTo(o2);
			}

		};

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

			pq = new PriorityQueue<Square>(comparator);
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 1; j < N + 1; j++) {
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

			// 순서 구하기
			sb.append("#").append(tc).append(" ").append(pq.size()).append(" ");
			while (!pq.isEmpty()) {
				Square s = pq.poll();
				sb.append(s.h).append(" ").append(s.w).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void measure(int i, int j) {
		int h = 0, w = 0;

		// 세로길이 측정
		int y = i, x = j;
		while (y < N && store[y][x] != 0) {
			h++;
			y++;
		}

		y = i;
		x = j;
		// 가로길이 측정
		while (x < N + 1 && store[y][x] != 0) {
			w++;
			x++;
		}

		// 사각형 크기 저장
		pq.add(new Square(h, w));

		// 사각형의 첫 행에 건너뛸 칸수를 저장해둠
		for (y = i; y < i + h; y++) {
			store[y][j] = w;
		}
	}

}

class Square implements Comparable<Square> {
	int h;
	int w;

	public Square(int h, int w) {
		this.h = h;
		this.w = w;
	}

	@Override
	public int compareTo(Square s) {
		int thisArea = this.h * this.w;
		int area = s.h * s.w;

		if (thisArea != area) {
			return thisArea - area;
		}

		return this.h - s.h;
	}
}