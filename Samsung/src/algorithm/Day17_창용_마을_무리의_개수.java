package algorithm;

import java.io.*;
import java.util.*;

public class Day17_창용_마을_무리의_개수 {
	static int[] root;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			root = new int[N + 1];

			// 자기 자신을 가르키도록
			for (int i = 1; i <= N; i++) {
				root[i] = i;
			}

			// 두 사람의 번호를 union
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				union(from, to);
			}
			
			// 루트 노드의 개수를 세기위함
			HashSet<Integer> hs = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				hs.add(find(i));
			}

			sb.append("#").append(tc).append(" ").append(hs.size()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int find(int x) {
		if (root[x] == x) {
			return x;
		} else {
			return find(root[x]);
		}
	}

	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) return;
		root[rootA] = rootB;
	}
}

// 1. DFS로 시도해봤는데. 음.. 이게 왜 안되는지 모르겠음. 런타임 에러 뜸 코드는 SWEA에..