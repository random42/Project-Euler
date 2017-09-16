// The prime factors of 13195 are 5, 7, 13 and 29.

// What is the largest prime factor of the number 600851475143 ?

public class eulerProblem3 {		
	public static long fattorePrimoMax(long x) {
		long primo = 2;
		long[] fattoriPrimi = new long[100];
		long[] numeriPrimi = new long[10000];
		numeriPrimi[0] = 2;
		int counterFattori = 0;
		int counterPrimi = 0;
		while (x != 1) {
			if (x%primo == 0) {
				x = x/primo;
				fattoriPrimi[counterFattori] = primo;
				counterFattori += 1;
			}
			else {
				long y = primo+1;
				int i = 0;
				while (i <= counterPrimi) {
					if (y%numeriPrimi[i] != 0) {
						i += 1;
					}
					else {
						y += 1;
					}
				}
				if (i == counterPrimi+1) {
					primo = y;
					counterPrimi += 1;
					numeriPrimi[counterPrimi] = primo;
				}
			}
		}
		return fattoriPrimi[counterFattori-1];
	}


	public static void main (String[] args) {
		long x = 600851475143L;
		System.out.println(fattorePrimoMax(x));
	}
}