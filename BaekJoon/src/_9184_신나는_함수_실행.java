package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9184_신나는_함수_실행 {
	static HashMap<String, Integer> hs = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int a = 0, b = 0, c = 0;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1) {
				break;
			}
			
			sb.append("w(").append(a).append(", ").append(b).append(", ")
			.append(c).append(") = ").append(w(a, b, c)).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static int w(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(",").append(b).append(",").append(c);
		String str = sb.toString();
		int sum;
		
		if(hs.containsKey(str)) {
			return hs.get(str);
		}
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		
		if(a < b && b < c) {
			sum = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}
		
		else {
			sum = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		}

		hs.put(str, sum);
		return sum;
	}
}
