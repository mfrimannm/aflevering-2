import java.util.Random;
import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double nearPi = antalKastMedBuffonsNeedle();
		System.out.println(nearPi);
	}

	private static double antalKastMedBuffonsNeedle() {
		// TODO Auto-generated method stub
		System.out.print("hvor mange kast vil du foretage? ");
		Scanner scan = new Scanner(System.in);
		int antalKast = scan.nextInt();
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
			double a = r.nextInt(2) + 1;
			double b = r.nextInt(180) + 1;
			double restLength = 0;
			if (b == 180 || b == 0) {
				restLength = 1;
			}
			// reng med cos
			b = Math.sin(b*180/Math.PI);
			
			
			// brug længderne
			if (a + restLength > 2) {
				hits ++;
		}
	}
		return nearPi;

}
}
