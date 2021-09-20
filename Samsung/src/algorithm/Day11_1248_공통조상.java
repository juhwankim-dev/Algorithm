package algorithm;

import java.io.*;
import java.util.*;

public class Day11_1248_공통조상 {
	static ArrayList<Integer> parentList;
	static int[][] tree;
	static int ancestor;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			tree = new int[V + 1][3];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				// 부모에게 자식 할당(?)하기
				if(tree[parent][1] == 0)
					tree[parent][1] = child;
				else
					tree[parent][2] = child;
				
				// 자식에게 부모 할당하기
				tree[child][0] = parent;
			}
			
			parentList = new ArrayList<>();
			exploreAncestor(tree[n1][0], tree[n2][0]);
			System.out.println("#" + tc + " " + ancestor + " " + dfs(ancestor));
		}
	}

	// 공통 조상 찾기
	public static void exploreAncestor (int p1, int p2) {
		if(p1 != 0 && parentList.contains(p1)) {
			ancestor = p1;
			return;
		} else if( (p2 != 0 && parentList.contains(p2)) || p1 == p2) {
			ancestor = p2;
			return;
		}
		
		parentList.add(p1);
		parentList.add(p2);
		exploreAncestor(tree[p1][0], tree[p2][0]);
	}
	
	// 서브 트리 크기 알아내기
	public static int dfs(int cur) {
		int size = 0;
		
		if(tree[cur][1] != 0) 
			size += dfs(tree[cur][1]);
		
		if(tree[cur][2] != 0)
			size += dfs(tree[cur][2]);
		
		return size + 1;
	}
}
