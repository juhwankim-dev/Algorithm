package etc;

import java.util.*;

public class TriangularSnail {

	public static void main(String[] args) {
		Queue<Integer> queue = solution(1);

		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			sb.append(queue.poll()).append(", ");
		}
		
		System.out.println(sb.toString());
	}

    public static Queue<Integer> solution(int n) {
		int[][] arr = new int[n][n];
		int y = 0;
		int x = 0;
		int num = 1;

		while (rangeCheck(arr, y, x, n)) {
			// 내려가기
			while (rangeCheck(arr, y, x, n)) {
				arr[y++][x] = num++;
			}
			y--;
			x++;

			// 오른쪽으로 가기
			while (rangeCheck(arr, y, x, n)) {
				arr[y][x++] = num++;
			}
			y--;
			x-=2;

			// 올라가기
			while (rangeCheck(arr, y, x, n)) {
				arr[y--][x--] = num++;
			}
			y+=2;
			x++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for(int[] a : arr) {
			for(int element : a) {
				if(element != 0) {
					queue.add(element);
				}
			}
		}
		
		return queue;
    }
    
    public static boolean rangeCheck(int[][] arr, int y, int x, int n) {
    	if(y >= 0 && x >= 0 && y < n && x < n
    			&& arr[y][x] == 0) {
    		return true;
    	}
    	
    	return false;
    }
}
