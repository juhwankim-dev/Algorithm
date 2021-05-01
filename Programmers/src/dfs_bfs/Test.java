package dfs_bfs;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder(10);
		sb.append(1);
		sb.append(2);
		sb.append(3);
		sb.append(4);
		sb.append(5);
		sb.append(6);
		sb.append(7);
		
		System.out.println(sb.toString());
		sb.delete(sb.length()-4, sb.length());
		System.out.println(sb.toString());
		sb.setLength(0);
		System.out.println(sb.toString());
		sb.append(1);
		System.out.println(sb.toString());

	}
}
