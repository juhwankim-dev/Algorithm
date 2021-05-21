package level1;
import java.io.*;

public class MultiplesOf3And5 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input);
		int sum = 0;
		
		for(int i=3; i<=N; i++){
			if(i % 3 == 0 || i % 5 == 0){
				sum += i;
			}
		}
		
		System.out.println(sum);
	}

}
