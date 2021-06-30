package _08_math;

import java.util.*;

public class BigNumberAB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		String sum = plusVeryLongNumber(str[0], str[1], 0);
		System.out.println(sum);
	}
	
	public static String plusVeryLongNumber(String s1, String s2, int lift) {
		if(s1.isEmpty() && s2.isEmpty()) {
			return "";
		}
		
		int len1 = s1.length();
		int len2 = s2.length();
		int pos1 = (len1 < 9) ? 0 : len1 - 9;
		int pos2 = (len2 < 9) ? 0 : len2 - 9;
		String n1 = s1.substring(pos1, len1);
		String n2 = s2.substring(pos2, len2);
		
		long sum = Long.valueOf(n1) + Long.valueOf(n2) + lift;
		String s3 = String.valueOf(sum);
		
		if(s3.length() < 10) {
			return plusVeryLongNumber(s1.substring(0, pos1), s2.substring(0, pos2), 0) + s3;
		} else {
			lift = s3.charAt(0) - '0';
			return plusVeryLongNumber(s1.substring(0, pos1), s2.substring(0, pos2), lift) + s3.substring(1, s3.length());
		}
	}
}
