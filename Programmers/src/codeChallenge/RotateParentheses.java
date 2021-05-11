package codeChallenge;

import java.util.*;

public class RotateParentheses {

	public static void main(String[] args) {
		System.out.println(solution("{{"));
	}

    public static int solution(String s) {
        int answer = 0;
    	StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for(int i=0; i<s.length(); i++){
            answer += (isRight(sb)) ? 1 : 0;
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        
        return answer;
    }
    
    public static boolean isRight(StringBuilder sb) {
    	Stack<Character> stack = new Stack<>();
    	
    	for(int j=0; j<sb.length(); j++){
            char c = sb.charAt(j);
        
            if(c == ']'){
                if(stack.isEmpty() || stack.peek() != '[') return false;
                else stack.pop();
            } else if(c == '}'){
                if(stack.isEmpty() || stack.peek() != '{') return false;
                else stack.pop();
            } else if(c == ')'){
                if(stack.isEmpty() || stack.peek() != '(') return false;
                else stack.pop();
            } else {
                stack.add(c);
            }
        }
    	
    	if(stack.isEmpty()) return true;
    	else return false;
    }
}
