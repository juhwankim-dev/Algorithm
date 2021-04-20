package stackQueue;

import java.util.*;

public class _3_FuntionalDevelopment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] day = new int[len];
        
        int max=0;
        int answerLen=0;
        for(int i=0; i<len; i++) {
        	day[i] = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);
        	if(day[i] > max) {
        		max = day[i];
        		answerLen++;
        	}
        }
        
        int[] answer = new int[answerLen];
        Stack<Integer> stack = new Stack<>();
        int bottomNum = day[0];
        int i=0;
        for(int d : day) {
        	if(!stack.isEmpty() && bottomNum < d) {
        		answer[i++] = stack.size();
        		stack.clear();
        		bottomNum = d;
        	}
        	stack.push(d);
        }
        answer[answerLen-1] = stack.size();
        
        return answer;
    }
}

// 처음에 작업이 뭔가 순서대로 끝나니까 큐를 써야한다고 생각하고 짜다가 스택이 더 편하다는 걸 깨닫고 급 바꿈
// 분모에 (double)을 적어주어야 하는 건 상상도못했다. 한참을 고민햇네..
// day의 크기를 구하는 부분이 너무 불필요해보인다..
// 나한테 쉬운문제는 다른 사람한테도 쉽구나...