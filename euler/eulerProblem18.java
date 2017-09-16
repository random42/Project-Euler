// By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

// 3
// 7 4
// 2 4 6
// 8 5 9 3

// That is, 3 + 7 + 4 + 9 = 23.

// Find the maximum total from top to bottom of the triangle below:

// 75
// 95 64
// 17 47 82
// 18 35 87 10
// 20 04 82 47 65
// 19 01 23 75 03 34
// 88 02 77 73 07 63 67
// 99 65 04 28 06 16 70 92
// 41 41 26 56 83 40 80 70 33
// 41 48 72 33 47 32 37 16 94 29
// 53 71 44 65 25 43 91 52 97 51 14
// 70 11 33 28 77 73 17 78 39 68 17 57
// 91 71 52 38 17 14 91 43 58 50 27 29 48
// 63 66 04 68 89 53 67 30 73 16 69 87 40 31
// 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

// NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)

public class eulerProblem18 {		//RISOLTO

	public static int[][] matrix(String a) {
		int[][] matrix = new int[15][15];
		int r = 0;
		for (int i = 0; i < 15; i ++) {
			for (int h = 0; h <= i; h ++) {
				matrix[i][h] = Integer.parseInt(a.substring(r,r+2));
				r += 3;
			}
		}
		return matrix;
	}

	// public static int[][] routes(int x) {
	// 	int[][] r = new int[(int)Math.pow(2,x)][x];
	// 	int i = 1;
	// 	while (i < r.length) {
	// 		r[i] = r[i-1];
	// 		int h = 1;
	// 		while (r[i][x-h] == 1) {
	// 			h += 1;
	// 		}
	// 		r[i][x-h] = 1;
	// 		h -= 1;
	// 		while (h >= 1) {
	// 			r[i][x-h] = 0;
	// 			h -= 1;
	// 		}
	// 		i += 1;
	// 	}
	// 	return r;
	// }

	public static int maxSum(int[][] x) {
		int[][] route = routes(x.length-1);
		int somma = 0;
		int max = 0;
		int scelta;
		int[] bestChoice = new int[x.length-1];
		for (int i = 0; i < route.length; i ++) {
			somma = x[0][0];
			scelta = 0;
			for (int h = 0; h < route[0].length; h ++) {
				scelta += route[i][h];
				somma += x[h+1][scelta];
			}
			if (max < somma) {
				max = somma;
				bestChoice = route[i];
			}
		}
		array.print(bestChoice);
		return max;
	}

	public static int[][] routes(int x) {
		String[] bin = new String[(int)Math.pow(2,x)];
		for (int i = 0; i < bin.length; i++) {
			bin[i] = Integer.toBinaryString(i);
		}
		int[][] route = new int[bin.length][x];
		for (int i = 0; i < route.length; i ++) {
			for (int h = 0; h < bin[i].length(); h ++) {
				route[i][x-bin[i].length()+h] = Integer.parseInt(bin[i].substring(h,h+1));
			}
		}
		return route;
	}


	public static void main(String[] args) {
		String a = "75 95 64 17 47 82 18 35 87 10 20 04 82 47 65 19 01 23 75 03 34 88 02 77 73 07 63 67 99 65 04 28 06 16 70 92 41 41 26 56 83 40 80 70 33 41 48 72 33 47 32 37 16 94 29 53 71 44 65 25 43 91 52 97 51 14 70 11 33 28 77 73 17 78 39 68 17 57 91 71 52 38 17 14 91 43 58 50 27 29 48 63 66 04 68 89 53 67 30 73 16 69 87 40 31 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23 ";
		int[][] matrix = matrix(a);
		array.matrixPrint(matrix);
		System.out.println(maxSum(matrix));

	}
}