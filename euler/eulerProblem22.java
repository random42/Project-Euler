package euler;

// Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by 
//its alphabetical position in the list to obtain a name score.

// For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

// What is the total of all the name scores in the file?


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class eulerProblem22 {

	public static String fileToString(File x) throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
		Scanner input = new Scanner(x);
		String a = input.nextLine();
		input.close();
		return a;
	}

	public static String[] listFromString(String c, String separator) {
		int[] sep = new int[c.length()];
		int j = 0;
		for (int i = 0; i < c.length(); i ++) {
			if (c.substring(i,i+1).equals(separator)) {
				sep[j] = i;
				j++;
			}
		}
		sep[j] = c.length();
		sep = Arrays.copyOf(sep,j+1);
		String[] nomi = new String[j+1];
		nomi[0] = c.substring(0,sep[0]);
		for (int i = 1; i <= j; i++) {
			nomi[i] = c.substring(sep[i-1]+1,sep[i]);
		}
		return nomi;
	}

	private static int alphabeticalValue(String a) {
		int r = 0;
		for (int i = 0; i < a.length();i++) {
			r += (int)(a.charAt(i)) - 64;
		}
		return r;
	}

	public static int nameScore(String[] a, int i) {
		return (i+1)*alphabeticalValue(a[i]);
	}

	private static int maxIndex(String[] a) {
		int index = 0;
		for (String e : a) {
			if (index < e.length()-1) {
				index = e.length()-1;
			}
		}
		return index;
	}



	public static boolean rightWord(String a, int index) {
		return a.length() > index;
	}
	
	private static int[] indiciLettere(String[] a, int index) {
		if (index == 0) {
			int lettera = a[0].charAt(index);
			int[] r = new int[a.length+1];
			r[0] = 0;
			int counter = 1;
			for (int i = 0;i < a.length;i++) {
				if (a[i].charAt(index) > lettera) {
					lettera = a[i].charAt(index);
					r[counter] = i;
					counter++;
				}
			}
			r[counter] = a.length;
			r = Arrays.copyOf(r,counter+1);
			return r;
		}
		else {
			int[] r = new int[a.length+1];
			r[0] = 0;
			int counter = 1;
			int[] prev = indiciLettere(a,index-1);
			for (int i = 0;i < prev.length-1;i++) {
				int c = 0;
				for (int h = prev[i];h < prev[i+1] && !rightWord(a[h],index);h++) {
					c++;
				}
				if (c == prev[i+1]-prev[i]) {
					r[counter] = prev[i+1];
					counter++;
				}
				
				if (c < prev[i+1]-prev[i]) {
					int lettera = a[prev[i]+c].charAt(index);
				
					for (int j = prev[i]+c;j < prev[i+1];j++) {
						if (a[j].charAt(index) > lettera) {
							lettera = a[j].charAt(index);
							r[counter] = j;
							counter++;
						}
						if (j == prev[i+1]-1) {
							r[counter] = j+1;
							counter++;
						}
					}
				}
			}
			r = Arrays.copyOf(r,counter);
			return r;
		}

	}

	public static String[] alphabeticalSort(String[] a) {
		int index = 0;
		a = sort(a,index,0,a.length);
		int[] indexes = indiciLettere(a,index);
		while (index <= maxIndex(a)) {
			index++;
			for (int i = 0;i < indexes.length-1; i++) {
				if (indexes[i] != indexes[i+1]-1) {
					a = sort(a,index,indexes[i],indexes[i+1]);
				}
			}
			indexes = indiciLettere(a,index);
		}
		return a;
	}

	public static String[] sort(String[] a, int index, int start, int end) {
		String[] b = new String[a.length];
		b = Arrays.copyOf(a,a.length);
		int counter = start;
		for (int i = start;i < end;i++) {
			if (a[i].length() <= index) {
				b[counter] = a[i];
				counter++;
			}
		}
		for (int i = 65;i < 91;i++) {
			for (int j = start; j < end;j++) {
				if (a[j].length() > index && a[j].charAt(index) == i) {
					b[counter] = a[j];
					counter++;
				}
			}
		}
		return b;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
		 File text = new File("/Users/random/Downloads/names.txt");
		 String c = fileToString(text);
		 c = c.replaceAll("\"","");
		 String[] nomi = listFromString(c,",");
		 nomi = alphabeticalSort(nomi);
		 long r = 0;
		 for (int i = 0;i < nomi.length;i++) {
		 	r += (long)nameScore(nomi,i);
		 }
		 System.out.println(r);

	}
}