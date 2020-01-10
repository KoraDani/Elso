package asdasd;

public class Main {

	public static void main(String[] args) {
		Kutya rex = new Kutya();
		rex.nev = "Rex";
		rex.magassag = 1;
		rex.fajta = "Nemetjuhasz";
		
		Kutya asd = new Kutya();
		asd.nev = rex.nev;
		Kutya asd2 = new Kutya();
		asd2.fajta = "Pincsi";
		System.out.println("asd2 kutya fajtája " + asd2.fajta);
		System.out.println("Masik kutya neve" + asd.nev);

	}

}
