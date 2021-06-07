package etc;

import java.util.Stack;

public class CorrectParenthese {

	public static void main(String[] args) {
		
	}

    boolean solution(String s) {
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
		
		return stack.isEmpty();
    }
}
