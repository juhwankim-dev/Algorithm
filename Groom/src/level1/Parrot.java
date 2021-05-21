package level1;

import java.io.*;
import java.util.*;

public class Parrot {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] result = new String[N];
		for(int i=0; i<N; i++){
			String input = br.readLine();
			String repeat = input.replaceAll("[^aeiouAEIOU]", "");
			result[i] = (repeat.isEmpty()) ? "???" : repeat;
		}
		
		for(String r : result){
			System.out.println(r);
		}
	}
}
