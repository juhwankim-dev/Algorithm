package _11_brueteForce;

import java.io.*;
import java.util.*;

public class _4_PaintChessBoard {
	static String[] whiteBoard = new String[8];
	static String[] blackBoard = new String[8];
	
	public static void main(String[] args) throws IOException {
		for(int i=0; i<8; i+=2) {
			whiteBoard[i] = "BWBWBWBW";
			whiteBoard[i+1] = "WBWBWBWB";
			blackBoard[i] = "WBWBWBWB";
			blackBoard[i+1] = "BWBWBWBW";
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] board = new String[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			board[i] = st.nextToken();
		}
		
		System.out.println(getMinimumRePaintNum(N, M, board));
	}

	public static int getMinimumRePaintNum(int N, int M, String[] board) {
		int min = 64;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int num = boardCheck(i, j, board);
				min = Math.min(min, num);
			}
		}
		
		return min;
	}
	
	public static int boardCheck(int a, int b, String[] board) {
		int startWhite=0, startBlack=0;
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(board[i+a].charAt(j+b) == whiteBoard[i].charAt(j)) {
					startBlack++;
				} else {
					startWhite++;
				}
			}
		}

		return Math.min(startWhite, startBlack);
	}
}

// ���� �а� �����ϱ� 5��
// ���� Ǯ�� 25�� -> ����
// ���� Ǯ���� ������� �ٽ� �����ε�
// �� �� ������ ������ if�� ���� ���� ����ϰ� Math.min() �������.