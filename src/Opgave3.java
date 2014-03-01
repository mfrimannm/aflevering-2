import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// Den laver et metode kald som giver en et sprøgsmål om antal
		// iterationer. den vil retunerer en double med resultetet.
		double nearPi = antalKastMedBuffonsNeedle();
		System.out.println("Tilnærmere værdi af Pi " + nearPi);
	}

	private static double antalKastMedBuffonsNeedle() {
		// den bygger en scanner som så sprøg til antal iterationer som at man
		// vil undersøge.
		System.out.print("Husk at tallet skal være en int altså IKKE over 2^31\nHvor mange kast vil du foretage? ");
		Scanner scan = new Scanner(System.in);
		int antalKast = scan.nextInt();
		// vi giver ikke forsætte hvis vi kun skulle gøre det under 1 gang.
		if (antalKast < 1) {
			scan.close();
			throw new IllegalArgumentException("Ingen kast bedt om");
		}
		// men ellers så sender vi antal iterationer til den metode som beregner
		// Pi.
		double nearPi = buffonsNeedle(antalKast);
		// vi får så Pi og sender denne tilbage til main.
		scan.close();
		return nearPi;
	}

	private static double buffonsNeedle(int antalKast) {
		// denne berenger Pi, først bestemes nogen konsanter som faktsik ikke er
		// så afgørende bare deres forhold er rigtig.
		// dette vil de altså være efter som den ene er lig den anden med en
		// koifient.
		int lengthOfStick = 1;
		int lengthBetweenLines = lengthOfStick * 2;

		// da jeg skal bruge denne i loopet skal den lige difineres.
		int hits = 0;

		for (int i = 1; i <= antalKast; i++) {
			// bestemer så nogen tilfældige værdier.
			double a = Math.random() * lengthBetweenLines;
			double b = Math.random() * 180;
			double restLength = 0;
			// og tjekker så hvis vi har nogen specil tilfælde som giver nemmere
			// beregninger om vi kan køre disse bare.
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
					// jeg bruger sinus relleration til at finde længden hvorfor
					// jeg skal bruge den anden vinkel.
					b = 180 - 90 - b;
					restLength = (Math.sin(Math.toRadians(b)) * lengthOfStick)
							/ (Math.sin(Math.toRadians(90)));
				}
				// brug længderne
				// her tjekker jeg bare længderne og hvis det passer sådan at
				// den er mere end 2 så må vi have et hit.
				// eller den er under 0, hvilke bare ville betyde en forskydning, at den lå i det næste mellemrum.
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
