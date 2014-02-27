import java.util.Scanner;

public class Opgave2 {

	public static void main(String[] args) {
		// Man kalder metoden
		tjekForPalindrome();
	}

	private static void tjekForPalindrome() {
//		når den er kaldt vil den sprøge til en string og printe resultatet.
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter line to check: ");
		String input = scan.nextLine();
		System.out.println(input);

		// fjerner specil tegn
		input = input.replaceAll("\\W", "");

		if (input.length() <= 0) {
			scan.close();
			throw new IllegalArgumentException("input er tom, dette kan være fordi den med special tegn fjernet er blevet tom");
		}
		// tjek
		// vi har i class'en StringBuilder metoder til at omvenne og lave kompelkse ting meget nemt.
		// denne bygger en string ud fra indputet og arbejder så med denne til sidst laver den så dette tilbage om til en string.
		String omvent = new StringBuilder(input).reverse().toString();
		Boolean jaEllerNej = omvent.equalsIgnoreCase(input);
		// print
		if (jaEllerNej) {
			System.out.print("\"" + input + "\"" + " is a palindrome!");
		} else {
			System.out.print("\"" + input + "\"" + " is not a palindrome!");
		}
		scan.close();
	}

}
