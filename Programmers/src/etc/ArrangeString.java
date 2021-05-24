package etc;

import java.util.*;

public class ArrangeString {

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
	}

	public static String solution(String s) {
    	Character[] arr = new Character[s.length()];
    	
    	for(int i=0; i<s.length(); i++) {
    		arr[i] = s.charAt(i);
    	}
    
    	Arrays.sort(arr, Comparator.reverseOrder());
    	StringBuilder sb = new StringBuilder();
    	for(char a : arr) {
    		sb.append(a);
    	}
    	
    	return sb.toString();
    }
}
