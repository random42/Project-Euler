package euler;
import mypackage.*;

// The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

// We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

// There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

// If the product of these four fractions is given in its lowest common terms, find the value of the denominator.

public class eulerProblem33 {					//RISOLTO
	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		int[][] fractions = new int[8][2];
		int i = 0;
		for (a = 10;a < 100;a++) {
			for (b = 10;b < 100;b++) {
				int buono = buono(a,b);
				if (buono > 0) {
					if (buono == 1) {
						int[] current = first(a,b);
						if ((double)current[0] / (double)current[1] == (double)a/(double)b) {
							fractions[i][0] = a;
							fractions[i][1] = b;
							i++;
						}
					}
					else {
						int[] current = second(a,b);
						if ((double)current[0] / (double)current[1] == (double)a/(double)b) {
							fractions[i][0] = a;
							fractions[i][1] = b;
							i++;
						}
					}
				}
			}
		}
		Array.print(fractions);
		int[] prodotto = new int[2];
		prodotto[0] = 1;
		prodotto[1] = 1;
		for (int j = 0;j < 4;j++) {
			prodotto[0] *= fractions[j][0];
			prodotto[1] *= fractions[j][1];
		}
		int massimoComune = mcd(prodotto[0],prodotto[1]);
		prodotto[0] /= massimoComune;
		prodotto[1] /= massimoComune;
		Array.print(prodotto);
	}

	private static int buono(int a, int b) {
		if (a%10 == 0 || b%10 == 0) {
			return 0;
		}
		else {
			int[] x = Array.cifre(a);
			int[] y = Array.cifre(b);
			if (x[0] == y[1] && x[1] != x[0] && y[0] != x[0]) {
				return 2;
			}
			if (x[1] == y[0] && x[0] != x[1] && y[1] != x[1]) {
				return 1;
			}
			else {
				return 0;
			}
		}
	}

	private static int mcd(int a, int b) {
		int resto = a-(a/b*b);
		if (resto == 0) {
			return b;
		}
		else {
			return mcd(b,resto);
		}
	}

	private static int[] lowestCommonTerms(int a, int b) {
		int mcd = mcd(a,b);
		int[] x = {a/mcd,b/mcd};
		return x;
	}

	private static int[] first(int a, int b) {
		int[] x = Array.cifre(a);
		int[] y = Array.cifre(b);
		int[] c = {x[0],y[1]};
		return c;
	}
	private static int[] second(int a, int b) {
		int[] x = Array.cifre(a);
		int[] y = Array.cifre(b);
		int[] c = {x[1],y[0]};
		return c;
	}
}