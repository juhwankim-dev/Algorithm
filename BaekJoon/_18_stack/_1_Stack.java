package _18_stack;

import java.io.*;
import java.util.*;

public class _1_Stack {
	public static String[] stack;
	public static int index = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stack = new String[N];
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			
			switch(command) {
			case "push":
				push(st.nextToken());
				break;
			case "pop":
				System.out.println(pop());
				break;
			case "size":
				System.out.println(index);
				break;
			case "empty":
				System.out.println(empty());
				break;
			case "top":
				System.out.println(top());
				break;
			}
		}
	}
	
	public static void push(String num) {
		stack[index++] = num;
	}
	
	public static String pop() {
		String temp = top();
		
		if(temp != "-1") {
			index--;
		}

		return temp;
	}
	
	public static int empty() {
		if(index == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static String top() {
		String temp = "-1";
		
		if(index > 0) {
			temp = stack[index-1];
		}
		
		return temp;
	}
}
