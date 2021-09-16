package algorithm;

import java.io.*;
import java.util.*;

public class Day8_1242_암호코드스캔 {
	static HashMap<String, Integer> codeMap = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	static final int CODESIZE = 7;
	static final int FULL_CODESIZE = 8;
	static String[] codeRates = { "3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112" };
	static HashMap<String, String> hexToBin = new HashMap<>();
	static int minRate; // 암호 코드의 비율 배수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] codes = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
		test();
		for (int i = 0; i < codes.length; i++) {
			codeMap.put(codes[i], i);
		}
		br.readLine();

		for (int tc = 1; tc <= 20; tc++) {
			String[] input = br.readLine().split(" ");
			int row = Integer.parseInt(input[0]);
			ArrayList<String> lines = new ArrayList<>();

			for (int i = 0; i < row; i++) {
				String str = br.readLine();
				if (!lines.contains(str)) { // 중복 제거
					lines.add(str);
				}
			}

			sb.append("#" + tc + " ");
			sb.append(scanAllLines(lines, row) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int scanAllLines(ArrayList<String> lines, int row) {
		int sumOfCodes = 0;
		
		for (String line : lines) {
			String binaryLine = hexToBinary(line);
			
			loop: for (int j = binaryLine.length() - 1; j >= 55; j--) {
				if (binaryLine.charAt(j) == '1') { // 뒤부터 읽어서 1이 나오는 첫 지점 찾기
					for(int k = 1; k * 56 <= binaryLine.length(); k++) {
						if (isCorrectCode(binaryLine.substring(j - k * CODESIZE + 1, j + 1))) {
							int temp = scanLine(binaryLine.substring(j - k * 56 + 1, j + 1));
							sumOfCodes += temp;
							break loop;
						}
					}
				}
			}	
		}

		return sumOfCodes;
	}

	public static String hexToBinary(String str) {
		String binary = "";
		for(int i=0; i<str.length(); i++) {
			binary += hexToBin.get(Character.toString(str.charAt(i)));
		}
		return binary;
	}

	public static boolean isCorrectCode(String str) {
		int[] rate = { 1, 0, 0, 0 };
		int order = 0;

		// 비율 구하기
		for (int i = 1; i < str.length(); i++) {
			char pre = str.charAt(i - 1);
			char cur = str.charAt(i);

			if (pre != cur) order++;
			
			if(order >= 4) return false;
			else rate[order]++;
		}

		// 최소값 찾기
		minRate = Integer.MAX_VALUE;
		for (int r : rate) {
			if(r != 0) {
				minRate = Math.min(r, minRate);
			}
		}

		// 비율 맞춰서 문자열로 바꾸기
		String strRate = "";
		for (int i = 0; i < rate.length; i++) {
			strRate += rate[i] / minRate;
		}

		for (String codeRate : codeRates) {
			if (codeRate.equals(strRate)) {
				return true;
			}
		}
		return false;
	}

	public static int scanLine(String str) {
		StringBuilder sb = new StringBuilder(str.length() / minRate);

		for (int i = 0; i < str.length(); i += minRate) {
			sb.append(str.charAt(i));
		}
		str = sb.toString();

		// 2진수 암호코드를 변환
		int[] code = new int[FULL_CODESIZE];
		for (int i = 0; i < FULL_CODESIZE; i++) {
			//System.out.println(str.substring(i * CODESIZE, i * CODESIZE + 7));
			code[i] = codeMap.get(str.substring(i * CODESIZE, i * CODESIZE + 7));
		}

		return isVerificationCode(code);
	}

	// 검증코드가 맞는지 리턴
	public static int isVerificationCode(int[] code) {
		int oddSum = 0;
		int sum = 0;

		for (int i = 0; i < FULL_CODESIZE; i++) {
			if ((i + 1) % 2 == 0)
				sum += code[i]; // 짝수 인덱스
			else
				oddSum += code[i]; // 홀수 인덱스
		}

		if ((oddSum * 3 + sum) % 10 == 0)
			return oddSum + sum;
		else
			return 0;
	}
	
	public static void test () {
		hexToBin.put("0", "0000");
		hexToBin.put("1", "0001");
		hexToBin.put("2", "0010");
		hexToBin.put("3", "0011");
		hexToBin.put("4", "0100");
		hexToBin.put("5", "0101");
		hexToBin.put("6", "0110");
		hexToBin.put("7", "0111");
		hexToBin.put("8", "1000");
		hexToBin.put("9", "1001");
		hexToBin.put("A", "1010");
		hexToBin.put("B", "1011");
		hexToBin.put("C", "1100");
		hexToBin.put("D", "1101");
		hexToBin.put("E", "1110");
		hexToBin.put("F", "1111");
	}
}
