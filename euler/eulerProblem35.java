package euler;
import mypackage.*;

// The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

// There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

// How many circular primes are there below one million?

public class eulerProblem35 {				//RISOLTO

	public static void main(String[] args) {
		int[] b = circularPrimesTo(1000000);
		Array.print(b);
		System.out.println(b.length);
	}

	public static int[] circularPrimesTo(int x) {
		int max = max(x);
		int[] primes = Array.primesTo(max);
		int count = 0;
		int[] ris = new int[x/2+1];
		for (int i = 0; i < primes.length;i++) {
			if (isCircular(primes[i],primes)) {
				ris[count] = primes[i];
				count++;
			}
		}
		ris = Array.copyOf(ris,count);
		return ris;
	}

	public static int max(int x) {
		int[] primes = Array.primesTo(x);
		int max = primes[primes.length-1];
		int[] cifre = Array.cifre(max);
		int valore = Array.valueOfDigits(cifre);
		for (int i = 0;i < cifre.length;i++) {
			cifre = prossimo(cifre);
			if (Array.valueOfDigits(cifre) > valore) {
				valore = Array.valueOfDigits(cifre);
			}
		}
		return valore;
	}

	public static int[] prossimo(int[] cifre) {
		int[] ris = new int[cifre.length];
		int rec = cifre[cifre.length-1];
		for (int i = 1;i < cifre.length;i++) {
			ris[i] = cifre[i-1];
		}
		ris[0] = rec;
		return ris;
	}

	public static boolean isCircular(int prime, int[] primes) {
		boolean c = true;
		int[] cifre = Array.cifre(prime);
		cifre = prossimo(cifre);
		for (int i = 0; i < cifre.length-1 && c;i++) {
			int value = Array.valueOfDigits(cifre);
			c = binarySearch(value,primes);
			cifre = prossimo(cifre);
		}
		return c;
	}

	public static boolean binarySearch(int x, int[] array) {
		return binarySearch(x,array,0,array.length);
	}

	private static boolean binarySearch(int x, int[] array, int start, int end) {
		int medium = (start+end)/2;
		if (end-start == 1) {
			if (x == array[start]) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (x == array[medium]) {
				return true;
			}
			if (x > array[medium]) {
				return binarySearch(x,array,medium,end);
			}
			else {
				return binarySearch(x,array,start,medium);
			}
		}
	}
}