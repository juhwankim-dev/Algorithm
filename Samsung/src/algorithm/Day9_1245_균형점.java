package algorithm;

import java.io.*;

public class Day9_1245_균형점 {
	static String[] magnetics;
	static int magneticsCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();

		for (int tc = 1; tc <= 10; tc++) {
			magneticsCnt = Integer.parseInt(br.readLine());
			magnetics = br.readLine().split(" ");
			sb.append("#" + tc + " ");
			
			for (int i = 0; i < magneticsCnt - 1; i++) {
				double left = Double.parseDouble(magnetics[i]);
				double right = Double.parseDouble(magnetics[i + 1]);
				double mid = 0.0;

				for (int j = 0; j < 50; j++) {
					mid = (left + right) / 2;

					double leftF = leftForce(i, mid);
					double rightF = rightForce(i, mid);

					if (leftF == rightF) {
						break;
					} else if (leftF > rightF) {
						left = mid;
					} else {
						right = mid;
					}
				}

				sb.append(String.format("%.10f", mid) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static double leftForce(int idx, double point) {
		double forceSum = 0.0;

		for (int i = 0; i <= idx; i++) {
			double d = Double.parseDouble(magnetics[i]);
			d -= point;
			double m = Double.parseDouble(magnetics[i + magneticsCnt]);

			forceSum += (m / Math.pow(d, 2));
		}

		return forceSum;
	}

	public static double rightForce(int idx, double point) {
		double rightForce = 0.0;

		for (int i = idx + 1; i < magneticsCnt; i++) {
			double d = Double.parseDouble(magnetics[i]);
			d -= point;
			double m = Double.parseDouble(magnetics[i + magneticsCnt]);

			rightForce += (m / Math.pow(d, 2));
		}

		return rightForce;
	}
}
