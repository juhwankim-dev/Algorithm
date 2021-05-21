package level1;
import java.io.*;

public class ScoreAvgRate {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] numbers = input.split(" ");
		int sum = 0;
		
		for(int i=0; i<numbers.length; i++){
			sum += Integer.parseInt(numbers[i]);	
		}
		
		double avg = sum / (double) numbers.length;
		avg = Math.round(avg*100)/100.0;
		System.out.println(String.format("%.2f", avg) + " " + getGrade(avg));
	}
	
	public static char getGrade(double score){
		if(score >= 90)
			return 'A';
		else if(score >= 80)
			return 'B';
		else if(score >= 70)
			return 'C';
		else if(score >= 60)
			return 'D';
		else
			return 'F';
	}

}
