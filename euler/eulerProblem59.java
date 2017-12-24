package euler;
import java.io.*;

public class eulerProblem59 {   // SOLVED

  private static int[] decrypt(int[] val, int[] key) {
    int j = 0;
    int[] ret = new int[val.length];
    for (int i = 0;i < val.length;i++) {
      ret[i] = val[i] ^ key[j];
      j++;
      if (j == key.length) {
        j = 0;
      }
    }
    return ret;
  }

  private static String asciiToString(int[] ascii) {
    String r = "";
    for (int i = 0; i < ascii.length;i++) {
      r += (char)ascii[i];
    }
    return r;
  }

  private static int[] stringToAscii(String x) {
    int[] r = new int[x.length()];
    for (int i = 0;i < r.length;i++) {
      r[i] = (int)x.charAt(i);
    }
    return r;
  }

  private static int[] asciiFromFile(String x) {
    try {
      FileReader in = new FileReader(new File(x));
      BufferedReader input = new BufferedReader(in);
      String num = "";
      String file = input.readLine();
      int i = 0;
      char a;
      int j = 0;
      int[] ascii = new int[file.length()];
      while (i < file.length()) {
        a = file.charAt(i);
        if (a != ',') {
          num += a;
        }
        else {
          ascii[j] = Integer.parseInt(num);
          num = "";
          j++;
        }
        i++;
      }
      if (num.length() > 0) {
        ascii[j] = Integer.parseInt(num);
      }
      int h = 0;
      for (h = ascii.length-1;h >= 0 && ascii[h] == 0;h--) {}
      if (h >= 0 && h != ascii.length-1) {
        int[] ret = new int[h+1];
        for (int k = 0;k < ret.length;k++) {
          ret[k] = ascii[k];
        }
        return ret;
      }
      return ascii;
    }
    catch (FileNotFoundException b){
      System.out.println("File not found.");
    }
    catch (IOException b) {
      System.out.println("IO Exception");
    }
    return null;
  }

  private static int sumOfAscii(int[] ascii) {
    int sum = 0;
    for (int i = 0;i < ascii.length; i++) {
      sum += ascii[i];
    }
    return sum;
  }

  private static String getNext(String key) {
    char[] s = new char[key.length()];
    for (int i = 0;i < s.length;i++) {
      s[i] = key.charAt(i);
    }
    boolean finished = false;
    int j = s.length-1;
    while (!finished && j >= 0) {
      if (s[j] == 'z') {
        s[j] = 'a';
        j--;
      }
      else {
        s[j]++;
        finished = true;
      }
    }
    String ret = "";
    for (int i = 0;i < s.length;i++) {
      ret += s[i];
    }
    return ret;
  }

  private static double controlAscii(int[] ascii) {
    boolean r = true;
    int count = 0;
    for (int i = 0;i < ascii.length && r;i++) {
      if (isLetter((char)ascii[i])) {
        count++;
      }
    }
    double letterPercentage = (double)count / (double)ascii.length;
    return letterPercentage;
  }

  private static boolean isLetter(char a) {
    return (a > 64 && a < 91) || (a > 96 && a < 123);
  }

  private static void tryKeys(int[] ascii) {
    String key = "aaa";
    int[] originalAscii = decrypt(ascii,stringToAscii(key));
    boolean r = false;
    int[][] allDecrypted = new int[(int)Math.pow(26,3)][];
    allDecrypted[0] = originalAscii;
    int i = 1;
    while (!key.equals("zzz")) {
      key = getNext(key);
      originalAscii = decrypt(ascii,stringToAscii(key));
      allDecrypted[i] = originalAscii;
      i++;
    }
    boolean enough = false;
    double minimumPercentage = 0.5;
    int[][] solutions = new int[10][];
    int count = 0;
    while (!enough) {
      count = 0;
      solutions = new int[15][];
      for (int k = 0; k < allDecrypted.length && count < 11;k++) {
        if (controlAscii(allDecrypted[k]) >= minimumPercentage) {
          solutions[count] = allDecrypted[k];
          count++;
        }
      }
      if (count > 10 ) {
        minimumPercentage += 0.01;
      }
      else {
        enough = true;
      }
    }
    for (int[] sol : solutions) {
      if (sol != null) {
        System.out.println(asciiToString(sol));
        System.out.println();
        System.out.println("Sum of the ASCII values: " + sumOfAscii(sol));
        System.out.println();
        System.out.println("Percentage of letters: " + (controlAscii(sol)*100) + "%");
        System.out.println();
      }
    }
    System.out.println("Minimum percentage of letters in ASCII code: " + (minimumPercentage*100) + "%");
    System.out.println();
  }


  public static void main(String[] args) {
    int[] ascii = asciiFromFile("/Users/random/Downloads/p059_cipher.txt");
    tryKeys(ascii);
  }
}
