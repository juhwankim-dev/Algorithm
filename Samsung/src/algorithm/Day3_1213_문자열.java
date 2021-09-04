package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3_1213_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			br.readLine();
			
			String key = br.readLine();
			String str = br.readLine();
			int keyLen = key.length();
			int strLen = str.length();
			int cnt = 0;
			
			for (int i = 0; i <= strLen - keyLen; i++) {
				if(key.equals(str.substring(i, i + keyLen))) {
					cnt++;
				}
			}
			
			sb.append("#" + tc + " " + cnt);
			System.out.println(sb.toString());
		}
	}
}

/*
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3_1213_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			br.readLine();
			
			String key = br.readLine();
			String str = br.readLine();
			int keyLen = key.length();
			int strLen = str.length();
			int cnt = 0;
			
			for (int i = 0; i <= strLen - keyLen; i++) {
				if(key.equals(str.substring(i, i + keyLen))) {
					cnt++;
				}
			}
			
			sb.append("#" + tc + " " + cnt);
			System.out.println(sb.toString());
		}
	}
}
*/