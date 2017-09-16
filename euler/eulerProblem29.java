package euler;
import mypackage.*;

//Consider all integer combinations of ab for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:

// 22=4, 23=8, 24=16, 25=32
// 32=9, 33=27, 34=81, 35=243
// 42=16, 43=64, 44=256, 45=1024
// 52=25, 53=125, 54=625, 55=3125
// sono potenze
// If they are then placed in numerical order, with any repeats removed, we get the following sequence of 15 distinct terms:

// 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125

// How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?

public class eulerProblem29 {							//RISOLTO
	public static void main(String[] args) {
		int a = 2;
		int b = 100;
		System.out.println(distinctNumbers(a,b));
	}

	public static int distinctNumbers(int min, int max) {
		int counter = 0;
		for (int i = min;i <= max;i++) {
			if (isPow(i)) {
				int pow = powLevel(i);
				for (int j = min;j <= max;j++) {
					if (count(j,pow,max)) {
						counter++;
					}
				}
			}
			else {
				for (int j = min;j <= max;j++) {
					counter++;
				}
			}
		}
		return counter;
	}

	private static boolean count(int j, int pow, int max) {
		double x = j;
		double power = pow;
		double maxx = max;
		boolean c = true;
		for (int i = 1;i < pow && c;i++) {
			if (x*(power/(double)(i)) % 1 == 0 && x*(power/(double)(i)) <= maxx) {
				c = false;
			}
		}
		return c;
	}

	private static int powLevel(int x) {
		int prova = x;
		boolean c = false;
		int count = 0;
		for (int i = 2;i < x && !c;i++){
			prova = x;
			count = 0;
			while (prova % i == 0) {
				prova = prova/i;
				count++;
			}
			if (count > 1 && prova == 1) {
				c = true;
			}
		}
		return count;
	}


	private static boolean isPow(int x) {
		int prova = x;
		boolean c = false;
		for (int i = 2;i < x && !c;i++){
			prova = x;
			int count = 0;
			while (prova % i == 0) {
				prova = prova/i;
				count++;
			}
			if (count > 1 && prova == 1) {
				c = true;
			}
		}
		return c;
	}
}
