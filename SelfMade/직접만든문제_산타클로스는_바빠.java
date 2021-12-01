package selfmade;

import java.util.*;

public class �������繮��_��ŸŬ�ν���_�ٺ� {
	// �� ����� �θ�
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<Edge> graph = new ArrayList<>(); // '1'�� ������� ���� ������
		ArrayList<Edge> graph2 = new ArrayList<>(); // '1'�� ����� ������

		// �׷����� �������(���1, ���2, ���)�� �ʱ�ȭ.
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
		int final_cost = 0; // ���������� ����� �ּ� ���� Ʈ�� ���� ���.

		// ���� ��� ������ �������� ����
		Collections.sort(graph, (o1, o2) -> Integer.compare(o1.distance, o2.distance));
		Collections.sort(graph2, (o1, o2) -> Integer.compare(o1.distance, o2.distance));
		graph.add(0, graph2.get(0));

		// makeSet
		for (int i = 0; i < V; i++) {
			parent[i] = i;
		}

		// ���� ������ ũ�罺Į �˰��� ����
		for (int i = 0; i < graph.size(); i++) {
			// ����Ŭ�� �������� �ʴ� ��쿡�� ������ �����Ѵ�(���⼭�� ���� ��븸 ����ϵ��� �ϰڴ�).
			if (find(graph.get(i).from - 1) != find(graph.get(i).to - 1)) {
				union(graph.get(i).from - 1, graph.get(i).to - 1);
				final_cost += graph.get(i).distance;
			}
		}

		System.out.println("���� ��� : " + final_cost);
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

//���� Ŭ���� ����
class Edge {
	int from, to;
	int distance;

	public Edge(int from, int to, int distance) {
		this.from = from;
		this.to = to;
		this.distance = distance;
	}
}

//�� ũ���������� �ٰ��´�.
//��ŸŬ�ν��� ���ص� ��̵鿡�� ������ ������ �����̴�.
//���� ������ �����ַ� �ٴϴٰ� ���� ������ ��̵鿡�� ��ü�� ��Ű�� ����! (����!)
//��̵��� �ް� ����� �����ֱ� ���ؼ� ��ŸŬ�ν��� �ִ��� ���� ��� ���� �湮�Ϸ��� �Ѵ�.
//��ŸŬ�ν��� ���� �ּ� �ҿ�ð��� ���ϴ� ���α׷��� �ۼ�������.
//
//[���� ����]
//1�� ���� ��ŸŬ�ν��� ���̸�, ������ 1�� ������ ����Ѵ�.
//
//[�Է�]
//�� ù �ٿ��� �湮�ؾ� �� ���� �� V�� ���� �� ���̸� �̵��� �� �ִ� ���� �� E�� �Էµȴ�.
//���� E���� �� ������ ���޾� �Էµȴ�.
//���� ������ ����� from, ������ to, �̵� �ҿ�ð� dist�� �Էµȴ�.
//
//[���]
//1�� ������ �����Ͽ� ��� ���� �湮�ϴ� �� �ɸ��� �ּ� �ҿ� �ð��� ����Ѵ�.
//
//[���� ������]
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