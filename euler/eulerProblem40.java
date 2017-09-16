package euler;
import mypackage.*;

// An irrational decimal fraction is created by concatenating the positive integers:

// 0.123456789101112131415161718192021...

// It can be seen that the 12th digit of the fractional part is 1.

// If dn represents the nth digit of the fractional part, find the value of the following expression.

// d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

public class eulerProblem40 {			//SOLVEDDDD
	public static void main(String[] args) {
		int[] a = new int[6000000];
		int count = 0;
		for (int i = 1; i <= 1000000;i++) {
			//System.out.println(i);
			int[] cifre = Array.cifre(i);
			for (int j = 0; j < cifre.length;j++) {
				a[count] = cifre[j];
				count++;
			}
		}
		int[] nth = {0,9,99,999,9999,99999,999999};
		int x = 1;
		for (int i = 0;i < nth.length;i++) {
			x *= a[nth[i]];
		}
		System.out.println(x);
	}

}