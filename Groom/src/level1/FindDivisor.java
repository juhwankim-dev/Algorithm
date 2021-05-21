package level1;
import java.io.*;

public class FindDivisor {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int num = Integer.parseInt(input);
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=num; i++){
			if(num % i == 0)
				sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
