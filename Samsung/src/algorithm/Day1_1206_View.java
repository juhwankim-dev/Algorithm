package algorithm;

import java.io.*;

public class Day1_1206_View {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		
		for(int i=0; i<T; i++) {
			int arrSize = Integer.parseInt(br.readLine());
			String[] apt = br.readLine().split(" ");
			int goodViewRoom = 0;;
			
			for(int j=2; j<arrSize-2; j++) {
				int mine = Integer.valueOf(apt[j]);
				int l2 = Integer.valueOf(apt[j-2]);
				int l1 = Integer.valueOf(apt[j-1]);
				int r1 = Integer.valueOf(apt[j+1]);
				int r2 = Integer.valueOf(apt[j+2]); 
				
				// 주변 건물중에 내 건물이 가장 높다면
				if(mine > l2 && mine > l1 && mine > r1 && mine > r2) {
					goodViewRoom = goodViewRoom + mine - getHighestFloor(l2, l1, r1, r2);
					//j+=2;
				}
			}
			
			sb.append("#").append(i+1).append(" ").append(goodViewRoom).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static int getHighestFloor(int a, int b, int c, int d) {
		return Math.max(a, Math.max(b, Math.max(c, d)));
	}
}
