package codeChallenge;

import java.util.*;

public class RepeatBinary {

	public static void main(String[] args) {
		int[] answer = solution("110010101001");
		
		for(int a : answer) {
			System.out.println(a);
		}
	}

    public static int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeros = 0;
        int transCnt = 0;
        
        while(!s.equals("1")) {
        	int len = s.length();
        	s = s.replace("0", "");
        	zeros += len - s.length();
        	
        	s = Integer.toBinaryString(s.length());
        	transCnt++;
        }
        
        answer[0] = transCnt;
        answer[1] = zeros;
        return answer;
    }
}
