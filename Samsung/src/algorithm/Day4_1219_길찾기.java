package algorithm;

import java.io.*;
import java.util.*;

public class Day4_1219_길찾기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			st.nextToken(); // 테스트케이스는 따로 입력받지 않았음
			int N = Integer.parseInt(st.nextToken());
			int[][] load = new int[N][2];
			
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int idx = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());

				if (load[idx][0] == 0) load[idx][0] = val;
				else load[idx][1] = val;
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			stack.add(0); // 출발지점
			int result = 1;
			int preNode = 0;
			int nextNode;
			
			while(true) {
				if(stack.isEmpty()) {
					result = 0;
					break; // 길이 없다면 길찾기 종료
				}
				int curNode = stack.peek();
				
				// 첫 번째 길이 있는 경우 | 두 번째 길이 있는 경우 | 길이 없는 경우
				if(load[curNode][0] > 0) {
					nextNode = load[curNode][0];
				}
				else if(load[curNode][1] > 0) {
					nextNode = load[curNode][1];
				}
				else {
					if(load[preNode][0] == curNode) {
						load[preNode][0] = 0;
					}
					else {
						load[preNode][1] = 0;
					}
					stack.pop(); // pop하고
					continue; // 이전길로 돌아가
				}
				
				if(nextNode == 99) break; // 도착한 경우
				preNode = curNode; // 이전 노드 위치 저장
				stack.add(nextNode); // 다음 노드로 이동
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

// 재귀를 이용한 DFS 답
//package algorithm;
//
//import java.io.*;
//import java.util.*;
//
//public class Day4_1219_길찾기 {
//	static int[][] load;
//	static int answer;
//	public static void main(String args[]) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//
//		for (int tc = 1; tc <= 10; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//			st.nextToken(); // 테스트케이스는 따로 입력받지 않았음
//			int N = Integer.parseInt(st.nextToken());
//			load = new int[N][2];
//
//			st = new StringTokenizer(br.readLine(), " ");
//			while (st.hasMoreTokens()) {
//				int idx = Integer.parseInt(st.nextToken());
//				int val = Integer.parseInt(st.nextToken());
//
//				if (load[idx][0] == 0) load[idx][0] = val;
//				else load[idx][1] = val;
//			}
//
//			answer = 0;
//			dfs(0);
//			
//			sb.append("#").append(tc).append(" ").append(answer).append("\n");
//		}
//		System.out.println(sb.toString());
//	}
//	
//	public static void dfs(int cur) {
//		if(answer == 1 || cur == 0) return; // 도착지를 이미 찾았거나 길이 없다면
//		
//		if(cur == 99) { // 원하는 도착지에 도착하면
//			answer = 1;
//			return;
//		}
//		
//		dfs(load[cur][0]); // 왼쪽 길 탐색
//		dfs(load[cur][1]); // 오른쪽 길 탐색
//	}
//}