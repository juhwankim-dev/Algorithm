package bruteForce;

import java.util.*;

public class _1_Test {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println(solution(answers));
	}

	public static int[] solution(int[] answers) {
        int cntQue = answers.length;
        int[][] student = {
            {1, 2, 3, 4, 5},
            {2, 1 ,2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] reward = new int[3];
        for(int i=0; i<cntQue; i++){
        	if(student[0][i%5] == answers[i]) reward[0]++;
        	if(student[1][i%8] == answers[i]) reward[1]++;
        	if(student[2][i%10] == answers[i]) reward[2]++;
        }
        
        int max = Math.max(reward[0], reward[1]);
        max = Math.max(reward[1], reward[2]);
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<3; i++) {
        	if(reward[i] > max) arr.add(i+1);
        }
        
        int size = arr.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++) {
        	answer[i] = arr.get(i);
        }
        
        return answer;
    }
}
