package mypackage;
import java.util.*;

public class Array {

	public static void main (String[] args) {			//MAIN
	}

	public static int valueOfDigits(int[] cifre) {
		int esponente = 0;
		int potenza = Aritmetica.pow(10,esponente);
		int risultato = 0;
		int j = cifre.length-1;
		while (esponente < cifre.length) {
			potenza = Aritmetica.pow(10,esponente);
			risultato += potenza*cifre[j];
			esponente++;
			j--;
		}
		return risultato;
	}

	public static int[] copyOf(int[] a, int start, int end) {	//restituisce un array con gli elementi di a da start a end
		int[] r = new int[end-start];
		for (int i = start;i < end;i++) {
			r[i-start] = a[i];
		}
		return r;
	}

	public static long[] copyOf(long[] a, int start, int end) {	
		long[] r = new long[end-start];
		for (int i = start;i < end;i++) {
			r[i-start] = a[i];
		}
		return r;
	}

	public static int[] copyOf(int[] a, int b) {				//restituisce l'array con i primi b elementi di a
		int[] r = new int[b];
		for (int i = 0;i < b;i++) {
			r[i] = a[i];
		}
		return r;
	}

	public static long[] copyOf(long[] a, int b) {	
		long[] r = new long[b];
		for (int i = 0;i < b;i++) {
			r[i] = a[i];
		}
		return r;
	}

	public static int[] stringToArray(String a) {				//converte un numero stringa nel suo array di cifre
		int[] x = new int[a.length()];
		int i = 0;
		if (!Aritmetica.isPositive(a)) {
			x[0] = -1;
			i++;
		}
		while (i < a.length()) {
			if (a.substring(i,i+1).equals(".")) {
				x[i] = -2;
			}
			else {
				x[i] = Integer.parseInt(a.substring(i,i+1));
			}
			i++;
		}
		return x;			
	}

	public static void print(int[][] a) {					//printa matrice int[][]
		int m = 0;
		int n = 0;
		while (m < a.length) {  
			n = 0;               
			while (n < a[0].length) {
				if (n < a[0].length-1) {
					System.out.print(a[m][n]+" ");
				}
				else System.out.println(a[m][n]);
				n += 1;
			}
			m += 1;
		}
	}

