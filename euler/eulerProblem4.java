// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

// Find the largest palindrome made from the product of two 3-digit numbers.
import java.util.Scanner;

public class eulerProblem4 {					// RISOLTO


	public static boolean isPalindrome(int a) {
		boolean c = true;
		int[] cifre = array.cifre(a);
		int i = 0;
		while (i <= cifre.length/2 && c == true) {
			if (cifre[i] != cifre[cifre.length-1-i]) {
				c = false;
			}
			i += 1;
		}
		return c;
	}


	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int[] palindromi = new int[4000];
		int counter = 0;
		for (int a = 100; a < 1000; a++) {
			for (int b = 100; b < 1000; b++) {
				if (isPalindrome(a*b) == true) {
					palindromi[counter] = a*b;
					counter += 1;
				}
			}
		}

		System.out.println(array.max(palindromi));

	}
}