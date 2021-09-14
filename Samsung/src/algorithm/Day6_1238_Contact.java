package algorithm;

import java.util.*;
import java.io.*;

public class Day6_1238_Contact {
	static final int N = 100;
	static boolean[] visited;
	public static int[][] load;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			load = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken(); // 데이터의 길이 (필요없음)
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				load[from][0]++; // 개수 증가
				load[from][load[from][0]] = to; // 다음 정점의 위치 저장
			}
			
			sb.append("#" + tc + " " + BFS(start) + "\n");
		}
		System.out.println(sb.toString());
	}
	
	public static int BFS(int from) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(from);
		visited[from] = true;
		int[] depth = new int[N + 1];
		depth[from] = 1; // 첫 시작하는 곳은 깊이가 1
		
		// 본격적인 BFS 탐색 시작
		while(!queue.isEmpty()) {
			from = queue.poll();
			
			for (int i = 1; i <= load[from][0]; i++) {
				if(!visited[load[from][i]]) {
					queue.add(load[from][i]);
					visited[load[from][i]] = true;
					depth[load[from][i]] += depth[from] + 1; // 깊이 기록
				}
			}
		}
		
		// 저장된 깊이들 중 가장 큰 값 찾기
        int idx = 1;
        for(int i=1; i<=N; i++) {
            if(depth[i] >= depth[idx]) {
                idx = i;
            }
        }
         
        return idx;
	}
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T, maxDepth;
    private static List<Integer>[] list;
    private static int[] depthArr;
    private static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws IOException {
        while (T++ < 10) {
            depthArr = new int[101];
            list = new List[101];
            for (int i = 0; i <= 100; i++) {
                list[i] = new ArrayList<>();
            }
 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < len / 2; i++) {
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                list[v1].add(v2);
            }
 
            maxDepth = 0;
            bfs(start);
            int ans = 0;
            for (int i = 100; i > 0; i--) {
                if (depthArr[i] == maxDepth) {
                    ans = i;
                    break;
                }
            }
            sb.append("#").append(T).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
 
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        depthArr[start] = 1;
 
        while (!q.isEmpty()) {
            int cur = q.poll();
 
            for (int item : list[cur]) {
                if (depthArr[item] != 0) continue;
                depthArr[item] = depthArr[cur] + 1;
                maxDepth = Math.max(maxDepth, depthArr[item]);
                q.add(item);
            }
        }
    }
}
*/