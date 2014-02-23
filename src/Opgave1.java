
public class Opgave1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String romer = konverterNummer(1000);
		System.out.print(romer);
		
	}

	private static String konverterNummer(int i) {
		// TODO Auto-generated method stub
		String s = tjekTusind(i);
		return s;
	}

	private static String tjekTusind(int i) {
		// TODO Auto-generated method stub
		int Antal = i / 1000;
		System.out.println(Antal);
		
		String s = "h";
		for(int k=1;k<=Antal;k++){
			s = s + "M";
		}
		return s;
	}

}
