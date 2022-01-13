package ud2.maths.e2_serial;

import ud2.maths.e2_selfmade.MathsUtils;

public class Main {
	
	private static final int MAXIMUM_NUMBER = 100_000;
	
	public static void main(String[] args) {
		int max = 0;
		for (int i = 0; i < MAXIMUM_NUMBER; i++) {
			int n = MathsUtils.divCount(i);
			if (n > max) {
				max = n;
			}
		}
		System.out.println(max);
	}

}
