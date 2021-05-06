package kakaoIntership;

import java.util.*;

public class MaximizingFormulas {
	
	public static void main(String[] args) {
		System.out.println(solution("50*6-3*2"));
	}

    public static long solution(String expression) {
        // ���� ��� ����
        String[] formula = expression.split("\\*|\\+|\\-");
        ArrayList<Long> numList = new ArrayList<>();
        for(String f : formula) {
        	numList.add(Long.parseLong(f));
        }
        
        // ������ ��� ����
		String operators = expression.replaceAll("[0-9]", "");
		ArrayList<Character> operList = new ArrayList<>();
		for(int i=0; i<operators.length(); i++) {
			operList.add(operators.charAt(i));
		}
		
		// ���� ������ �˾Ƴ���
		ArrayList<Character> priOperList = new ArrayList<>();
		if(expression.contains("*")) priOperList.add('*');
		if(expression.contains("+")) priOperList.add('+');
		if(expression.contains("-")) priOperList.add('-');
		
		long answer = 0;
		for(int i=0; i<priOperList.size(); i++) {
			answer = Math.max(answer, calcReward(numList, operList, priOperList));
			
			priOperList.add(priOperList.get(0)); // ������� 1���� �� ����� ����
			priOperList.remove(0); // 1�� ����
		}
		
		if(priOperList.size() == 3) {
			// ���� ����
			char temp = priOperList.remove(0);
			priOperList.add(priOperList.remove(0));
			priOperList.add(temp);
			
			// �ѹ���!
			for(int i=0; i<3; i++) {
				answer = Math.max(answer, calcReward(numList, operList, priOperList));
				
				priOperList.add(priOperList.get(0)); // ������� 1���� �� ����� ����
				priOperList.remove(0); // 1�� ����
			}
		}
		
        return answer;
    }
    
    public static long calcReward(ArrayList<Long> n, ArrayList<Character> o, ArrayList<Character> priOperList) {
    	ArrayList<Long> numList = new ArrayList<>();
    	numList.addAll(n);
    	ArrayList<Character> operList = new ArrayList<>();
    	operList.addAll(o);
    	
    	for(int i=0; i<priOperList.size(); i++) {
    		char oper = priOperList.get(i);
    		int size = operList.size();
    		while(size-- > 0) {
    			char curOper = operList.remove(0);
    			long firstVal = numList.remove(0);
    			
    			if(oper == curOper) {
    				long secondVal = numList.remove(0);
    				numList.add(0, calc(firstVal, secondVal, oper));
    			} else {
    				operList.add(curOper);
    				numList.add(firstVal);
    			}
    		}
    		numList.add(numList.remove(0));
    	}
    	
    	return Math.abs(numList.remove(0));
    }
    
    public static long calc(long a, long b, int c) {
    	switch(c) {
    		case '-':
    			return a - b;
    		case '+':
    			return a + b;
    		default:
    			return a * b;
    	}
    }
}
