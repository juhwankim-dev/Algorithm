package selfmade;

import java.util.*;

public class 직접만든문제_산타클로스는_바빠 {
	// 각 노드의 부모
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<Edge> graph = new ArrayList<>(); // '1'과 연결되지 않은 간선들
		ArrayList<Edge> graph2 = new ArrayList<>(); // '1'과 연결된 간선들

		// 그래프의 연결상태(노드1, 노드2, 비용)를 초기화.
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int dist = sc.nextInt();

			if (from == 1 || to == 1) {
				graph2.add(new Edge(from, to, dist));
			} else {
				graph.add(new Edge(from, to, dist));
			}
		}
		parent = new int[V];
		int final_cost = 0; // 최종적으로 연결된 최소 신장 트리 연결 비용.

		// 간선 비용 순으로 오름차순 정렬
		Collections.sort(graph, (o1, o2) -> Integer.compare(o1.distance, o2.distance));
		Collections.sort(graph2, (o1, o2) -> Integer.compare(o1.distance, o2.distance));
		graph.add(0, graph2.get(0));

		// makeSet
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		// 낮은 비용부터 크루스칼 알고리즘 진행
		for (int i = 0; i < graph.size(); i++) {
			// 사이클이 존재하지 않는 경우에만 간선을 선택한다(여기서는 최종 비용만 고려하도록 하겠다).
			if (find(graph.get(i).from - 1) != find(graph.get(i).to - 1)) {
				union(graph.get(i).from - 1, graph.get(i).to - 1);
				final_cost += graph.get(i).distance;
			}
		}

		System.out.println("최종 비용 : " + final_cost);
		sc.close();
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	private static int find(int x) {
		if (parent[x] == x)
			return x;
		else
			return find(parent[x]);
	}
}

//간선 클래스 선언
class Edge {
	int from, to;
	int distance;

	public Edge(int from, int to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
}

//곧 크리스마스가 다가온다.
//산타클로스는 올해도 어린이들에게 선물을 나눠줄 예정이다.
//만약 선물을 나눠주러 다니다가 날이 밝으면 어린이들에게 정체를 들키고 만다! (저런!)
//어린이들의 꿈과 희망을 지켜주기 위해서 산타클로스는 최대한 빨리 모든 집을 방문하려고 한다.
//산타클로스를 위해 최소 소요시간을 구하는 프로그램을 작성해주자.
//
//[제약 사항]
//1번 집은 산타클로스의 집이며, 무조건 1번 집에서 출발한다.
//
//[입력]
//맨 첫 줄에는 방문해야 할 집의 수 V와 집과 집 사이를 이동할 수 있는 길의 수 E가 입력된다.
//이후 E개의 길 정보가 연달아 입력된다.
//길의 정보는 출발지 from, 도착지 to, 이동 소요시간 dist가 입력된다.
//
//[출력]
//1번 집에서 시작하여 모든 집을 방문하는 데 걸리는 최소 소요 시간을 출력한다.
//
//[샘플 데이터]
//		7 11
//		1 7 12
//		1 4 28
//		1 2 67
//		1 5 17
//		2 4 24
//		2 5 62
//		3 5 20
//		3 6 37
//		4 7 13
//		5 6 45
//		5 7 73