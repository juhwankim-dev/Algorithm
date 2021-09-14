package algorithm;

import java.io.*;
import java.util.*;

public class Day7_1232_사칙연산 {
	static String[][] arr;
	static int size;
	static ArrayList<String> postfix = new ArrayList<>();
	
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
				
				if(isOperator(data)) {
					arr[idx][1] = st.nextToken();
					arr[idx][2] = st.nextToken();
				}
			}
			
			postOrder(1);
			System.out.println("#" + tc + " " + calPostfix());
		}
	}

	public static void postOrder(int current) {
		if (current > size) {
			return;
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
		
		// 자기 자신 추가
		postfix.add(arr[current][0]);
	}
	
	public static boolean isOperator(String str) {
		try {
			Integer.parseInt(str);
			return false;
		} catch(Exception e) {
			return true;
		}
	}
	
	public static int calPostfix() {
		Stack<Integer> numStack = new Stack<>();
		
		for(String str : postfix) {
			if(isOperator(str)) {
				int right = numStack.pop();
				int left = numStack.pop();
				numStack.add(calculate(left, right, str));
			} else {
				numStack.add(Integer.parseInt(str));
			}
		}
		
		return numStack.pop();
	}
	
	public static int calculate(int a, int b, String op) {
		switch(op) {
		case "+": return a + b;
		case "-": return a - b; 
		case "*": return a * b;
		default: return a / b;
		}
	}
}
