package etc;

public class CollatzGuess {

	public static void main(String[] args) {
		System.out.println(Collatz(626331));
	}

    public static long Collatz(long num) {
        long cnt = 0;
        
        while(num != 1) {
        	if(++cnt == 500) return -1;
        	num = (num % 2 == 0) ? num/2 : num*3 + 1;
        }
        
        return cnt;
    }
}
