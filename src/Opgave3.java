import java.util.Random;
import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double a = r.nextDouble()*2;
		double b = r.nextInt(180);
		System.out.println(a + "     " + b);
		
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
		System.out.println(antalKast);

		double nearPi = buffonsNeedle(antalKast);

		scan.close();
		return nearPi;
	}

	private static double buffonsNeedle(int antalKast) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int lengthOfStick = 1;
		int lengthBetweenLines = lengthOfStick * 2;

		double nearPi = -1;
		int hits = 0;

		for (int i = 1; i <= antalKast; i++) {
			double a = r.nextInt(lengthBetweenLines) + 1;
			double b = r.nextInt(180) + 1;
			double restLength = 0;
			if (b == 180 || b == 0) {
				restLength = lengthOfStick;
			}
			// reng med cos og sin
			b = 180 - 90 - b;
			restLength = (Math.sin(Math.toRadians(b)) * 1)
					/ (Math.sin(Math.toRadians(90)));

			// brug længderne
			if (a + restLength > lengthBetweenLines) {
				hits++;
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
