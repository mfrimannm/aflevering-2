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
		// vil undersøge, derefter kalder den metoden som laver beregningerne og
		// denne værdi som den får tilbage returner den til main
		System.out.print("Hvor mange kast vil du foretage? ");
		Scanner scan = new Scanner(System.in);
		int antalKast = scan.nextInt();

		if (antalKast < 1) {
			scan.close();
			throw new IllegalArgumentException("Ingen kast bedt om");
		}

		double nearPi = buffonsNeedle(antalKast);

		scan.close();
		return nearPi;
	}

	private static double buffonsNeedle(double antalKast) {
		int lengthOfStick = 1;
		int lengthBetweenLines = lengthOfStick * 2;

		// da jeg skal bruge denne i loopet skal den lige difineres.
		int hits = 0;

		for (int i = 1; i <= antalKast; i++) {
			double a = Math.random() * lengthBetweenLines; // placeringen
			double b = Math.random() * 180; // vinklen.
			double restLength = 0;

			if (a == lengthBetweenLines || a == 0) {
				hits++;
			} else {
				if (b == 180 || b == 0) {
					restLength = lengthOfStick;
				} else {
					b = 180 - 90 - b;
					restLength = (Math.sin(Math.toRadians(b)) * lengthOfStick)
								 / (Math.sin(Math.toRadians(90)));
				}
				if ((a + restLength) >= lengthBetweenLines
						|| (a + restLength) <= 0) {
					hits++;
				}
			}
		}

		if (hits == 0) {
			throw new IllegalArgumentException("Ingen hits");
		}
		double nearPi = antalKast / (double) hits;
		return nearPi;
	}
}
