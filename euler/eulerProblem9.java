// A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

// a^2 + b^2 = c^2
// For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

// There exists exactly one Pythagorean triplet for which a + b + c = 1000.
// Find the product abc.

public class eulerProblem9 { 			//RISOLTO DI CULO

	public static boolean isSquare(int x) {
		if (Math.sqrt((double)x) % 1 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static int sqrt(int x) {
		return (int)(Math.sqrt((double)x));
	}

	public static void main(String[] args) {
		int a = 200;
		while (a < 450) {
			int b = a+1;
			while (b < 500) {
				int c2 = (a*a)+(b*b);
				int c = sqrt(c2);
				if (isSquare(c2) == true && (a+b+c) == 1000) {
					System.out.println(a);
					System.out.println(b);
					System.out.println(c);
					System.out.println(a*b*c);
				}
				b += 1;
			}
			a += 1;
		}
	}
}