package euler;
import mypackage.*;

// A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

// 012   021   102   120   201   210

// What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

public class eulerProblem24 {		//RISOLTO

	public static void main(String[] args) {
		int[] x = {0,1,2,3,4,5,6,7,8,9};
		Array.print(nLexicoPermutation(x,1000000));
	}

	public static int[] nLexicoPermutation(int[] x, int th) {		
		int[] y = new int[x.length];
		for (int i = 0;i < x.length;i++) {
			y[i] = x[i];
		}
		for (int i = 1;i < th;i++) {
			int index = y.length-2;
			while (!mustChange(y,index)) {
				index--;
			}
			int change = indexOfminGreaterNumber(y,index);
			int valueChange = y[change];
			y[change] = y[index];
			y[index] = valueChange;
			y = crescentSort(y,index);
		}
		return y;
	}

	private static int[] crescentSort(int[] x, int index) {
		int[] r = new int[x.length];
		int copia = 0;
		for (int e : x) {
			r[copia] = e;
			copia++;
		}
		int[] y = new int[r.length-index-1];
		int counter = 0;
		for (int i = index+1;i < r.length;i++) {
			y[counter] = r[i];
			counter++;
		}
		y = crescentSort(y);
		counter = 0;
		for (int i = index+1;i < r.length;i++) {
			r[i] = y[counter];
			counter++;
		}
		return r;
	}

	private static int[] crescentSort(int[] x) {
		if (x.length <= 1) {
			return x;
		}
		else {
			int max = x[0];
			for (int e : x) {
			if (max < e) {
				max = e;
				}
			}
			int[] y = new int[max+1];
			for (int i = 0; i < x.length;i++) {
				y[x[i]]++;
			}
			int[] r = new int[x.length];
			int counter = 0;
			for (int i = 0; i < y.length;i++) {
				while (y[i] > 0) {
					r[counter] = i;
					counter++;
					y[i]--;
				}
			}
			return r;
		}
		
	}

	private static int indexOfminGreaterNumber(int[] x, int index) {
		int r = x.length;
		int risultato = 0;
		int i = index+1;
		while (i < x.length) {
			if (x[i] > x[index] && x[i] < r) {
				r = x[i];
				risultato = i;
			}
			i++;
		}
		return risultato;
	}

	private static boolean mustChange(int[] x,int index) {
		boolean c = false;
		int i = index+1;
		while (!c && i < x.length) {
			if (x[i] > x[index]) {
				c = true;
			}
			i++;
		}
		return c;
	}
}