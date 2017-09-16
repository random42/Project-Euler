package euler;
import mypackage.*;

// A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

// 1/2	= 	0.5
// 1/3	= 	0.(3)
// 1/4	= 	0.25
// 1/5	= 	0.2
// 1/6	= 	0.1(6)
// 1/7	= 	0.(142857)
// 1/8	= 	0.125
// 1/9	= 	0.(1)
// 1/10	= 	0.1
// Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

// Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.

public class eulerProblem26 {
	public static void main(String[] args) {			//RISOLTO
		String a = "1";
		String b = "2";
		String limite = "1000";
		int max = 0;
		String risultato = b;
		int[] periodo = new int[1];
		int[] maxPeriodo = new int[1];
		while (!b.equals(limite)) {
			String c = Aritmetica.divide(a,b,5000);
			periodo = Aritmetica.periodo(c);
			if (periodo != null) {
				if (max < periodo.length) {
					max = periodo.length;
					risultato = b;
					maxPeriodo = periodo;
				}
			}
			b = Aritmetica.somma(b,"1");
		}
		System.out.println(risultato);
		System.out.println(max);
		Array.print(maxPeriodo);
	}
}