package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day5_1234_비밀번호 {
	static Stack<Character> stack = new Stack<Character>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder password = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			String[] str = br.readLine().split(" ");
			int len = Integer.valueOf(str[0]);
			
			for(int i=0; i<len; i++) {
				char ch = str[1].charAt(i);
				
				if(!stack.isEmpty()) {
					if(stack.peek() == ch) stack.pop();
					else stack.add(ch);
				} else {
					stack.add(ch);
				}
			}
		
			password.setLength(0);
			while(!stack.isEmpty()) {
				password.append(stack.pop());
			}
			sb.append("#").append(tc).append(" ").append(password.reverse().toString()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
