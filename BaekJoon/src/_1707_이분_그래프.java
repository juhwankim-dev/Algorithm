package baekjoon;

import java.io.*;
import java.util.*;

public class _1707_이분_그래프 {
	static ArrayList<ArrayList<Integer>> graph;
	static int V, E;
	static int[] color;
	static final int RED = 1, BLUE = -1;
	static String answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			answer = "YES";

			graph = new ArrayList<>();
			for (int j = 0; j < V; j++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken()) - 1;
				int to = Integer.parseInt(st.nextToken()) - 1;

				graph.get(from).add(to);
				graph.get(to).add(from);
			}

			color = new int[V];
			for (int i = 0; i < V; i++) {
				if (color[i] == 0) {
					if (!BFS(i)) {
						break;
					}
				}
			}

			System.out.println(answer);
		}
	}

	static boolean BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		color[start] = RED;

		while (!queue.isEmpty()) {
			int v = queue.poll();

			for (int to : graph.get(v)) {

				// 색상이 정해지지 않았다면
				if (color[to] == 0) {
					color[to] = (color[v] == RED) ? BLUE : RED;
					queue.add(to);
//					graph.get(v).remove(new Integer(to));
//					graph.get(to).remove(new Integer(v));
				}

				// 색상이 정해졌는데 인접 정점과 겹치면 이분 그래프가 아니지. 리턴
				else if (color[to] == color[v]) {
					answer = "NO";
					return false;
				}
			}
		}

		return true;
	}
}
