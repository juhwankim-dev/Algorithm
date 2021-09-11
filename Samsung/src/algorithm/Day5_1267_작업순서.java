package algorithm;

import java.io.*;
import java.util.*;

// 노드와 노드에 이어진 간선의 정보가 input에 없는 노드가 있다는 게 이 문제의 함정이다.
// 예를 들어 6번 input의 경우 119번 노드에 대한 어떠한 정보도 input에 주어지지 않는다.
// 즉, 어느 노드와도 연결되어 있지 않으며 어느 순서에 포함되도 상관 없다는 뜻이다.
// 하지만 순서에 포함 되지 않으면 이는 틀린것이 된다. 쓰바...

public class Day5_1267_작업순서 {
	static StringBuilder sb = new StringBuilder();
	static int[][] load;
	static boolean[] visited;
	static int V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc);
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			st.nextToken(); // E
			load = new int[V + 1][V + 1];
			visited = new boolean[V + 1];

			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				load[to][0]++; // 연결된 정점의 개수 카운트 (+1)
				load[to][load[to][0]] = from;
			}

			for (int i = 1; i <= V; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int from) {
		for (int to = 1; to <= load[from][0]; to++) {
			if (!visited[load[from][to]]) {
				dfs(load[from][to]);
			}
		}

		visited[from] = true;
		sb.append(" " + from);
	}
}

//package algorithm;
//
//import java.io.*;
//import java.util.*;
//
//// 노드와 노드에 이어진 간선의 정보가 input에 없는 노드가 있다는 게 이 문제의 함정이다.
//// 예를 들어 6번 input의 경우 119번 노드에 대한 어떠한 정보도 input에 주어지지 않는다.
//// 즉, 어느 노드와도 연결되어 있지 않으며 어느 순서에 포함되도 상관 없다는 뜻이다.
//// 하지만 순서에 포함 되지 않으면 이는 틀린것이 된다. 쓰바...
//
//public class Day5_1267_작업순서 {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		HashMap<Integer, Edge> edges = new HashMap<>();
//
//		for (int tc = 1; tc <= 10; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			int V = Integer.parseInt(st.nextToken());
//			st.nextToken(); // E
//			
//			st = new StringTokenizer(br.readLine(), " ");
//			while (st.hasMoreTokens()) {
//				int cur = Integer.parseInt(st.nextToken());
//				int next = Integer.parseInt(st.nextToken());
//				
//				if(!edges.containsKey(cur)) edges.put(cur, new Edge());
//				if(!edges.containsKey(next)) edges.put(next, new Edge());
//				
//				edges.get(cur).output.add(next);
//				edges.get(next).input.add(cur);
//			}
//			
//			sb.append("#" + tc);
//			for(int i=1; i<=V; i++) { // 간선이 존재하지 않는 애들부터 먼저 다 방문
//				if(!edges.containsKey(i)) {
//					sb.append(" " + i);
//				}
//			}
//			
//			while(edges.size() > 0) { // 모든 노드(정점)을 다 찾을때 까지
//				for(int node : edges.keySet()) { // 존재하는 노드들을 하나씩 검사
//					Edge edge = edges.get(node);
//					
//					// input은 없는데 output이 있는 노드
//					if(edge.input.isEmpty()) {
//						// 현재 노드가 input으로 들어오는 노드들 삭제 (간선 제거)
//						for(int out : edge.output) {
//							edges.get(out).input.remove((Integer)node);
//						}
//						
//						// 현재 노드 삭제
//						edges.remove(node);
//						sb.append(" " + node);
//						break;
//					}
//				}
//			}
//			
//			// 출력
//			sb.append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//}
//
//class Edge {
//	ArrayList<Integer> input = new ArrayList<>();
//	ArrayList<Integer> output = new ArrayList<>();
//}