package _18_stack;

import java.io.*;
import java.util.*;

public class _3_Parentheses {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<Character>();
		
		while(t-- > 0) {
			String s = br.readLine();
			int len = s.length();
			
			while(len-- > 0) {
				char c = s.charAt(len);
				if(c == '(' && !stack.isEmpty() && stack.peek() == ')') {
					stack.pop();
				} else {
					stack.add(c);
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
				stack.clear();
			}
		}
	}
}
