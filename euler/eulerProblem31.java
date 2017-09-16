package euler;
import mypackage.*;

// In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
// It is possible to make £2 in the following way:

// 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
// How many different ways can £2 be made using any number of coins?

public class eulerProblem31 {
	public static void main(String[] args) {
		int[] monete = {200,100,50,20,10,5,2,1};
		int prezzo = 200;
	}

	public static int solutions(int prezzo, int[] monete) {
		int[] combination = new int[monete.length];
		int i = 0;
		while (i < monete.length && prezzo > 0) {
			if (monete[i] <= prezzo) {
				combinations[i]++;
				prezzo = prezzo-monete[i];
			}
			else {
				i++;
			}
		}
		
	}
}