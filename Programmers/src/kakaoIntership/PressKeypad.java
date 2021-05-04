package kakaoIntership;

import java.util.*;

public class PressKeypad {

	public static void main(String[] args) {
		int[] numbers = {
				1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5
		};
		String hand = "right";
		
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int Lpos=10, Rpos=12; // ���� ��ġ
        
        for(int n : numbers) {
        	if(n==0) n=11;
        	
        	// ���� ��
        	if(n%3 == 1) {
        		sb.append("L");
        		Lpos = n;
        	}
        	
        	// ������ ��
        	else if(n%3 == 0) {
        		sb.append("R");
        		Rpos = n;
        	}
        	
        	// ��� ��
        	else {
        		int distL = Math.abs(Lpos - n);
        		distL = distL/3 + distL%3;
        		int distR = Math.abs(Rpos - n);
        		distR = distR/3 + distR%3;
        		
        		if(distL < distR) {
            		sb.append("L");
            		Lpos = n;
        		} else if(distL > distR) {
            		sb.append("R");
            		Rpos = n;
        		} else { // �Ÿ��� ���� ���
        			if(hand.equals("left")) {
                		sb.append("L");
                		Lpos = n;
        			} else if(hand.equals("right")) {
                		sb.append("R");
                		Rpos = n;
        			}
        		}
        	}
        }
        
        return sb.toString();
    }
}