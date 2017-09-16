package euler;
import mypackage.*;

// The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

// Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

// NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

public class eulerProblem37 {						//RISOLTO
	public static void main(String[] args) {
		int[] primes = Array.primesTo(1000000);
		int count = 0;
		int sum = 0;
		for (int i = 0;i < primes.length && count < 11;i++) {
			if (isTruncatable(primes[i],primes)) {
				count++;
				// System.out.println(primes[i]);
				sum += primes[i];
			}
		}
		if (count == 11) {
			System.out.println(sum);
		}
	}

	public static boolean isTruncatable(int prime, int[] primes) {
		int[] cifre = Array.cifre(prime);
		boolean ris = prime > 7;
		if (ris) {
			int i = cifre.length-1;
			int value = prime;
			for (int j = 0;j < cifre.length-1 && ris;j++) {
				value = value - cifre[j]*(Aritmetica.pow(10,i));
				// System.out.println(value);
				i--;
				if (!Array.binarySearch(value,primes)) {
					ris = false;;
				}
			}
			value = prime;
			for (int j = 0;j < cifre.length-1 && ris;j++){
				value = value/10;
				// System.out.println(value);
				if (!Array.binarySearch(value,primes)) {
					ris = false;
				}
			}
			return ris;
		}
		else {
			return false;
		}

	}
}