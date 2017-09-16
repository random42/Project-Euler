// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

public class eulerProblem5 {  //RISOLTO
	public static void main (String[] args) {
		int a = 20;
		while (a%20 != 0 || a%19 != 0 || a%18 != 0 || a%17 != 0 || a%16 != 0 || a%15 != 0 || a%14 != 0 || a%13 != 0 || a%12 != 0 || a%11 != 0) {
			a += 20;
		}
		System.out.println(a);
	}
}