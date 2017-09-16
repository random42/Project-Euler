package euler;

/*If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23. 
Find the sum of all the multiples of 3 or 5 below 1000.*/

public class eulerProblem1 {
	public static void main (String[] args) {
		int a = 5;
		int b = 3;
		int i = 1;
		int r = 0;
		while (i < 1000) {
			if (i % a == 0 || i % b == 0) {
				r = r+i;
			}
			i = i+1;
		}
		System.out.println(r);
	}
}