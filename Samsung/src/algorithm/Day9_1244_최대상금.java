package algorithm;

import java.io.*;

// 21 1 이거 결과 0으로 나오면 테스트케이스 다맞아도 통과안됨 ㅡㅡ 히든 있나봄 그지같네
// 무조건 큰수 앞으로 가져오는거 안통함 잘못된 알고리즘임
// 10번 테스트케이스 결과가 안나오면 조오ㅗㅗㅗㅗㅗㅗ올라 실행시간이 오래걸려서 그런거임
// 10번비교하는걸 강제로 낮추는 방법을 썼는데 제대로된 방법이 아니라는 의견이있음

public class Day9_1244_최대상금 {
	static int[] num;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(84);
		br.readLine();
		
		for (int tc = 1; tc <= 10; tc++) {
			String[] input = br.readLine().split(" ");
			int len = input[0].length();
			num = new int[len];
			for(int i=0; i<len; i++) {
				num[i] = input[0].charAt(i) - '0';
			}
			
			answer = 0;
			int moves = Integer.parseInt(input[1]);
			moves = moves > len ? len : moves;
			dfs(0, moves);

			if(answer == 0) {
				if(moves % 2 == 1) {
					swap(num.length-2, num.length-1);
				}
				answer = arrayToInt();
			}
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	// 모든 경우의 수 만들기
	public static void dfs(int k, int moves) {
		if (moves == 0) {
			answer = Math.max(answer, arrayToInt());
			return;
		}

		for (int i = k; i < num.length - 1; i++) {
			for(int j = i + 1; j < num.length; j++) {
				if(num[i] <= num[j]) {
					swap(i, j);
					dfs(k, moves - 1);
					swap(i, j);
				}
			}
		}
	}
	
	// 최대값이 입력한 num과 같다면 더이상 탐색하지말고 빠져나가는거 해봐야할듯
	public static void swap(int a, int b) {
		int temp = num[a];
		num[a] = num[b];
		num[b] = temp;
	}
	
	public static int arrayToInt() {
		String temp = "";
		for(int n : num) {
			temp += n;
		}
		return Integer.parseInt(temp);
	}
}

/*
 * 
 * package algorithm;
 * 
 * import java.io.*; import java.util.*;
 * 
 * public class Day9_1244_최대상금 { static HashSet<String> set = new HashSet<>();
 * static boolean[] used;
 * 
 * public static void main(String[] args) throws IOException { BufferedReader br
 * = new BufferedReader(new InputStreamReader(System.in)); // br.readLine();
 * 
 * for (int tc = 1; tc <= 1; tc++) { String[] input = br.readLine().split(" ");
 * char[] num = new char[input[0].length()]; used = new
 * boolean[input[0].length()]; for (int i = 0; i < num.length; i++) { num[i] =
 * input[0].charAt(i); }
 * 
 * set.clear(); dfs(num, ""); int change = Integer.parseInt(input[1]);
 * PriorityQueue<String> answer = new
 * PriorityQueue<>(Collections.reverseOrder());
 * 
 * for (String s : set) { // 몇자리가 다른지 카운트 int cnt = 0; for (int i = 0; i <
 * num.length; i++) { if(num[i] == s.charAt(i)) { cnt++; } }
 * 
 * // 주어진 교환 횟수와 동일하다면 if(cnt == change) { answer.add(s); } }
 * 
 * System.out.println(answer.poll()); } }
 * 
 * // 모든 경우의 수 만들기 public static void dfs(char[] num, String str) { if
 * (str.length() == num.length) { set.add(str); }
 * 
 * for (int i = 0; i < num.length; i++) { if (!used[i]) { used[i] = true;
 * dfs(num, str + num[i]); used[i] = false; } } } }
 * 
 */

/*
 * package algorithm;
 * 
 * import java.io.*; import java.util.*;
 * 
 * public class Day9_1244_최대상금 { public static void main(String[] args) throws
 * IOException { BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in)); // br.readLine();
 * 
 * for (int tc = 1; tc <= 1; tc++) { String[] input = br.readLine().split(" ");
 * int len = input[0].length(); int cnt = Integer.parseInt(input[1]); char[] num
 * = new char[len]; for (int i = 0; i < len; i++) { num[i] = input[0].charAt(i);
 * }
 * 
 * int minIdx = 0; int maxIdx = len - 1;
 * 
 * while (cnt-- > 0) { for (int i = 0; i < len; i++) { if (num[minIdx] > num[i])
 * minIdx = i; if (num[maxIdx] < num[len - 1 - i]) maxIdx = i; }
 * 
 * if (isBiggerThanBefore(num, minIdx, maxIdx)) { swap(num, minIdx, maxIdx); }
 * else { maxIdx = (minIdx == len - 1) ? len - 2 : len - 1; for (int i = len -
 * 1; i >= 0; i--) { if (num[maxIdx] > num[i]) maxIdx = i; }
 * 
 * swap(num, minIdx, maxIdx); } }
 * 
 * for(int n : num) { System.out.print(n - '0'); } } }
 * 
 * public static boolean isBiggerThanBefore(char[] num, int minIdx, int maxIdx)
 * { char[] newNum = num.clone(); swap(newNum, minIdx, maxIdx);
 * 
 * for (int i = 0; i < num.length; i++) { if (newNum[i] > num[i]) return true; }
 * 
 * return false; }
 * 
 * public static void swap(char[] arr, int idx1, int idx2) { char temp =
 * arr[idx1]; arr[idx1] = arr[idx2]; arr[idx2] = temp; } }
 */