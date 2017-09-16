package mypackage;

public class Aritmetica {

	public static void main(String[] args) {
		String a = "100120934931398478932";
		String b = "123489893893178463784";
		System.out.println(molt(a,b));
	}

	public static double round(double d, int numbersAfterDecimalPoint) {
	    long n = (long)Math.pow(10, numbersAfterDecimalPoint);
	    double d2 = d * n;
	    long l = (long) d2;
	    return ((double) l) / n;
	}

	public static String arrayToString(int[] a) {				//copia un array in una stringa
		String r = "";
		int i = 0;
		if (a[0] == (-1)) {
			r += "-";
			i++;
		}
		while (i < a.length) {
			if (a[i] != -2) {
				r += (Integer.toString(a[i]));
			}
			else {
				r += ".";
			}
			i++;
		}
		r = togliZero(r);
		return r;
	}

	public static boolean isPrime(int a) {						// controlla se a e' primo
		if (a < 2) {
			return false;
		}
		long[] primes = Array.primesTo((long)a);
		return primes[primes.length-1] == (long)a;
	}

	public static boolean isPrime(long a) {	
		if (a < 2) {
			return false;
		}
		long[] primes = Array.primesTo(a);
		if (primes[primes.length-1] == (a)) {
			return true;
		}
		return false;
	}

	public static String divide(String a, String b, int scale) {			//esegue la divisione a/b con scale numeri dopo la virgola
		if (b.equals("0")) {
			throw new ArithmeticException("Error / by zero");
		}
		if (isPositive(a) && !isPositive(b)) {
			return opposite(divide(a,opposite(b)));
		}
		if (!isPositive(a) && isPositive(b)) {
			return opposite(divide(opposite(a),b));
		}
		if (!isPositive(a) && !isPositive(b)) {
			return divide(opposite(a),opposite(b));
		}
		else {
			String r = "0";
			String div1 = a;
			String div2 = b;
			while (greaterOrEqual(div1,div2)) {
				div1 = sott(div1,div2);
				r = somma(r,"1");
			}
			if (!div1.equals("0")) {
				r += ".";
				int decimal = 0;
				while (!div1.equals("0") && decimal < scale) {
					div1 += "0";
					int quoziente = 0;
					while (greaterOrEqual(div1,div2)) {
						div1 = sott(div1,div2);
						quoziente++;
					}
					r += Integer.toString(quoziente);
					decimal++;
				}
				return r;
			}
			else {
				return r;
			}
		}	// a/b con scale numeri dopo la virgola di precisione
	}

	public static String divide(String a, String b) {
		if (b.equals("0")) {
			throw new ArithmeticException("Error / by zero");
		}
		if (isPositive(a) && !isPositive(b)) {
			return opposite(divide(a,opposite(b)));
		}
		if (!isPositive(a) && isPositive(b)) {
			return opposite(divide(opposite(a),b));
		}
		if (!isPositive(a) && !isPositive(b)) {
			return divide(opposite(a),opposite(b));
		}
		else {
			String r = "0";
			String div1 = a;
			String div2 = b;
			while (greaterOrEqual(div1,div2)) {
				div1 = sott(div1,div2);
				r = somma(r,"1");
			}
			if (!div1.equals("0")) {
				r += ".";
				int decimal = 0;
				while (!div1.equals("0") && decimal < 100) {
					div1 += "0";
					int quoziente = 0;
					while (greaterOrEqual(div1,div2)) {
						div1 = sott(div1,div2);
						quoziente++;
					}
					r += Integer.toString(quoziente);
					decimal++;
				}
				return r;
			}
			else {
				return r;
			}
		}			// a/b con massimo 100 numeri dopo la virgola
	}

	public static int sqrt(int x) {								// radice quadrata di un numero
		return (int)(Math.sqrt((double)x));
	}

	public static String pow(String a, String b) {				//restituisce a elevato b
		if ((a.equals("0")) && !(b.equals("0"))) {
			return "0";
		}
		if ((a.equals("0")) && (b.equals("0"))) {
			return "Errore!";
		}
		else {
			long esponente = Long.parseLong(b);
			long i;
			String r = "1";
			for (i = 0;i < esponente;i++) {
				r = molt(r,a);
			}
			return r;
		}
	}

	public static int pow(int a, int b) {
		int x = 1;
		for (int i = 0;i < b;i++) {
			x = x*a;
		}
		return x;
	}

	public static long pow(long a, long b) {
		long x = a;
		for (long i = 0;i < b;i++) {
			x = x*a;
		}
		return x;
	}

