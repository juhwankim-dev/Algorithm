package etc;

public class MaxMinValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        String[] numbers = s.split(" ");
        for(String number : numbers) {
        	int n = Integer.parseInt(number);
        	if(n < min) min = n;
        	if(n > max) max = n;
        }
        
        return min + " " + max;
    }
}
