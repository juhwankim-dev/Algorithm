package bruteForce;

import java.util.*;

public class _4_Carpet {

	public static void main(String[] args) {
		int[] answer = new int[2];
		
		answer = solution(10, 2);
		for(int a : answer) {
			System.out.println(a);
		}
	}

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int heightMax = (int) Math.ceil((double)yellow/2);
        for(int i=1; i<=heightMax; i++) {
        	if(yellow%i == 0) {
        		int w = yellow/i;
        		int carpetW = w+2;
        		int carpetH = i+2;
        		
        		if(carpetW*carpetH - i*w == brown) {
        			answer[0] = carpetW;
        			answer[1] = carpetH;
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
