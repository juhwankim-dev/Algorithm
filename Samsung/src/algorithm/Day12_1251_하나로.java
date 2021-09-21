package algorithm;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day12_1251_하나로 {
	static int N;
	static double[][] env;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st1, st2;

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] xy = new int[N][2]; // 섬들의 좌표
			env = new double[N][N]; // 환경부담금
			
			// x, y 좌표 입력 받아서 정리
			st1 = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(br.readLine());
			for(int i=0; i<N; i++) {
				xy[i][0] = Integer.parseInt(st1.nextToken());
				xy[i][1] = Integer.parseInt(st2.nextToken());
			}
			
			// 거리를 구해서 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double L = Math.pow(xy[i][0] - xy[j][0], 2) + Math.pow(xy[i][1] - xy[j][1], 2);
					env[i][j] = L * E;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(kruskal())).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
	
	public static double kruskal() {
		boolean[] visited = new boolean[N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		int cnt = 0;
		double result = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(visited[node.index]) {
				continue;
			}
			
			cnt++;
			result += node.weights;
			visited[node.index] = true;
			
			if(cnt == N) {
				return result;
			}
			
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					pq.add(new Node(i, env[node.index][i]));
				}
			}
		}
		
		return -1;
	}

}

class Node implements Comparable<Node> {
	int index;
	double weights;

	public Node(int index, double weights) {
		this.index = index;
		this.weights = weights;
	}

	@Override
	public int compareTo(Node o) {
		if(this.weights < o.weights) {
			return -1;
		}
		return 1;
	}
}