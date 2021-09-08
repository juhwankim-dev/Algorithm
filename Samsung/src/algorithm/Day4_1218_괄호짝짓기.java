package algorithm;

import java.io.*;
import java.util.*;

public class Day4_1218_괄호짝짓기 {
    static Map<Character, Character> map = new HashMap<>();
	static Stack<Character> stack = new Stack<Character>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		map.put('>', '<');
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();
			stack.clear();
			int validity = 1;
			
			for(int i=0; i<len; i++) {
				if(!addParenthese(str.charAt(i))) {
					validity = 0; // 유효성 출력
					break;
				}
			}
			
			if(!stack.isEmpty()) validity = 0;
			sb.append("#" + tc + " " + validity + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static boolean addParenthese(char ch) {
		if(map.containsKey(ch)) { // 닫는 기호라면
			if(stack.isEmpty()) return false;
			if(map.get(ch) != stack.peek()) return false;
			else {
				stack.pop();
				return true;
			}
		}
		
		stack.add(ch); // 여는 기호는 그냥 추가
		return true;
	}
}
