import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// Den laver et metode kald som giver en et spr�gsm�l om antal
		// iterationer. den vil retunerer en double med resultetet.
		double nearPi = antalKastMedBuffonsNeedle();
		System.out.println("Tiln�rmere v�rdi af Pi " + nearPi);
	}

	private static double antalKastMedBuffonsNeedle() {
		// den bygger en scanner som s� spr�g til antal iterationer som at man
		// vil unders�ge.
		System.out.print("Husk at tallet skal v�re en int alts� IKKE over 2^31\nHvor mange kast vil du foretage? ");
		Scanner scan = new Scanner(System.in);
		int antalKast = scan.nextInt();
		// vi giver ikke fors�tte hvis vi kun skulle g�re det under 1 gang.
		if (antalKast < 1) {
			scan.close();
			throw new IllegalArgumentException("Ingen kast bedt om");
		}
		// men ellers s� sender vi antal iterationer til den metode som beregner
		// Pi.
		double nearPi = buffonsNeedle(antalKast);
		// vi f�r s� Pi og sender denne tilbage til main.
		scan.close();
		return nearPi;
	}

	private static double buffonsNeedle(int antalKast) {
		// denne berenger Pi, f�rst bestemes nogen konsanter som faktsik ikke er
		// s� afg�rende bare deres forhold er rigtig.
		// dette vil de alts� v�re efter som den ene er lig den anden med en
		// koifient.
		int lengthOfStick = 1;
		int lengthBetweenLines = lengthOfStick * 2;

		// da jeg skal bruge denne i loopet skal den lige difineres.
		int hits = 0;

		for (int i = 1; i <= antalKast; i++) {
			// bestemer s� nogen tilf�ldige v�rdier.
			double a = Math.random() * lengthBetweenLines;
			double b = Math.random() * 180;
			double restLength = 0;
			// og tjekker s� hvis vi har nogen specil tilf�lde som giver nemmere
			// beregninger om vi kan k�re disse bare.
			if (a == 2 || a == 0) {
				hits++;
//				System.out.print("var her");
			} else {
				if (b == 180 || b == 0) {
					restLength = lengthOfStick;
				} else {
					// renger med sin
					// vi skal lige bruge den rigtige vinkel som ikke er den som
					// er gennerretet men findes ud fra denne
					// jeg bruger sinus relleration til at finde l�ngden hvorfor
					// jeg skal bruge den anden vinkel.
					b = 180 - 90 - b;
					restLength = (Math.sin(Math.toRadians(b)) * lengthOfStick)
							/ (Math.sin(Math.toRadians(90)));
				}
				// brug l�ngderne
				// her tjekker jeg bare l�ngderne og hvis det passer s�dan at
				// den er mere end 2 s� m� vi have et hit.
				// eller den er under 0, hvilke bare ville betyde en forskydning, at den l� i det n�ste mellemrum.
				if ((a + restLength) >= lengthBetweenLines
						|| (a + restLength) <= 0) {
					hits++;
				}
			}
		}
//		System.out.println(hits);
		if (hits == 0) {
			throw new IllegalArgumentException("Ingen hits");
		}
		double nearPi = antalKast / (double) hits;
		return nearPi;
	}
}
