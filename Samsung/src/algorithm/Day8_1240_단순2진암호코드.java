package algorithm;

import java.io.*;
import java.util.*;

public class Day8_1240_단순2진암호코드 {
	static HashMap<String, Integer> codeMap = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static final int CODESIZE = 7;
	static final int FULL_CODESIZE = 8;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] codes = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };

		for (int i = 0; i < codes.length; i++) {
			codeMap.put(codes[i], i);
		}
		br.readLine();

		for (int tc = 1; tc <= 10; tc++) {
			String[] input = br.readLine().split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			String[] lines = new String[row];
			sb.append("#" + tc + " ");

			for (int i = 0; i < row; i++) {
				lines[i] = br.readLine();
			}

			sb.append(scanAllLines(lines, row, col) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int scanAllLines(String[] lines, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (!lines[i].contains("1")) {
				continue; // 1이 없으면 바로 다음 줄 검사
			} else {
				for(int j = col - 1; j >= 56; j--) {
					if(lines[i].charAt(j) == '1') { // 뒤부터 읽어서 1이 나오는 첫 지점 찾기
						return scanLine(lines[i].substring(j - 55, j + 1));
					}
				}
			}
		}
		
		return 0;
	}

	public static int scanLine(String str) {
		// 2진수 암호코드를 변환 
		int[] code = new int[FULL_CODESIZE];
		for (int i = 0; i < FULL_CODESIZE; i++) {
			code[i] = codeMap.get(str.substring(i * CODESIZE, i * CODESIZE + 7));
		}

		return isVerificationCode(code);
	}

	// 검증코드가 맞는지 리턴
	public static int isVerificationCode(int[] code) {
		int oddSum = 0;
		int sum = 0;

		for (int i = 0; i < FULL_CODESIZE; i++) {
			if ((i + 1) % 2 == 0) sum += code[i]; // 짝수 인덱스
			else oddSum += code[i]; // 홀수 인덱스
		}

		if ((oddSum * 3 + sum) % 10 == 0) return oddSum + sum;
		else return 0;
	}
}

/*

import java.io.*;
import java.util.*;

public class Solution {
	static HashMap<String, Integer> codeMap = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static final int CODESIZE = 7;
	static final int FULL_CODESIZE = 8;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		codeMap.put("1011000", 0);
		codeMap.put("1001100", 1);
		codeMap.put("1100100", 2);
		codeMap.put("1011110", 3);
		codeMap.put("1100010", 4);
		codeMap.put("1000110", 5);
		codeMap.put("1111010", 6);
		codeMap.put("1101110", 7);
		codeMap.put("1110110", 8);
		codeMap.put("1101000", 9);
		br.readLine();

		for (int tc = 1; tc <= 10; tc++) {
			String[] input = br.readLine().split(" ");
			int row = Integer.parseInt(input[0]);
			int col = Integer.parseInt(input[1]);
			String[] lines = new String[row];
			sb.append("#" + tc + " ");
			
			for (int i = 0; i < row; i++) {
				lines[i] = br.readLine();
			}

			scanAllLines(lines, row, col);
		}
		System.out.println(sb.toString());
	}

	public static void scanAllLines(String[] lines, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (!lines[i].contains("1")) {
				continue; // 1이 없으면 바로 다음 줄 검사
			} else {
				StringBuilder temp = new StringBuilder(lines[i]);
				String revStr = temp.reverse().toString();
				for (int j = 0; j < col - CODESIZE * FULL_CODESIZE; j++) {
					int result = scanLine(revStr, j);
					if(result != -1) { // 스캔한 결과가 성공적이라면! (암호가 있다면)
						sb.append(result + "\n");
						return; // 스캔 종료
					}
				}
			}
		}
		
		sb.append(0 + "\n"); // 올바른 암호코드가 없는 경우
	}
	
	public static int scanLine(String str, int start) {
		// str에 암호코드 8개가 다 들어있는지 확인
		for (int i = 0; i < FULL_CODESIZE; i++) {
			int idx = start + i * CODESIZE;
			if (!isCorrectCode(str.substring(idx, idx + CODESIZE))) {
				return -1;
			}
		}
		
		// 암호코드를 숫자로 변환
		String code = "";
		for (int i = 0; i < FULL_CODESIZE; i++) {
			int idx = start + i * CODESIZE;
			code += codeMap.get(str.substring(idx, idx + CODESIZE));
		}
		StringBuilder sb = new StringBuilder(code);
	
		return isVerificationCode(sb.reverse().toString());
	}

	// str이 암호코드인지 검사해서 리턴
	public static boolean isCorrectCode(String str) {
		return codeMap.containsKey(str) ? true : false;
	}

	// 검증코드가 맞는지 리턴
	public static int isVerificationCode(String code) {
		int checkCode = code.charAt(code.length() - 1) - '0';
		int oddSum = 0;
		int sum = 0;

		for (int i = 0; i < code.length() - 1; i++) {
			if ((i + 1) % 2 == 0) // 짝수번째 인덱스
				sum += code.charAt(i) - '0';
			else // 홀수번째 인덱스
				oddSum += code.charAt(i) - '0';
		}

		if((oddSum * 3 + sum + checkCode) % 10 == 0)
			return oddSum + sum + checkCode;
		else
			return -1;
	}
}

*/