import java.util.Scanner;

public class Opgave1 {

	public static void main(String[] args) {
		// skrevet af Mads
		// String answar = "y";
		// while (answar.charAt(0) == 'y') {
		// her indtastests det nummer man gerne vil konverterer.
		String romeTypes = consoleInputConvertToRome();
		// Dette tal som lige er konverteret skrives ud til consolen.
		System.out.println(romeTypes);
		// Scanner scan = new Scanner(System.in);
		// System.out.print("Skal jeg foresætte y/n? ");
		// answar = scan.next();
		// scan.close();
		// }

	}

	private static String consoleInputConvertToRome() {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out
				.println("Du kan nu indtaste et tal og få dette konverteret til det Romerske tal");
		System.out
				.println("Tallet kan være mellem 0 og 3999, grunden til dette er begrænsninger i selve difinitionen på Romertal.");
		System.out.println("Skriv tal her: ");
		int num = scan.nextInt();
		System.out.println("Tallet der vil blive konvertret er: " + num);
		
		if(num < 0 || num >3999){
			scan.close();
			throw new IllegalArgumentException("Du har givet et tal mindre end 0 eller mere end 3999, dette er ikke acceptapelt.");
		}

		// kalder metoden som laver konverteringen, denne tager tallet man lige
		// har indtastet og retunerer en String med tallet.
		String romer = konverterNummer(num);

		scan.close();
		return romer;
	}

	private static String konverterNummer(int i) {
		// skrevet af Mads
		String s = "";

		if (i == 0) {
			return s = "NULLA";
		}

		int division = 1000;
		int antal = 0;
		String divisionTegnOver = "";
		String divisionTegnMellemOver = "";
		String divisionTegn = "M";
		
		while (i != 0) {
			antal = tjekAntalOpIDivision(i, division);
			// System.out.println(s);
			// System.out.println(division);
			// System.out.println(antal);
			if (antal == 0) {
				s += "";
			} else if (antal > 3) {
				s = specialTal(antal, division, s, divisionTegnOver,
						divisionTegnMellemOver, divisionTegn);
			} else if (antal <= 3) {
				s = skrivRomerTal(antal, division, s, divisionTegn);
			}

			i = i - (antal * division);
			division = division / 10;

			if (division == 100) {
				divisionTegnOver = "M";
				divisionTegnMellemOver = "D";
				divisionTegn = "C";
			} else if (division == 10) {
				divisionTegnOver = "C";
				divisionTegnMellemOver = "L";
				divisionTegn = "X";
			} else if (division == 1) {
				divisionTegnOver = "X";
				divisionTegnMellemOver = "V";
				divisionTegn = "I";
			}
		}

		// if (i == 0) {
		// System.out.println("nice der var ikke noget tilovers");
		// } else {
		// System.out.println("virker ikke");
		// }
		return s;
	}

	private static String skrivRomerTal(int antal, int division, String s,
			String divisionTegn) {
		// TODO Auto-generated method stub
		// System.out.println(division + "  " + antal + "   " + divisionTegn +
		// "   " + s);
		for (int i = 0; i < antal; i++) {
			s = s + divisionTegn;
		}
		// System.out.println(division + "  " + antal + "   " + divisionTegn +
		// "   " + s);
		return s;
	}

	private static String specialTal(int antal, int division, String s,
			String divisionTegnOver, String divisionTegnMellemOver,
			String divisionTegn) {
		// TODO Auto-generated method stub
		if (antal == 4) {
			s += divisionTegn + divisionTegnMellemOver;
		} else if (antal == 5) {
			s += divisionTegnMellemOver;
		} else if (antal == 9) {
			s += divisionTegn + divisionTegnOver;
		} else if (antal > 5) {
			String k = "";
			for (int j = 0; j < antal - 5; j++) {
				k += divisionTegn;
			}
			s += divisionTegnMellemOver + k;
		}
		return s;
	}

	private static int tjekAntalOpIDivision(int i, int divisionen) {
		// skrevet af Mads
		int Antal = i / divisionen;
		return Antal;
	}
}