	public static void print(String[] a) {				//printa array String[]
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void print(int[] array) {						//printa array int[]
		int i = 0;
		System.out.print("{");
		while (i < array.length) {                 
			if (i == array.length-1) {
				System.out.println(array[i]+"}");
			}
			else {
				System.out.print(array[i]);
				System.out.print(", ");
			}
			i = i + 1;
		}
	}

	public static void print(double[] array) {						//printa array double[]
		int i = 0;
		System.out.print("{");
		while (i < array.length) {                 
			if (i == array.length-1) {
				System.out.println(array[i]+"}");
			}
			else {
				System.out.print(array[i]);
				System.out.print(", ");
			}
			i = i + 1;
		}
	}


	public static void print(long[] array) {					//printa array long[]
		int i = 0;
		System.out.print("{");
		while (i < array.length) {                 
			if (i == array.length-1) {
				System.out.println(array[i]+"}");
			}
			else {
				System.out.print(array[i]);
				System.out.print(", ");
			}
			i = i + 1;
		}
	}


	public static long[] create() {								//crea array a piacimento
		Scanner in = new Scanner(System.in);
		System.out.println("Quanto vale la dimensione dell'array?");
		int x = in.nextInt();
		long[] array = new long[x];
		for (int i = 0; i < x; i++) {
			System.out.println("Scrivi il numero nella posizione " + (i+1));
			array[i] = in.nextLong();
		}
		in.close();
		return array;
	}

	public static int[] colMatrice(int[][] m, int r) {			//restituisce la colonna r della matrice m
		int[] col = new int[m.length];
		for (int i = 0; i < m.length;i++) {
			col[i] = m[i][r];
		}
		return col;
	}

	public static double[] colMatrice(double[][] m, int r) {
		double[] col = new double[m.length];
		for (int i = 0; i < m.length;i++) {
			col[i] = m[i][r];
		}
		return col;
	} 



	public static int max(int[] a) {							//restituisce il massimo intero di un array
		if (a.length == 1) {
			return a[0];
		}
		else {
			if (max(sinistra(a)) >= max(destra(a))) {
				return max(sinistra(a));
			}
			else {
				return max(destra(a));
			}
		}
	}


	public static int[] sinistra(int[] a) {						//prima meta' dell'array
		assert a.length > 1;
		int[] b = new int[a.length/2];
		for (int c = 0; c < a.length/2; c++) {
			b[c] = a[c];
		}
		return b;
	}

	public static int[] destra(int[] a) {						//seconda meta' dell'array
		assert a.length > 1;
		int d = 0;
		int[] b = new int[a.length-(sinistra(a).length)];
		for (int c = a.length/2; c < a.length; c++) {
			b[d] = a[c];
			d += 1;
		}
		return b;
	}

	public static int[] cifre(int a) {							//crea un array con le cifre di un intero
		int cifre = 0;
		while (a/((int)(Math.pow(10, cifre))) >= 1) {
			cifre += 1;
		}
		int potenza = cifre-1;
		int[] arrayCifre = new int[cifre];
		int counter = 0;
		while (counter <= cifre-1) {
			arrayCifre[counter] = a/((int)(Math.pow(10, potenza)));
			counter += 1;
			a = a-(a/((int)(Math.pow(10, potenza)))*((int)(Math.pow(10, potenza))));
			potenza -= 1;
		}
		return arrayCifre;
	}

	public static long[] cifre(long a) {						//crea un array con le cifre di un intero long
		int cifre = 0;
		while (a/((long)(Math.pow(10, cifre))) >= 1) {
			cifre += 1;
		}
		int potenza = cifre-1;
		long[] arrayCifre = new long[cifre];
		int counter = 0;
		while (counter <= cifre-1) {
			arrayCifre[counter] = a/((long)(Math.pow(10, potenza)));
			counter += 1;
			a = a-(a/((long)(Math.pow(10, potenza)))*((long)(Math.pow(10, potenza))));
			potenza -= 1;
		}
		return arrayCifre;
	}

	public static int[] inverso(int[] a) {						//inverte l'ordine degli elementi di un array
		int c = a.length-1;
		int[] b = new int[a.length];
		for (int i =0; i < a.length; i++) {
			b[i] = a[c-i];
		}
		return b;
	}

	public static int[] primes(int x) {							//crea array con i primi x numeri primi
		int[] primes = new int[x];
		if (x > 0) {
			primes[0] = 2;
		}
		if (x > 1) {
			primes[1] = 3;
		}
		if (x > 2) {
			primes[2] = 5;
		}
		int counter0 = 3;
		int p = 7;
		int counter1 = 0;
		while (counter0 < x) {
			counter1 = 0;
			while (counter1 < counter0 && p % primes[counter1] != 0) {
				counter1 += 1;
			}
			if (counter1 == counter0) {
				primes[counter0] = p;
				counter0 += 1;
			}
			p += 2;
		}
		return primes;
	}

	public static long[] primesTo(long x) {						//crea array con numeri primi fino a x
		long[] primes = new long[(int)x/2+1];
		if (x < 5) {
			if (x < 2) {
				return null;
			}
			if (x == 2) {
				primes[0] = 2;
				primes = Array.copyOf(primes,1);
				return primes;
			}
			primes[0] = 2;
			primes[1] = 3;
			primes = Array.copyOf(primes,2);
			return primes;
		}
		primes[0] = 2;
		primes[1] = 3;
		primes[2] = 5;
		int counter0 = 3;
		long p = 7;
		int counter1 = 0;
		while (counter0 < x/2+1 && p <= x) {
			counter1 = 0;
			boolean isPrime = p % primes[counter1] != 0;
			while (primes[counter1] <= p/2 && isPrime) {
				isPrime = p % primes[counter1] != 0;
				counter1 += 1;
			}
			if (isPrime) {
				primes[counter0] = p;
				counter0 += 1;
			}
			p += 2;
		}
		primes = Array.copyOf(primes, counter0);
		return primes;
	}

	public static int[] primesTo(int x) {	
		int[] primes = new int[x/2+1];
		if (x < 5) {
			if (x < 2) {
				return null;
			}
			if (x == 2) {
				primes[0] = 2;
				primes = Array.copyOf(primes,1);
				return primes;
			}
			primes[0] = 2;
			primes[1] = 3;
			primes = Array.copyOf(primes,2);
			return primes;
		}
		primes[0] = 2;
		primes[1] = 3;
		primes[2] = 5;
		int counter0 = 3;
		int p = 7;
		int counter1 = 0;
		while (counter0 < x/2+1 && p <= x) {
			counter1 = 0;
			boolean isPrime = p % primes[counter1] != 0;
			while (primes[counter1] <= p/2 && isPrime) {
				isPrime = p % primes[counter1] != 0;
				counter1 += 1;
			}
			if (isPrime) {
				primes[counter0] = p;
				counter0 += 1;
			}
			p += 2;
		}
		primes = Array.copyOf(primes, counter0);
		return primes;
	}

	public static long[] fattoriPrimi(long x) {					//restituisce array con i fattori primi di x
		int c = (int)x/2+2;
		long[] fattori = new long[c];
		long prime = 2;
		int countFattori = 0;
		int countPrimes = 2;
		long[] primes = new long[c];
		while (x > 1 && prime == 2) {
			if (x%prime == 0) {
				x = x/prime;
				fattori[countFattori] = prime;
				countFattori += 1;
			}
			else {
				prime += 1;
			}
		}
		primes[0] = 2;
		primes[1] = 3;
		while (x > 1) {
			if (x%prime == 0) {
				x = x/prime;
				fattori[countFattori] = prime;
				countFattori += 1;
			}
			else {
				boolean h = false;
				while (h == false) {
					prime += 2;
					int s = 0;
					while (s < countPrimes && prime%primes[s] != 0) {
						s += 1;
					}
					if (s == countPrimes) {
						primes[s] = prime;
						countPrimes += 1;
						h = true;
					}
				} 
			}
		}
		fattori = Arrays.copyOf(fattori, countFattori);
		return fattori;
	}

	public static int[] fattoriPrimi(int x) {
		int c = x/2+2;
		int[] fattori = new int[c];
		int prime = 2;
		int countFattori = 0;
		int countPrimes = 2;
		int[] primes = new int[c];
		while (x > 1 && prime == 2) {
			if (x%prime == 0) {
				x = x/prime;
				fattori[countFattori] = prime;
				countFattori += 1;
			}
			else {
				prime += 1;
			}
		}
		primes[0] = 2;
		primes[1] = 3;
		while (x > 1) {
			if (x%prime == 0) {
				x = x/prime;
				fattori[countFattori] = prime;
				countFattori += 1;
			}
			else {
				boolean h = false;
				while (h == false) {
					prime += 2;
					int s = 0;
					while (s < countPrimes && prime%primes[s] != 0) {
						s += 1;
					}
					if (s == countPrimes) {
						primes[s] = prime;
						countPrimes += 1;
						h = true;
					}
				} 
			}
		}
		fattori = Arrays.copyOf(fattori, countFattori);
		return fattori;
	}

	public static boolean equals(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		else {
			boolean r = true;
			for (int i = 0; i < a.length;i++) {
				if (a[i] != b[i]) {
					r = false;
				}
			}
			return r;
		}		// controlla se due array sono identici
	}

	public static int[] fusione(int[] a, int[] b) {
		int[] c = new int[a.length+b.length];
		int i = 0;
		while (i < c.length) {
			if (i < a.length) {
				c[i] = a[i];
			}
			else {
				c[i] = b[i-a.length];
			}
			i++;
		}
		return c;			// concatena due array
	}

	public static boolean binarySearch(int x, int[] array) {
		return binarySearch(x,array,0,array.length);		//cerca un numero in un array ordinato
	}

	private static boolean binarySearch(int x, int[] array, int start, int end) {
		int medium = (start+end)/2;
		if (end-start == 1) {
			if (x == array[start]) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (x == array[medium]) {
				return true;
			}
			if (x > array[medium]) {
				return binarySearch(x,array,medium,end);
			}
			else {
				return binarySearch(x,array,start,medium);
			}
		}
	}






}