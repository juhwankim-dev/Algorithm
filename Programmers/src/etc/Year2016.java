package etc;

public class Year2016 {

	public static void main(String[] args) {
		System.out.println(solution(1, 7));
	}

	  public static String solution(int a, int b) {
		  	int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
	        int day = 0;
	        
	        // �� ���
	        for(int i=0; i<a-1; i++) {
	            day += months[i];
	        }
	        
	        // �� ���
	        day += b - 1;
	        
	        return days[day % 7];
	    }
}
