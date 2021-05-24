package etc;

import java.util.*;

public class DartGame {

	public static void main(String[] args) {
		System.out.println(solution("1D2S#10S"));
	}

    public static int solution(String dartResult) {
        ArrayList<Integer> scoreList = new ArrayList<>();
        
        for(int i=0; i<dartResult.length(); i++){
            char input = dartResult.charAt(i);
            int size = scoreList.size();

            if(input == 'S') {
            	continue;
            } else if(Character.isDigit(input)) {
            	if(input == '1' && dartResult.charAt(i+1) == '0') {
            		scoreList.add(10);
            		i++;
            		continue;
            	}
            	scoreList.add(input - '0');
            } else {
            	int curScore = scoreList.get(scoreList.size()-1);
            	scoreList.remove(size-1);
            	
            	if(input == '*') {
            		if(size > 1) {
            			int preScore = scoreList.get(size-2);
            			scoreList.remove(size-2);
            			scoreList.add(preScore * 2);
            		}
            		scoreList.add(curScore * 2);
            	} else if(input == '#') {
            		scoreList.add(curScore * -1);
            	} else if(input == 'D') {
                	scoreList.add((int) Math.pow(curScore, 2));
            	} else if(input == 'T') {
                	scoreList.add((int) Math.pow(curScore, 3));
            	}
            }
        }
        
        int sum = 0;
        for(int score : scoreList) {
        	sum += score;
        }
        
        return sum;
    }
}
