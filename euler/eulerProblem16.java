// 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

// What is the sum of the digits of the number 2^1000?

public class eulerProblem16 {

	public static String cifreToString(int[] a) {
		String x = "";
		for (int i = 0; i < a.length; i++) {
			x = x+Integer.toString(a[i]);
		}
		return x;
	}

	public static int arraySum(int[] a) {
		int r = 0;
		for (int i = 0; i < a.length; i++) {
			r = r + a[i];
		}
		return r;
	}

	public static int[] stringToArray(String a) {
		int[] cifre = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			cifre[i] = Integer.valueOf(a.substring(i,i+1));
		}
		return cifre;
	}

	public static String potenza(int a, int x) {
		String[] addendi = new String[2];
		addendi[0] = Integer.toString(a);
		addendi[1] = Integer.toString(a);
		for (int i = 1; i < x; i++) {
			int[] somma = eulerProblem13.somma(addendi);
			for (int h = 0; h < addendi.length; h++) {
				addendi[h] = cifreToString(somma);
			}
		}
		return addendi[0];
	}

	public static void main(String[] args) {
		String a = potenza(2,1000);
		System.out.println(arraySum(stringToArray(a)));

	}
}