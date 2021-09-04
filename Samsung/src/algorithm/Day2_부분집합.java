package algorithm;

public class Day2_부분집합 {

	public static void main(String[] args) {
		int[] arr = {3,6,7,1,5,4, -3};
		int n = arr.length;
		
		isSumZero(arr, n);
	}
	
	public static boolean isSumZero(int[] arr, int n) {
		for(int i=1; i< 1<<n; i++) {
			for(int j=0; j<n; j++) {
				if((i & (1<<j)) != 0) {
					System.out.print(arr[j] + " ");
				}
			}
			System.out.println();
		}
		
		return false;
	}
}

/*

package algorithm;

public class Day2_부분집합 {

	public static void main(String[] args) {
		int[] arr = {3,6,7,1,5,4, -3};
		int n = arr.length;
		
		if(isSumZero(arr, n)) {
			System.out.println("합이 0이 되는 부분집합이 존재합니다.");
		} else {
			System.out.println("합이 0이 되는 부분집합이 존재하지 않습니다.");
		}
	}
	
	public static boolean isSumZero(int[] arr, int n) {
		for(int i=1; i< 1<<n; i++) {
			int sum = 0;
			
			for(int j=0; j<n; j++) {
				if((i & (1<<j)) != 0) {
					sum += arr[j];
				}
			}
			
			if(sum == 0) {
				return true;
			}
		}
		
		return false;
	}
}


*/