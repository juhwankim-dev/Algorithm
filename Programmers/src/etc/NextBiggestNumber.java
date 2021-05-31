package etc;

public class NextBiggestNumber {

    static final int MAX = 1000000;
	public static void main(String[] args) {
		System.out.println(solution(78));
	}

    public static int solution(int n) {
    	int answer=0;
    	
    	String binary = Integer.toBinaryString(n);
    	binary = binary.replace("0", "");
    	int size = binary.length();
    	
        for(int i=n+1; i<MAX; i++) {
        	String temp = Integer.toBinaryString(i);
        	temp = temp.replace("0", "");
        	if(temp.length() == size) {
        		answer = i;
        		break;
        	}
        }
        
        return answer;
    }
}
