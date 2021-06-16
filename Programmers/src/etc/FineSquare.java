package etc;

public class FineSquare {

	public static void main(String[] args) {
		System.out.println(solution(8, 12));
	}

    public static long solution(long w, long h) {
        long answer = 0;
    	
    	for(int i=0; i<w; i++) {
        	answer += h*i/w;
        }
    	
    	return answer*2;
    }
}
