package heap;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {
		Queue<Integer> test = new LinkedList<>();

		test.add(1);
		test.add(1);
		test.add(2);
		test.remove(1);
		
		System.out.println(test.size());
		System.out.println(test.poll());
		System.out.println(test.poll());
		System.out.println(test.poll());
	}

}
