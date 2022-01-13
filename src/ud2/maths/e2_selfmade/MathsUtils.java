package ud2.maths.e2_selfmade;

import java.util.Arrays;

public class MathsUtils {

	public static int divCount(int n) {
		boolean hash[] = new boolean[n + 1];
		Arrays.fill(hash, true);
		for (int p = 2; p * p < n; p++)
			if (hash[p] == true)
				for (int i = p * 2; i < n; i += p)
					hash[i] = false;

		int total = 1;
		for (int p = 2; p <= n; p++) {
			if (hash[p]) {

				int count = 0;
				if (n % p == 0) {
					while (n % p == 0) {
						n = n / p;
						count++;
					}
					total = total * (count + 1);
				}
			}
		}
		return total;
	}

}
