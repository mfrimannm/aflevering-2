import java.util.Scanner;

public class Opgave1Afleveret {

	public static void main(String[] args) {
		System.out.print(RomanNumerals());
	}

	static String RomanNumerals() {
		// denne funktion opdeler et tal i 1000, 900 500... osv. et tal skal
		// deles op i.
		// Derefter printer den tallene ud til en string som returnes.
		System.out.print("Hvilket nummer vil du gerne have omskrevet til romertal? ");
		System.out.println("Tallet må ikke være større end 3999 og mindre end 1.");
		Scanner scanner = new Scanner(System.in);
		int numbertobeconverted = scanner.nextInt();
		scanner.close();
		if (numbertobeconverted > 3999) {
			System.out.println("Tallet skal være mindre end 3999, programmet afsluttes");
			System.exit(1);
		} else if (numbertobeconverted < 0) {
			System.out.println("Tallet skal være større end 1, programmet afsluttes");
			System.exit(2);
		}

		// Her undersøges tallet som skal konverteres, hvis tallet er mindre
		// end 1 kan denne funktion ikke konvertere det til romertal
		if (numbertobeconverted >= 1) {
			String convertedtoroman = "";
			int numberofM = 0;
			int numberofCM = 0;
			int numberofD = 0;
			int numberofCD = 0;
			int numberofC = 0;
			int numberofXC = 0;
			int numberofL = 0;
			int numberofXL = 40;
			int numberofX = 0;
			int numberofIX = 9;
			int numberofV = 0;
			int numberofIV = 0;
			int numberofI = 0;
			int M = 1000;
			int CM = 900;
			int D = 500;
			int CD = 400;
			int C = 100;
			int XC = 90;
			int L = 50;
			int XL = 40;
			int X = 10;
			int IX = 9;
			int V = 5;
			int IV = 4;
			int I = 1;

			// Her foregår opdelingen af de forskellige tal. Det foregår ved at
			// vi først
			// finder ud af hvor mange 1000 der er i tallet, herefter hvor mange
			// 900
			numberofM = numbertobeconverted / M;
			numbertobeconverted = numbertobeconverted % M;
			numberofCM = numbertobeconverted / CM;
			numbertobeconverted = numbertobeconverted % CM;
			numberofD = numbertobeconverted / D;
			numbertobeconverted = numbertobeconverted % D;
			numberofCD = numbertobeconverted / CD;
			numbertobeconverted = numbertobeconverted % CD;
			numberofC = numbertobeconverted / C;
			numbertobeconverted = numbertobeconverted % C;
			numberofXC = numbertobeconverted / XC;
			numbertobeconverted = numbertobeconverted % XC;
			numberofL = numbertobeconverted / L;
			numbertobeconverted = numbertobeconverted % L;
			numberofXL = numbertobeconverted / XL;
			numbertobeconverted = numbertobeconverted % XL;
			numberofX = numbertobeconverted / X;
			numbertobeconverted = numbertobeconverted % X;
			numberofIX = numbertobeconverted / IX;
			numbertobeconverted = numbertobeconverted % IX;
			numberofV = numbertobeconverted / V;
			numbertobeconverted = numbertobeconverted % V;
			numberofIV = numbertobeconverted / IV;
			numbertobeconverted = numbertobeconverted % IV;
			numberofI = numbertobeconverted / I;
			numbertobeconverted = numbertobeconverted % I;

			convertedtoroman = adding(numberofM, "M");
			convertedtoroman = convertedtoroman + adding(numberofCM, "CM");
			convertedtoroman = convertedtoroman + adding(numberofD, "D");
			convertedtoroman = convertedtoroman + adding(numberofCD, "CD");
			convertedtoroman = convertedtoroman + adding(numberofC, "C");
			convertedtoroman = convertedtoroman + adding(numberofXC, "XC");
			convertedtoroman = convertedtoroman + adding(numberofL, "L");
			convertedtoroman = convertedtoroman + adding(numberofXL, "XL");
			convertedtoroman = convertedtoroman + adding(numberofX, "X");
			convertedtoroman = convertedtoroman + adding(numberofIX, "IX");
			convertedtoroman = convertedtoroman + adding(numberofV, "V");
			convertedtoroman = convertedtoroman + adding(numberofIV, "IV");
			convertedtoroman = convertedtoroman + adding(numberofI, "I");
			return ("Dit input giver " + convertedtoroman + " når det er skrevet med romertal");
		} else if (numbertobeconverted == 0) {
			return ("Dit input giver NULLA når det er skrevet med romertal");
		} else
			return ("Dette input er ikke lovligt for denne metode");
	}

	private static String adding(int times, String letter) {
		// Skriver letter, times gange uden mellemrum
		String Z = "";
		for (int i = 1; i <= times; i++) {
			Z = Z + letter;
		}
		return Z;
	}
}