// The following iterative sequence is defined for the set of positive integers:

// n → n/2 (n is even)
// n → 3n + 1 (n is odd)

// Using the rule above and starting with 13, we generate the following sequence:

// 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
// It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

// Which starting number, under one million, produces the longest chain?

// NOTE: Once the chain starts the terms are allowed to go above one million.

public class eulerProblem14 {		//RISOLTO

	public static long chainLength(long x) {
		int r = 1;
		while (x > 1) {
			if (x%2 == 0) {
				x = x/2;
			}
			else {
				x = 3*x+1;
			}
			r += 1;
		}
		return r;
	}
	public static void main(String[] args) {
		long i = 0;
		long[] x = new long[2];
		while (i < 999999) {
			i += 1;
			if (x[0] < chainLength(i)) {
				x[0] = chainLength(i);
				x[1] = i;
			}
		}
		System.out.println(x[0]);
		System.out.println(x[1]);
	}
}