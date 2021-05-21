package level1;
import java.io.*;

public class NumberOfGames {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int game = 0;
		
		for(int i=1; i<n; i++){
			game += i;
		}
		
		System.out.println(game);
	}

}
