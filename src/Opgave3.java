import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nearPi = antalKastMedBuffonsNeedle();
		System.out.println("tilnærmere værdi af Pi " + nearPi);
	}

	private static double antalKastMedBuffonsNeedle() {
		// TODO Auto-generated method stub
		System.out.print("hvor mange kast vil du foretage? ");
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

	private static double buffonsNeedle(int antalKast) {
		// TODO Auto-generated method stub
		int lengthOfStick = 1;
		int lengthBetweenLines = lengthOfStick * 2;

		double nearPi = -1;
		int hits = 0;

		for (int i = 1; i <= antalKast; i++) {
			double a = Math.random() * lengthBetweenLines;
			double b = Math.random() * 180;
			double restLength = 0;
			if (a == 2 || a == 0) {
				hits++;
				System.out.print("var her");
			} else {
				if (b == 180 || b == 0) {
					restLength = lengthOfStick;
				} else {
					// reng med cos og sin
					b = 180 - 90 - b;
					restLength = (Math.sin(Math.toRadians(b)) * lengthOfStick)
							/ (Math.sin(Math.toRadians(90)));
				}
				// brug længderne
			if ((a + restLength) >= lengthBetweenLines  || (a + restLength) <= 0) {
					hits++;
				}
			}
		}
		System.out.println(hits);
		if (hits == 0) {
			throw new IllegalArgumentException("Ingen hits");
		}
		nearPi = antalKast / (double) hits;
		return nearPi;
	}
}
