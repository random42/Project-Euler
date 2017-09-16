package euler;
import mypackage.*;

// If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

// {20,48,52}, {24,45,51}, {30,40,50}

// For which value of p ≤ 1000, is the number of solutions maximised?

public class eulerProblem39 {					// RISOLTO
	public static void main(String[] args) {
		int perfect = 1;
		int p = 1;
		int max = 0;
		while (p <= 1000) {
			if (solutions(p) > max) {
				perfect = p;
				max = solutions(p);
			}
			p++;
		}
		System.out.println(perfect);
		System.out.println(max);
	}

	public static boolean isRightAngle(int a, int b) {
		boolean c = Aritmetica.isSquare(Aritmetica.pow(a,2)+Aritmetica.pow(b,2));
		return c;
	}

	public static int solutions(int p) {
		int a = 1;
		int b = 1;
		int solutions = 0;
		int c = 1;
		for (a = 1;a <= p-c;a++) {
			for (b = 1; b <= p-a;b++) {
				if (isRightAngle(a,b)) {
					int perimetro = Aritmetica.sqrt(Aritmetica.pow(a,2)+Aritmetica.pow(b,2)) + a + b;
					if (perimetro == p) {
						solutions++;
					}
				}
			}
			c = a;
		}
		return solutions;
	}


}