package euler;
import mypackage.*;

// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

// The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

// Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

// HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

public class eulerProblem32 {						// RISOLTO	
	public static void main(String[] args) {		
		System.out.println(sumOfProducts(9));
	}

	public static int sumOfProducts(int digits) {
		int max = lastPossibleProduct(digits);
		int somma = 0;
		for (int i = 3; i <= max;i++) {
			if (isProduct(i,digits)) {
				somma += i;
			}
		}
		return somma;
	}

	public static boolean isProduct(int num, int digits) {
		if (notRepeating(num)) {
			boolean ret = false;
			int j = 2;
			while (j <= num/2 && !ret) {
				if (num%j == 0 && notRepeating(j) && notRepeating(num/j)) {
					int i = num/j;
					int[] num1 = Array.cifre(num);
					int[] j1 = Array.cifre(j);
					int[] i1 = Array.cifre(i);
					int[] fusione = Array.fusione(Array.fusione(num1,j1),i1);
					if (fusione.length == digits && isPandigital(fusione)) {
						ret = true;
					}
				}
				j++;
			}
			return ret;
		}
		else {
			return false;
		}
	}

	public static int lastPossibleProduct(int digits) {
		int num = digits;
		int length = 1;
		while (Array.cifre(num).length + Array.cifre(Aritmetica.sqrt(num)).length *2 < digits) {
			length++;
			num = max(digits,length);
		}
		return num;
	}

	private static int max(int digits, int length) {
		length--;
		int num = 0;
		while (length >= 0) {
			num+= Aritmetica.pow(10,length) * digits;
			length--;
			digits--;
		}
		return num;
	}

	public static boolean isPandigital(int[] m) {
		if (notRepeating(m)) {
			boolean c = true;
			for (int i = 0;i < m.length && c;i++) {
				if (m[i] > m.length) {
					c = false;
				}
			}
			return c;
		}
		else {
			return false;
		}
	}

	private static boolean notRepeating(int[] a) {
		boolean c = true;
		if (a.length < 2) {
			return true;
		}
		for (int i = 0; i < a.length;i++) {
			if (a[i] == 0) {
				return false;
			}
		}
		for (int i = 0; i < a.length-1 && c;i++) {
			int j = i+1;
			while (j < a.length) {
				if (a[i] == a[j]) {
					c = false;
				}
				j++;
			}
		}
		return c;
	}

	public static boolean notRepeating(int num) {
		boolean c = true;
		if (num < 10 && num > 0) {
			return true;
		}
		int[] a = Array.cifre(num);
		for (int i = 0; i < a.length;i++) {
			if (a[i] == 0) {
				return false;
			}
		}
		for (int i = 0; i < a.length-1 && c;i++) {
			int j = i+1;
			while (j < a.length) {
				if (a[i] == a[j]) {
					c = false;
				}
				j++;
			}
		}
		return c;
	}
}