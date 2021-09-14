package algorithm;

import java.io.*;
import java.util.*;

public class Day7_1233_사칙연산유효성검사 {
	static String[][] arr;
	static int size;
	static boolean isCorrect = true;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			size = Integer.parseInt(br.readLine());
			arr = new String[size + 1][3]; // 데이터, 왼쪽 자식 노드, 오른쪽 자식 노드
			
			for(int i=1; i<=size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int idx = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				arr[idx][0] = data;
				
				if(st.hasMoreTokens()) arr[idx][1] = st.nextToken();
				if(st.hasMoreTokens()) arr[idx][2] = st.nextToken();
			}
			
			isCorrect = true;
			postOrder(1);
			int answer = isCorrect ? 1 : 0;
			System.out.println("#" + tc + " " + answer);
		}
	}

	public static void postOrder(int current) {
		if (!isCorrect || current > size) {
			return;
		}
		
		// 연산자라면 자식 노드가 2개는 있어야지!
		if(isOperator(arr[current][0])) {
			if(arr[current][1] == null || arr[current][2] == null) {
				isCorrect = false;
				return;
			}
		}
		
		// 숫자라면 자식 노드가 없어야지!
		if(!isOperator(arr[current][0])) {
			if(arr[current][1] != null || arr[current][2] != null) {
				isCorrect = false;
				return;
			}
		}
		
		// 왼쪽노드가 존재한다면 탐색
		if(arr[current][1] != null) {
			int left = Integer.parseInt(arr[current][1]);
			postOrder(left);
		}
		
		// 오른쪽 노드가 존재한다면 탐색
		if(arr[current][2] != null) {
			int right = Integer.parseInt(arr[current][2]);
			postOrder(right);
		}
		
		return;
	}
	
	public static boolean isOperator(String str) {
		try {
			Integer.parseInt(str);
			return false;
		} catch(Exception e) {
			return true;
		}
	}
}