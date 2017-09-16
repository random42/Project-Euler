package euler;
import mypackage.*;
// A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

// A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

// As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

public class eulerProblem23 {

	public static boolean nonSumOfAbundant(int x) {
		int i = 1;
		int j = x-1;
		while (i < x) {
			if (isAbundant(i) && isAbundant(j)) {
				return false;
			}
			i += 1;
			j -= 1;
		}
		return true;
	}

	public static boolean isAbundant(int x) {
		if (sumOfDivisors(x) > x) {
			return true;
		}
		else {
			return false;
		}

	}

	public static boolean isPerfect(int x) {
		if (sumOfDivisors(x) == x) {
			return true;
		}
		else {
			return false;
		}

	}



	public static boolean isDeficient(int x) {
		if (sumOfDivisors(x) < x) {
			return true;
		}
		else {
			return false;
		}

	}

	public static int sumOfDivisors(int x) {
		int r = 1;
		int sqrt = (int)Math.sqrt(x);
		for (int i = 2; i <= sqrt;i++) {
			if (i == sqrt && Aritmetica.isSquare(x)) {
				r += i;
			}
			else {
				if (x%i == 0) {
					r += i;
					r += x/i;
				}
			}
		}
		return r;
	}

	public static void main(String[] args) {
		int r = 0;
		for (int i = 1;i <= 28123;i++) {
			if (nonSumOfAbundant(i)) {
				r += i;
			}
		}
		System.out.println(r);
	}
}