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

// ó���� �۾��� ���� ������� �����ϱ� ť�� ����Ѵٰ� �����ϰ� ¥�ٰ� ������ �� ���ϴٴ� �� ���ݰ� �� �ٲ�
// �и� (double)�� �����־�� �ϴ� �� ��󵵸��ߴ�. ������ ����޳�..
// day�� ũ�⸦ ���ϴ� �κ��� �ʹ� ���ʿ��غ��δ�..
// ������ ������� �ٸ� ������׵� ������...