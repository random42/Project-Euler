package euler;
import mypackage.*;

// Take the number 192 and multiply it by each of 1, 2, and 3:

// 192 × 1 = 192
// 192 × 2 = 384
// 192 × 3 = 576
// By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

// The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

// What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?

public class eulerProblem38 {						//RISOLTO
	public static void main(String[] args) {
		int n = 9;
		int max = 9999;
		int pandigital = 123456789;
		for (int i = 1;i < max && pandigital <= 987654321; i++) {
			int m = 2;
			int[] product = concatenatedProduct(i,m);
			while (product.length < n) {
				product = concatenatedProduct(i,m);
				m++;
			}
			product = concatenatedProduct(i,m);
			while (product.length == n) {
				if (isPandigital(product,n) && Array.valueOfDigits(product) > pandigital) {
					pandigital = Array.valueOfDigits(product);
					System.out.println(pandigital);
				}
				m++;
				product = concatenatedProduct(i,m);
			}
		}
		System.out.println(pandigital);
	}

	public static int[] concatenatedProduct(int number, int n) {
		int[] prodotti = new int[n];
		for (int i = 1; i <= n;i++) {
			prodotti[i-1] = number*i;
		}
		int[][] matriceCifre = new int[n][];
		int cifreTotali = 0;
		for (int i = 0;i < n;i++) {
			matriceCifre[i] = Array.cifre(prodotti[i]);
			cifreTotali += matriceCifre[i].length;
		}
		int[] cifreConcatenate = new int[0];
		for (int i = 0; i < n;i++) {
			cifreConcatenate = Array.fusione(cifreConcatenate,matriceCifre[i]);
		}
		return cifreConcatenate;
	}

	public static boolean isPandigital(int[] a, int n) {
		if (a.length == n) {
			boolean c = true;
			for (int i = 1; i <= n && c;i++) {
				c = false;
				for (int j = 0; j < n;j++) {
					if (a[j] == i) {
						c = true;
					}
				}
			}
			return c;
		}
		else {
			return false;
		}
	}
}