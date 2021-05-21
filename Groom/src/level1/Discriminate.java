package level1;
import java.io.*;

public class Discriminate {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String result = (Integer.parseInt(input) % 2 == 0) ? "even" : "odd";

		System.out.println(result);
	}

}
