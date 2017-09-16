package euler;
import mypackage.*;
// n! means n × (n − 1) × ... × 3 × 2 × 1

// For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
// and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

// Find the sum of the digits in the number 100!

public class eulerProblem20 {	 			//RISOLTO PORCODDIO
	public static void main(String[] args) {
		String a = Aritmetica.factorial("100");
		System.out.println(a);
		int[] x = Array.stringToArray(a);
		int r = 0;
		for (int i = 0;i < x.length;i++) {
			r = r + x[i];
		}
		System.out.println(r);
	}
}
