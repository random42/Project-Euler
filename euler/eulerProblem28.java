package euler;
import mypackage.*;

// Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:

// 21 22 23 24 25
// 20  7  8  9 10
// 19  6  1  2 11
// 18  5  4  3 12
// 17 16 15 14 13

// It can be verified that the sum of the numbers on the diagonals is 101.

// What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?

public class eulerProblem28 {
	public static void main(String[] args) {
		int[][] matrix = new int[1001][1001];
		matrix = fillMatrice(matrix);
		int somma = 0;
		for (int i = 0;i < matrix.length;i++) {
			somma += matrix[i][i];
		}
		for (int i = 0;i < matrix.length;i++) {
			somma += matrix[i][matrix.length-i-1];
		}
		somma--;
		System.out.println(somma);
		
	}
	public static int[][] fillMatrice(int[][] mtx) {
		int number = mtx.length*mtx.length;
		int[] coo = {0,mtx.length-1};
		int[] dir = {0,-1};
		while (number > 0) {
			mtx[coo[0]][coo[1]] = number;
			if (coo[0]+dir[0] < 0 || coo[0]+dir[0] >= mtx.length || coo[1]+dir[1] < 0 || coo[1]+dir[1] >= mtx.length || mtx[coo[0]+dir[0]][coo[1]+dir[1]] > number) {
				dir = changeDirezione(dir);
			}
			coo[0] += dir[0];
			coo[1] += dir[1];
			number--;
		}
		return mtx;
	}

	// (0,1) == destra
	// (-1,0) == su
	// (0,-1) == sinistra
	// (1,0) == giu'
	private static int[] changeDirezione(int[] a) {
		if (a[0] == 0) {
			if (a[1] == 1) {
				a[0] = -1;
				a[1] = 0;
			}
			else {
				a[1] = 0;
				a[0] = 1;
			}
		}
		else {
			if (a[0] == 1) {
				a[0] = 0;
				a[1] = 1;
			}
			else {
				a[1] = -1;
				a[0] = 0;
			}
		}
		return a;
	}
}