package euler;
import mypackage.*;

// 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

// Find the sum of all numbers which are equal to the sum of the factorial of their digits.

// Note: as 1! = 1 and 2! = 2 are not sums they are not included.

public class eulerProblem34 {					//RISOLTO

	public static void main(String[] args) {
		System.out.println(sum(myNumbers()));
	}

	public static long[] myNumbers() {
		long max = factorial(9)*8;
		long[] x = new long[10000];
		int j = 0;
		for (long i = 3;i <= max;i++) {
			if (isSumOfFactorials(i)) {
				x[j] = i;
				j++;
			}
		}
		return x;
	}

	public static long sum(long[] x) {
		long a = 0;
		for (int i = 0; i < x.length;i++) {
			a += x[i];
		}
		return a;
	}

	public static boolean isSumOfFactorials(long a) {
		long[] cifre = Array.cifre(a);
		long[] factorials = new long[cifre.length];
		for (int i = 0; i < cifre.length;i++) {
			factorials[i] = factorial(cifre[i]);
		}
		return sum(factorials) == a;
	}

	public static long factorial(long a) {
		long b = 1;
		while (a > 1) {
			b *= a;
			a--;
		}
		return b;
	}
}