// The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

// Find the sum of all the primes below two million.

public class eulerProblem10 {
	public static long SumOfPrimes(long x) {
		long[] primes = new long[(int)x];
		primes[0] = 2;
		primes[1] = 3;
		primes[2] = 5;
		long somma = 10;
		int counter0 = 3;
		long p = 7;
		int counter1 = 0;
		while (counter0 < x/2 && p <= x) {
			counter1 = 0;
			while (counter1 < counter0 && p % primes[counter1] != 0) {
				counter1 += 1;
			}
			if (counter1 == counter0) {
				primes[counter0] = p;
				somma = somma + p;
				counter0 += 1;
			}
			p += 2;
		}
		return somma;
	}
	public static void main(String[] args) {
		long r = SumOfPrimes(2000000);
		System.out.println(r);
		}
}