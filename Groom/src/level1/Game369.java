package level1;
import java.io.*;

public class Game369 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		int sum = 0;
		
		for(int i=1; i<N; i++){
			String number = Integer.toString(i);
			
			for(int j=0; j<number.length(); j++){
				if(number.charAt(j) == '3' ||
					number.charAt(j) == '6' ||
					number.charAt(j) == '9'){
					sum++;
				}
			}
		}
		
		System.out.println(sum);
	}

}
