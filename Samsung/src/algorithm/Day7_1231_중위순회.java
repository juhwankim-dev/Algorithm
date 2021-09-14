package algorithm;

import java.io.*;
import java.util.*;

// 어라 stringbuilder 쓴게 왜 더 느리지
// 어라 왜 " " + " " + 이거보다 append가 더 느리지...
// 밑에 주석으로 감싸둔 코드가 제일 낫네...
public class Day7_1231_중위순회 {
	static char[] arr;
	static int size;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			size = Integer.parseInt(br.readLine());
			arr = new char[size + 1];

			for(int i=1; i<=size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				arr[i] = st.nextToken().charAt(0);
			}

			sb.append('#').append(tc).append(' ');
			inOrder(1);
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	public static void inOrder(int current) {
		if (current > size) {
			return;
		}
		
		inOrder(current * 2); // left
		sb.append(arr[current]);
		inOrder(current * 2 + 1); // right
	}
}

/*

package algorithm;

import java.io.*;
import java.util.*;

public class Day7_1231_중위순회 {
	static char[] arr;
	static int size;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			size = Integer.parseInt(br.readLine());
			arr = new char[size + 1];
			
			for(int i=1; i<=size; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				st.nextToken();
				arr[i] = st.nextToken().charAt(0);
			}

			System.out.println("#" + tc + " " + inOrder(1));
		}
	}

	public static String inOrder(int current) {
		if (current > size) {
			return "";
		}
		
		int left = current * 2;
		int right = current * 2 + 1;
		
		return inOrder(left) + arr[current] + inOrder(right);
	}
}

*/