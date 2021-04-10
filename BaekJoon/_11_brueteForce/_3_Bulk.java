package _11_brueteForce;

import java.io.*;
import java.util.*;

public class _3_Bulk {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] body = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			body[i][0] = Integer.parseInt(st.nextToken());
			body[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] rank =getRanking(N, body);
		StringBuilder sb = new StringBuilder();
		for(int r : rank) {
			sb.append(r + " ");
		}
		
		System.out.println(sb.toString());
	}

	public static int[] getRanking(int N, int body[][]){
		int[] rank = new int[N];
		
		for(int i=0; i<N; i++) {
			int myTall = body[i][0];
			int myWeight = body[i][1];
			int myRank = 1;
			for(int j=0; j<N; j++) {
				if(j==i) continue;
				
				int yourTall = body[j][0];
				int yourWeight = body[j][1];
				
				if(myTall < yourTall && myWeight < yourWeight) {
					myRank++;
				}
			}
			rank[i] = myRank;
		}
		
		return rank;
	}
}

// ���� �а� �����ϱ� 4��
// ���� Ǯ�� 23��
// �� ���� ��� �����غ��� 2�� -> �� ������