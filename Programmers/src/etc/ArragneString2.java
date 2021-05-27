package etc;

import java.util.*;

public class ArragneString2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String[] solution(String[] strings, int n) {
    	Arrays.sort(strings);
        Arrays.sort(strings, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(n) - o2.charAt(n);
			}
        });
        
        return strings;
    }
}
