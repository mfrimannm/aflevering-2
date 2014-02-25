import java.util.Scanner;

public class Opgave2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tjekForPalindrome();
	}

	private static void tjekForPalindrome() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter line to check: ");
		String input = scan.next();
		System.out.println(input);
		
		// fjerner specil tegn
		input = input.replaceAll("\\W", "");

		// tjek
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
