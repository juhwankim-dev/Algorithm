package _18_stack;

import java.util.*;

public class _5_StackProgression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] seque = new int[n];
		for(int i=0; i<n; i++) {
			seque[i] = sc.nextInt();
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int cursor = 0;
		for(int i=1; i<=n; i++) {
			stack.add(i);
			sb.append("+\n");
			
			while(!stack.isEmpty() && seque[cursor] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
				cursor++;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
