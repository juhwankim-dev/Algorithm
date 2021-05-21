package level1;
import java.io.*;

public class TaeminsHobby {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		long dice = Integer.parseInt(input);
		
		long sum = 0;
		sum += dice * (dice + 1) / 2 % 1000000007;
		long answer = sum * sum % 1000000007;
		System.out.println(answer % 1000000007);
	}

}
