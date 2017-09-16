// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

public class eulerProblem17 {
	public static void main (String[] args) {
		String[] oneToNine = {"one","two","three","four","five","six","seven","eight","nine"};
		String[] tenToNineteen = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] mulOfTen = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
		int hundred = 7;
		int and = 3;
		int thousand = 11;
		int oneNine = 0;
		for (int i = 0; i < oneToNine.length; i ++) {
			oneNine += oneToNine[i].length();
		}
		int tenNineteen = 0;
		for (int i = 0; i < tenToNineteen.length; i ++) {
			tenNineteen += tenToNineteen[i].length();
		}
		int mulTen = 0;
		for (int i = 0; i < mulOfTen.length; i ++) {
			mulTen += mulOfTen[i].length();
		}
		int somma = 0;
		somma += oneNine*9*10;
		somma += tenNineteen*10;
		somma += mulTen*10*10;
		somma += and*900-9;
		somma += hundred*900;
		somma += oneNine;
		somma += thousand;
		System.out.println(somma);

		// for (int i = 1; i <= 999; i++) {
		// 	if (i < 10) {
		// 		somma = somma + (oneToNine[i-1].length());
		// 	}
		// 	if (i >= 10 && i < 20) {
		// 		somma = somma + (tenToNineteen[i-10].length());
		// 	}
		// 	if (i >= 20 && i < 100) {
		// 		if (i%10 == 0) {
		// 			somma = somma + (mulOfTen[(i/10)-2].length());
		// 		}
		// 		else {
		// 			somma = somma + (mulOfTen[(i/10)-2].length()) + (oneToNine[(array.cifre(i)[1])-1].length());
		// 		}
		// 	}
		// 	if (i >= 100) {
		// 		somma = somma + hundred + (oneToNine[i/100-1].length());
		// 		if (i - ((i/100)*100) > 9 && i - ((i/100)*100) < 20) {
		// 			somma = somma + (tenToNineteen[i - ((i/100)*100) - 10].length()) + and;
		// 		}
		// 		if (i - ((i/100)*100) >= 20) {
		// 			somma = somma + (mulOfTen[array.cifre(i)[1]-2].length()) + and;
		// 			if (array.cifre(i)[2] != 0) {
		// 				somma = somma + (oneToNine[array.cifre(i)[2]-1].length());
		// 			}
		// 		}
		// 	}
		// 	System.out.print(i);
		// 	System.out.println(" " + somma);
		// }
		// somma += thousand;
		// System.out.println(somma);
	}
}