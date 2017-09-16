// The sum of the squares of the first ten natural numbers is,

// 1^2 + 2^2 + ... + 10^2 = 385
// The square of the sum of the first ten natural numbers is,

// (1 + 2 + ... + 10)^2 = 55^2 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

public class eulerProblem6 {  //RISOLTO
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum = sum + (i*i);
		}
		int square = 0;
		for (int x = 1; x <= 100; x++) {
			square = square + x;
		}
		square = square*square;
		System.out.println(square-sum);
	}
}