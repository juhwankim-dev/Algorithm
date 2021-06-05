package etc;

import java.util.*;

public class ConvertParentheses {

	public static void main(String[] args) {
		System.out.println(solution("))(("));
	}
	
    public static String solution(String s) {
        return isAlright(s) ? s : step1(s);
    }

    public static String step1(String s) {
    	if(s.isBlank()) {
    		return s;
    	}
    	
    	return step2(s);
    }
    
    public static String step2(String s) {
    	String leftStr = s;
    	String rightStr = "";
    	
    	for(int i=0; i<s.length(); i=i+2) {
    		leftStr = s.substring(0, i+2);
    		rightStr = s.substring(i+2, s.length());
    		
    		if(isBalanced(leftStr) && isBalanced(rightStr)) break;
    	}
    	
    	return step3(leftStr, rightStr);
    }
    
    public static String step3(String leftStr, String rightStr) {
    	if(isAlright(leftStr)) {
    		return leftStr + step1(rightStr); // 3-1
    	} else {
    		return step4(leftStr, rightStr);
    	}
    }
    
    public static String step4(String leftStr, String rightStr) {
    	String answer = "";
    	
    	answer += "("; // 4-1
    	answer += step1(rightStr); // 4-2
    	answer += ")"; // 4-3
    	
    	// 4-4
    	StringBuilder sb = new StringBuilder();
    	for(int i=1; i<leftStr.length()-1; i++) {
    		char ch = (leftStr.charAt(i) == '(') ? ')' : '(';
    		sb.append(ch);
    	}
    	answer += sb.toString();
    	
    	return answer; // 4-5
    }
    
	public static boolean isBalanced(String s) {
		String a = s.replace("(", "");
		String b = s.replace(")", "");
		
		return (a.length()==b.length()) ? true : false;
	}
	
	public static boolean isAlright(String s) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++) {		
			if(s.charAt(i) == ')') {
				if(stack.isEmpty() || stack.peek() == ')') {
					return false;
				} else {
					stack.pop();
				}
			} else {
				stack.add('(');
			}
		}
		
		return true;
	}
}
