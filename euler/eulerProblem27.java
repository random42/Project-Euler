package euler;
import mypackage.*;

// Euler discovered the remarkable quadratic formula:

// n2+n+41n2+n+41
// It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39. However, when n=40,402+40+41=40(40+1)+41n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41n=41,412+41+41 is clearly divisible by 41.

// The incredible formula n2−79n+1601n2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.

// Considering quadratics of the form:

// n2+an+bn2+an+b, where |a|<1000|a|<1000 and |b|≤1000|b|≤1000

// where |n||n| is the modulus/absolute value of nn
// e.g. |11|=11|11|=11 and |−4|=4|−4|=4
// Find the product of the coefficients, aa and bb, for the quadratic expression that produces the maximum number of primes for consecutive values of nn, starting with n=0n=0.

public class eulerProblem27 {						//RISOLTO ANCHE SE NON VELOCEMENTE
	public static void main(String[] args) {
		int[] a = bestCoefficients(1000);
		Array.print(a);
		System.out.println(a[0]*a[1]);
		System.out.println(numeroPrimi(a[0],a[1]));
	}

	private static int[] bestCoefficients(int limite) {
		int[] primi = Array.primesTo(limite);
		int[] risultato = new int[2];
		int b = primi[0];
		int a;
		int max = 0;
		for (int i = 2;i < primi.length;i++) {
			b = primi[i];
			for (a = (limite-1)*(-1);a < limite;a++) {
				if (max < numeroPrimi(a,b)) {
					max = numeroPrimi(a,b);
					risultato[0] = a;
					risultato[1] = b;
				}
			}
		}
		return risultato;
	}

	private static int numeroPrimi(int a, int b) {
		int n = 0;
		boolean prime = Aritmetica.isPrime(n*n + a*n + b);
		while (prime) {
			n++;
			prime = Aritmetica.isPrime(n*n + a*n + b);
		}
		return n;
	}
}