
public class Opgave1 {

	public static void main(String[] args) {
		// skrevet af Mads
		// her indtastests det nummer man gerne vil konverterer.
		int num = 9;
		String romer = konverterNummer(num);
		System.out.println(romer);
	}

	private static String konverterNummer(int i) {
		// skrevet af Mads
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
		
		tjekSpicel(tusinder,femHundre,hundrer,halvTres,tiere,femere,enere);
		
		
		String s = skrivstring("M",tusinder);
		s = s + skrivstring("D", femHundre);
		s = s + skrivstring("C", hundrer);
		s = s + skrivstring("L", halvTres);
		s = s + skrivstring("X", tiere);
		s = s + skrivstring("V", femere);
		s = s + skrivstring("I", enere);
		return s;
	}

	private static void tjekSpicel(int tusinder, int femHundre, int hundrer,
			int halvTres, int tiere, int femere, int enere) {
		// TODO Auto-generated method stub
	}

	private static int tjekI(int i, int j) {
		// skrevet af Mads
		int Antal = i / j;
		System.out.println(Antal);
		return Antal;
	}

	private static String skrivstring(String bogstav, int antal) {
		// skrevet af Mads
		String s = "";
		for(int i=1;i<=antal;i++){
			s = s + bogstav;
		}
		return s;
	}

}
