public class Opgave1 {

	public static void main(String[] args) {
		// skrevet af Mads
		// her indtastests det nummer man gerne vil konverterer.
		for (int u = 1; u <= 100; u++) {
			int num = u;
			if (num > -1 && num <= 3999) {
				String romer = konverterNummer(num);

			System.out.println(romer + "         " + num);
//				System.out.println("stop");
			} else {
//				System.out.println("ikke et passende nummer");
			}
		}
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
		String divisionTegnMellemNed = "D";
		String divisionTegnUnder = "C";

		while (i != 0) {
			antal = tjekAntalOpIDivision(i, division);
//			System.out.println(s);
//			System.out.println(division);
//			System.out.println(antal);
			if (antal == 0) {
				s += "";
			} else if (antal > 3) {
				s = specialTal(antal, division, s, divisionTegnOver,
						divisionTegnMellemOver, divisionTegn,
						divisionTegnMellemNed, divisionTegnUnder);
			} else if (antal <= 3) {
				s = skrivRomerTal(antal, division, s, divisionTegnOver,
						divisionTegnMellemOver, divisionTegn,
						divisionTegnMellemNed, divisionTegnUnder);
			}

			i = i - (antal * division);
			division = division / 10;
			
			if (division == 100) {
				divisionTegnOver = "M";
				divisionTegnMellemOver = "D";
				divisionTegn = "C";
				divisionTegnMellemNed = "L";
				divisionTegnUnder = "X";
			} else if (division == 10) {
				divisionTegnOver = "C";
				divisionTegnMellemOver = "L";
				divisionTegn = "X";
				divisionTegnMellemNed = "V";
				divisionTegnUnder = "I";
			} else if (division == 1) {
				divisionTegnOver = "X";
				divisionTegnMellemOver = "V";
				divisionTegn = "I";
				divisionTegnMellemNed = "";
				divisionTegnUnder = "";
			}
		}

		if (i == 0) {
//			System.out.println("nice der var ikke noget tilovers");
		} else {
//			System.out.println("virker ikke");
		}
		return s;
	}

	private static String skrivRomerTal(int antal, int division, String s,
			String divisionTegnOver, String divisionTegnMellemOver,
			String divisionTegn, String divisionTegnMellemNed,
			String divisionTegnUnder) {
		// TODO Auto-generated method stub
//		System.out.println(division + "  " + antal + "   " + divisionTegn + "   "  + s);
		for (int i = 0; i < antal; i++) {
			s = s + divisionTegn;
		}
//		System.out.println(division + "  " + antal + "   " + divisionTegn + "   "  + s);

		return s;
	}

	private static String specialTal(int antal, int division, String s,
			String divisionTegnOver, String divisionTegnMellemOver,
			String divisionTegn, String divisionTegnMellemNed,
			String divisionTegnUnder) {
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
