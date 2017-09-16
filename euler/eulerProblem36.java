package euler;
import mypackage.*;

// The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

// Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

// (Please note that the palindromic number, in either base, may not include leading zeros.)

public class eulerProblem36 {				//RISOLTO
	public static void main(String[] args) {
		int somma = 0;
		for (int i = 1;i < 1000000;i++) {
			if (isPalindromicInBothBases(i)) {
				somma += i;
			}
		}
		System.out.println(somma);
	}

	public static boolean isPalindromicInBothBases(int a) {
		int[] b = Array.cifre(a);
		int[] c = Array.inverso(b);
		boolean palindromic = Array.equals(b,c);
		if (palindromic) {
			String binary = Integer.toBinaryString(a);
			int[] cifreBinarie = Array.stringToArray(binary);
			return (Array.equals(cifreBinarie,Array.inverso(cifreBinarie)));
		}
		else {
			return false;
		}
	}
}