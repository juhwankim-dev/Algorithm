package _18_stack;

import java.io.*;
import java.util.*;

public class _2_Zero {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		
		while(k-- > 0) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) stack.pop();
			else stack.add(n);
		}
		
		long sum=0;
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}
