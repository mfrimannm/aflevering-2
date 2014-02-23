
public class Opgave1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String romer = konverterNummer(2031);
		System.out.print(romer);
		
	}

	private static String konverterNummer(int i) {
		// TODO Auto-generated method stub
		int tusinder	= tjekI(i,1000);
		i = i - (1000*tusinder);
		int femHundre	= tjekI(i,500);
		i = i - (500*femHundre);
		int hundrer		= tjekI(i,100);
		i = i - (100*hundrer);
		int halvTres	= tjekI(i,50);
		i = i - (50*halvTres);
		int tiere		= tjekI(i,10);
		i = i - (10*tiere);
		int femere		= tjekI(i,5);
		i = i - (5*femere);
		int enere		= tjekI(i,1);
		i = i - (1*enere);
		
		if(i==0){
			System.out.println("nice");
		}
		else{
			System.out.println("virker ikke");
		}
		
		String s = skrivstring("M",tusinder);
		s = skrivstring("D", femHundre)	+ s;
		s = skrivstring("C", hundrer) 	+ s;
		s = skrivstring("L", halvTres)	+ s;
		s = skrivstring("X", tiere)		+ s;
		s = skrivstring("V", femere)	+ s;
		s = skrivstring("I", enere)		+ s;
		return s;
	}

	private static int tjekI(int i, int j) {
		// TODO Auto-generated method stub
		int Antal = i / j;
		System.out.println(Antal);
		return Antal;
	}

	private static String skrivstring(String bogstav, int antal) {
		// TODO Auto-generated method stub
		String s = "";
		for(int i=1;i<=antal;i++){
			s = s + bogstav;
		}
		return s;
	}

}