	public static boolean isSquare(long x) {					//controlla se un numero e' quadrato perfetto
		if (Math.sqrt((double)x) % 1 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isSquare(int x) {
		if (Math.sqrt((double)x) % 1 == 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String factorial(String a) {					//fattoriale di a
		if (a.equals("0")) {
			return "1";
		}
		else {
			return molt(a,factorial(sott(a,"1")));
		}
	}

	public static String molt(String a, String b) {				// esegue la moltiplicazione di due stringhe
		if (!isPositive(a) && !isPositive(b)) {
			return molt(opposite(a),opposite(b));
		}
		if (!isPositive(a) && isPositive(b)) {
			return opposite(molt(opposite(a),b));
		}
		if (isPositive(a) && !isPositive(b)) {
			return opposite(molt(a,opposite(b)));
		}
		if (isPositive(a) && isPositive(b)) {
			int l = Math.max(a.length(),b.length());
			int[] fattore1 = new int[l];
			int[] fattore2 = new int[l];
			int j = 0;
			for (int i = l-a.length(); i < l;i++) {		
			//copia le stringhe in array di lunghezza massima tra le due stringhe
				fattore1[i] = Integer.parseInt(a.substring(j,j+1));
				j++;
			}
			j = 0;
			for (int i = l-b.length(); i < l;i++) {
				fattore2[i] = Integer.parseInt(b.substring(j,j+1));
				j++;
			}
			int[][] gridAddendi = new int[l][l*2];
			int m = 0;
			int n = 0;
			for (int i = l-1; i >= 0; i--) {		
			//esegue le molt in colonna mettendo i risultati in gridAddendi
				m = l-i-1;
				n = l*2-1-m;
				for (int h = l-1; h >= 0; h--) {
					gridAddendi[m][n] = fattore2[i]*fattore1[h];
					n--;
				}
			}

			String[] addendi = new String[gridAddendi.length];
			for (int i = 0; i < gridAddendi.length;i++) {
				gridAddendi[i] = Array.inverso(gridAddendi[i]);
				gridAddendi[i] = semplificazione(gridAddendi[i]);
				gridAddendi[i] = Array.inverso(gridAddendi[i]);
				addendi[i] = arrayToString(gridAddendi[i]);
			}
			String r = somma(addendi);
			r = togliZero(r);
			return r;
		}
		return null;
	}

	public static String sott(String a, String b) {				// esegue la sottrazione di due stringhe
		if (isPositive(a) && isPositive(b)) {
			if (greaterOrEqual(a,b)) {
				int[] x1 = Array.stringToArray(a);
				int[] x2 = Array.stringToArray(b);
				int[][] m = new int[3][x1.length];
				m[0] = x1;
				for (int i = x1.length-x2.length;i < x1.length;i++) {
					m[1][i] = x2[i-(x1.length-x2.length)];
				}
				for (int i = m[0].length-1; i >= 0;i--) {
					if (m[0][i] >= m[1][i]) {
						m[2][i] = m[0][i] - m[1][i];
					}
					else {
						m[0][i-1]--;
						m[0][i] += 10;
						m[2][i] = m[0][i] - m[1][i];
					}
				}
				return arrayToString(m[2]);
			}
			else {
				return opposite(sott(b,a));
			}
		}
		if (isPositive(a) && !isPositive(b)) {
			return somma(a,opposite(b));
		}
		if (!isPositive(a) && isPositive(b)) {
			return sott(b,opposite(a));
		}
		if (!isPositive(a) && !isPositive(b)) {
			return sott(opposite(b),opposite(a));
		}
		return null;
	}

	public static String somma(String[] a) {
		String r = "0";
		for (int i = 0; i < a.length; i++) {
			r = somma(r,a[i]);
		}
		return r;
	}


	public static String somma(String a, String b) {				// esegue la somma di due stringhe
		if (isPositive(a) && isPositive(b)) {
			int l = Math.max(a.length(),b.length());
			int[] addendo1 = new int[l];
			int[] addendo2 = new int[l];
			int j = 0;
			for (int i = l-a.length(); i < l;i++) {
				addendo1[i] = Integer.parseInt(a.substring(j,j+1));
				j++;
			}
			j = 0;
			for (int i = l-b.length(); i < l;i++) {
				addendo2[i] = Integer.parseInt(b.substring(j,j+1));
				j++;
			}
			addendo1 = Array.inverso(addendo1);
			addendo2 = Array.inverso(addendo2);		
			int[] somma = new int[l+1];
			for (int i = 0; i < l; i++) {
				somma[i] = addendo1[i]+addendo2[i];
			}
			for (int i = 0; i < l; i++) {
				if (somma[i] > 9) {
					somma[i] = somma[i]-10;
					somma[i+1] = somma[i+1]+1;
				}
			}
			somma = Array.inverso(somma);
			String r = arrayToString(somma);
			r = togliZero(r);
			return r;
		}
		if (isPositive(a) && !isPositive(b)) {
			return sott(a,b);
		}
		if (!isPositive(a) && !isPositive(b)) {
			return opposite(somma(opposite(a),opposite(b)));
		}
		return null;
	}

	public static int cifra(int x, int a) {								//restituisce la cifra a di x
		if (Array.cifre(x).length-1 < a) {
			return 0;
		}
		else {
			return Array.cifre(x)[Array.cifre(x).length-a-1];
		}
	}

	public static boolean isPositive(String a) {
		if (a.substring(0,1).equals("-")) {
			return false;
		}
		else {
			return true;
		}
	}

	public static int cifra(String a, int i) {
		return Integer.parseInt(a.substring(i,i+1));
	}

	public static int[] periodo(String a) {						// restituisce il periodo di a
		String d = decimalDigits(a);
		if (d.length() < 100) {
			return null;
		}	
		int[] cifre = Array.stringToArray(a);
		int cifraInizio = 0;
		int limite = cifre.length;
		boolean found = false;
		int finePeriodo = 0;
		while (!found && cifraInizio < limite) {
			int limitePeriodo = (limite+cifraInizio)/2;
			finePeriodo = cifraInizio+1;
			while (finePeriodo < limitePeriodo && !repeats(cifre,cifraInizio,finePeriodo)) {
				finePeriodo++;
			}
			if (repeats(cifre,cifraInizio,finePeriodo)) {
				found = true;
			}
			cifraInizio++;
		}
		if (found) {
			int[] periodo = Array.copyOf(cifre,cifraInizio-1,finePeriodo);
			return periodo;
		}
		else {
			return null;
		}	
	}



	public static boolean isPeriodic(String a) {					// restituisce true se il numero e' periodico
		return (periodo(a) != null);
	}





	private static boolean repeats(int[] a, int inizio, int fine) {
		boolean r = true;
		int[] periodo = Array.copyOf(a,inizio,fine);
		int length = fine-inizio;
		inizio += length;
		fine += length;
		while (r && fine <= a.length) {
			if (!Array.equals(Array.copyOf(a,inizio,fine),periodo)) {
				r = false;
			}
			inizio += length;
			fine += length;
		}
		return r;
	}

	private static String decimalDigits(String a) {
		int i = 0;
		while (i < a.length() && !(a.substring(i,i+1).equals("."))) {
			i++;
		}
		if (i == a.length()) {
			return "";
		}
		else {
			return a.substring(i+1);
		}
	}

	private static String opposite(String a) {
		if (a.substring(0,1).equals("-")) {
			return a.substring(1);
		}
		else {
			String b = "-";
			b += a;
			return b;
		}
	}


	private static boolean greaterOrEqual(String a, String b) {
		if (isPositive(a) && isPositive(b)) {
			if (a.length() > b.length()) {
				return true;
			}
			if (b.length() > a.length()) {
				return false;
			}
			if (a.length() == b.length()) {
				int i = 0;
				while (i < a.length() && Integer.parseInt(a.substring(i,i+1)) == Integer.parseInt(b.substring(i,i+1))) {
					i++;
				}
				if (i == a.length()) {
					return true;
				}
				if (valueIndex(a,i) > valueIndex(b,i)) {
					return true;
				}
				if (valueIndex(b,i) > valueIndex(a,i)) {
					return false;
				}
			}
		}
		if (isPositive(a) && !isPositive(b)) {
			return true;
		}
		if (!isPositive(a) && isPositive(b)) {
			return false;
		}
		if (!isPositive(a) && !isPositive(b)) {
			return !greaterOrEqual(opposite(a),opposite(b));
		}
		return true;
	}

	private static int valueIndex(String a, int index) {
		return Integer.parseInt(a.substring(index,index+1));
	}

	public static String valoreAssoluto(String a) {
		if (!isPositive(a)) {
			return opposite(a);
		}
		else {
			return a;
		}
	}

	private static String togliZero(String a) {
		if (isPositive(a) && !a.equals("0")) {
			int j = 0;
			while (j < a.length() && a.substring(j,j+1).equals("0")) {
				j++;
			}
			return a.substring(j);
		}
		else {
			if (a.equals("0")) {
				return a;
			}
			if (!isPositive(a) && !a.equals("-0")) {
				int j = 1;
				while (j < a.length() && a.substring(j,j+1).equals("0")) {
					j++;
				}
				return "-"+a.substring(j);
			}
			else {
				return "0";
			}
		}
	}

	private static int[] semplificazione(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 9) {
				a[i+1] += (a[i]/10);
				a[i] -= ((a[i]/10)*10);
			}
		}
		return a;
	}

	private static String precedente(String a) {
		int i = 0;
		while (Integer.parseInt(a.substring(a.length()-i-1,a.length()-i)) == 0) {
			if (i == 0) {
				a = a.substring(0,a.length()-i-1) + Integer.toString(9);
			}
			else {
				a = a.substring(0,a.length()-i-1) + Integer.toString(9) + a.substring(a.length()-i);
			}
			i ++;
		}

		if (i == 0) {
			a = a.substring(0,a.length()-i-1) + Integer.toString(Integer.parseInt(a.substring(a.length()-i-1,a.length()-i))-1);
		}
		else {
			a = a.substring(0,a.length()-i-1) + Integer.toString(Integer.parseInt(a.substring(a.length()-i-1,a.length()-i))-1) + a.substring(a.length()-i);	
		}
		a = togliZero(a);
		return a;
	}
}