package algorithm;

import java.io.*;
import java.util.*;

public class Day16_벌꿀채취 {
	static PriorityQueue<Honey> pq;
	static int N, M, C;
	static int[][] hive;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		Comparator<Honey> comparator = new Comparator<Honey>() {

			@Override
			public int compare(Honey o1, Honey o2) {
				return o1.compareTo(o2);
			}
		};
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			hive = new int[N][N];
			pq = new PriorityQueue<Honey>(comparator);
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					hive[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ArrayList<Integer> arr = new ArrayList<>();
			for (int i = 0; i < N; i++) {

				// M개 만큼 벌통 넣기
				for (int j = 0; j < M; j++) {
					arr.add(hive[i][j]);
				}
				subSet(arr, i, 0);

				// 벌통을 한칸씩 이동하며 최대치 찾기
				for (int j = M; j < N; j++) {
					arr.remove(0);
					arr.add(hive[i][j]);
					subSet(arr, i, j - M + 1);
				}

				arr.clear();
			}

			sb.append("#").append(tc).append(" ").append(getMaximumHoney()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static boolean subSet(ArrayList<Integer> arr, int y, int x) {
		loop: for (int i = 1; i < 1 << arr.size(); i++) {
			int sum = 0;
			int cnt = 0;
			for (int j = 0; j < arr.size(); j++) {
				if ((i & (1 << j)) != 0) {
					cnt += arr.get(j);
					sum += Math.pow(arr.get(j), 2);

					if (cnt > C) {
						continue loop;
					}
				}
			}
			pq.add(new Honey(y, x, sum));
		}

		return false;
	}

	public static int getMaximumHoney() {
		Honey h1 = pq.poll();

		while(!pq.isEmpty()) {
			Honey h2 = pq.poll();
			if (h1.y != h2.y) {
				return h1.profit + h2.profit;
			} else {
				if (h1.x < h2.x && h1.x + M < h2.x) {
					return h1.profit + h2.profit;
				} else if (h1.x > h2.x && h1.x > h2.x + M) {
					return h1.profit + h2.profit;
				}
			}
		}
		
		return -1;
	}
}

class Honey implements Comparable<Honey> {
	int y;
	int x;
	int profit;

	public Honey(int y, int x, int profit) {
		this.y = y;
		this.x = x;
		this.profit = profit;
	}

	@Override
	public int compareTo(Honey o) {
		return o.profit - this.profit;
	}
}
