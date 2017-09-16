package euler;
import mypackage.*;

// Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

// 1634 = 14 + 64 + 34 + 44
// 8208 = 84 + 24 + 04 + 84
// 9474 = 94 + 44 + 74 + 44
// As 1 = 14 is not a sum it is not included.

// The sum of these numbers is 1634 + 8208 + 9474 = 19316.

// Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

public class eulerProblem30 {						//RISOLTO
	public static void main(String[] args) {
		int[] x = numbersAsSumOfDigitPowers(5);
		int a = 0;
		for (int i = 0;i < x.length;i++) {
			a += x[i];
		}
		System.out.println(a);
	}

	public static int[] numbersAsSumOfDigitPowers(int x) {
		int[] numbers = new int[x*2];
		int counter = 0;
		int counter1 = 0;
		int i = 2;
		int max = maxSum(x);
		while (i < max) {
			if (digitsPow(i,x)) {
				numbers[counter] = i;
				counter++;
			}
			i++;
		}
		numbers = Array.copyOf(numbers,counter);
		return numbers;
	}

	private static int maxSum(int pow) {
		int a = Aritmetica.pow(9,pow);
		int i = 1;
		int cifre = 2;
		int b = a;
		while (cifre > i) {
			b = a*i;
			cifre = Array.cifre(b).length;
			i++;
		}
		return b;
	}

	private static boolean digitsPow(int x, int pow) {
		int[] cifre = Array.cifre(x);
		int sum = 0;
		for (int i = 0;i < cifre.length;i++) {
			sum += Aritmetica.pow(cifre[i],pow);
		}
		return sum == x;
	}
}