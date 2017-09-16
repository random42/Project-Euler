// You are given the following information, but you may prefer to do some research for yourself.

// 1 Jan 1900 was a Monday.
// Thirty days has September,
// April, June and November.
// All the rest have thirty-one,
// Saving February alone,
// Which has twenty-eight, rain or shine.
// And on leap years, twenty-nine.
// A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
// How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

public class eulerProblem19 { 			//RISOLTO
	
	public static boolean bisestile(int anno) {
		if (anno%4 == 0) {
			if (anno%100 == 0) {
				if (anno%400 == 0) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		int anno = 1900;
		int dayOfWeek = 1;
		int sundays = 0;
		int[][] date = new int[171][3];
		int countDate = 0;
		while (anno <= 2000) {								//anni
			if (bisestile(anno)) {
				months[1] = 29;
			}
			else {
				months[1] = 28;
			}
			for (int i = 0; i < months.length;i++) {		//mesi
				for (int j = 1; j <= months[i];j++) {		//giorni
					if (dayOfWeek == 7 && j == 1 && anno > 1900) {		// il giorno della settimana e' giusto
						sundays += 1;
						date[countDate][0] = j;
						date[countDate][1] = i+1;
						date[countDate][2] = anno;
						countDate++;
					}									// il giorno della settimana += 1
					if (dayOfWeek == 7) {
						dayOfWeek = 1;
					}
					else {
						dayOfWeek ++;
					}
				}
			}
			anno ++;
		}
		array.matrixPrint(date);
		System.out.println(sundays);
	}
}