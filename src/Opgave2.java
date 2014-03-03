import java.util.Scanner;

public class Opgave2 {

	public static void main(String[] args) {
		tjekForPalindrome();
	}

	private static void tjekForPalindrome() {
		// Beder om teskt input og bestemmer om det er et palindrom
		// den skriver om det er eller ej
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter line to check: ");
		String input = scan.nextLine();

		// fjerner specialtegn
		String inputNoSpecial = input.replaceAll("[^a-zA-Z]+", "");

		if (inputNoSpecial.length() <= 0) {
			scan.close();
			throw new IllegalArgumentException("input er tom, dette kan være fordi den med specialtegn fjernet er blevet tom");
		}
		String omvendt = new StringBuilder(inputNoSpecial).reverse().toString();

		Boolean jaEllerNej = omvendt.equalsIgnoreCase(inputNoSpecial);

		if (jaEllerNej) {
			System.out.print("\"" + input + "\"" + " is a palindrome!");
		} else {
			System.out.print("\"" + input + "\"" + " is not a palindrome!");
		}
		scan.close();
	}

}
