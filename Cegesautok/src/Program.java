import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
	
	public static Adatok maximum(List<Adatok> adatoklista) {
		int i = 0;
		while(i<adatoklista.size()){
			if(adatoklista.get(i).nap >= 30 && adatoklista.get(i).kibe == 0) {
				return adatoklista.get(i);
			}
			i++;
		}
		return null;
	}
	
	public static List<Adatok> napok (List<Adatok> adatoklista, int nap) {
		List<Adatok> csokkentett = new ArrayList();
		for(int i = 0; i< adatoklista.size(); ++i) {
			if(nap == adatoklista.get(i).nap) {
				csokkentett.add(adatoklista.get(i));
			
			}
		}
		return csokkentett;
	}
	public static int darabszam(List<Adatok> adatoklista) {
		int szamlalo0 = 0;
		int szamlalo1 = 0;
		for(int i = 0; i < adatoklista.size(); i++) {
			if(adatoklista.get(i).kibe == 0) {
				szamlalo0++;
			}
			else {
				szamlalo1++;
			}
		}
		return szamlalo0-szamlalo1;
	}
	/*6. feladat elakadtam és szerintem van egyszerûbb megoldás rá, lényegében az kéne hogy még egy második adatott is kell felhasználni hozzá pl
	a személyit de nem tudom hogy adjam meg a feltételt*/
	public static Adatok kimax (List<Adatok> adatoklista) {
		int legnagy = adatoklista.get(0).km;
		int szem = adatoklista.get(0).szemelyi;
		for (int i = 0; i < adatoklista.size(); i++) {
			if (legnagy> adatoklista.get(i).km && adatoklista.get(i).kibe == 0) {
				if (szem == adatoklista.get(i).szemelyi && adatoklista.get(i).kibe == 1) {
					return adatoklista.get(i);
				}
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			File autok = new File("C:\\Users\\korad\\Desktop\\test2\\Cegesautok\\src\\autok.txt");
			try {
				Scanner olvaso = new Scanner(autok);
				List<Adatok> adatoklista = new ArrayList<Adatok>();
				while(olvaso.hasNextLine()){
					Adatok adatok = new Adatok();
					String sor = olvaso.nextLine();
					String[] soradatok = sor.split(" ");
					adatok.nap = Integer.parseInt(soradatok[0]);
					adatok.ora = soradatok[1];
					adatok.rendszam = soradatok[2];
					adatok.szemelyi = Integer.parseInt(soradatok[3]);
					adatok.km = Integer.parseInt(soradatok[4]);
					adatok.kibe = Integer.parseInt(soradatok[5]);
					adatoklista.add(adatok);
				}
				Adatok adatok = maximum(adatoklista);
				System.out.println(adatok.nap + "nap rendszám " + adatok.rendszam);
				Scanner sc = new Scanner(System.in);
				System.out.println("Kérek egy napot ");
				List<Adatok> napadatok= napok(adatoklista,Integer.parseInt(sc.nextLine()));
				for(int i = 0; i < napadatok.size(); i++) {
					
					System.out.println(napadatok.get(i).ora + " " + napadatok.get(i).rendszam + " " + napadatok.get(i).szemelyi + (napadatok.get(i).kibe == 0?"Ki":"Be"));
				}
				System.out.println("Hónap végén " + darabszam(adatoklista) + " autót nem hoztak vissza");
				
				//5.feladat Valami ilyesmire gondoltam de szerintem van ennél egyszerûbb is
				
				/*int nulla=0, egy=0,ketto=0,harom=0,negy=0,ot=0,hat=0,het=0,nyolc=0, kilenc =0;
				
				for(int i = 0; i< adatoklista.size(); i++) {
					switch (adatoklista.get(i).rendszam) {
					case "CEG300":
						nulla += napadatok.get(i).km;
					break;
					case "CEG301":
						egy+= napadatok.get(i).km;
						break;
					case "CEG302":
						ketto+= napadatok.get(i).km;
					break;
					case "CEG303":
						harom+= napadatok.get(i).km;
					break;
					case "CEG304":
						negy+= napadatok.get(i).km;
					break;
					case "CEG305":
						ot+= napadatok.get(i).km;
					break;
					case "CEG306":
						hat+= napadatok.get(i).km;
					break;
					case "CEG307":
						het+= napadatok.get(i).km;
					break;
					case "CEG308":
						nyolc+= napadatok.get(i).km;
					break;
					case "CEG309":
						kilenc+= napadatok.get(i).km;
					break;
					}
				}
				System.out.println("CGE300 "+ nulla+ " km");
				System.out.println("CGE301 "+ egy+ " km");
				System.out.println("CGE302 "+ ketto+ " km");
				System.out.println("CGE303 "+ harom+ " km");
				System.out.println("CGE304 "+ negy+ " km");
				System.out.println("CGE305 "+ ot+ " km");
				System.out.println("CGE306 "+ hat+ " km");
				System.out.println("CGE307 "+ het+ " km");
				System.out.println("CGE308 "+ nyolc+ " km");
				System.out.println("CGE309 "+ kilenc+ " km");*/
				
				/*6. feladat folytatása
				Adatok kimaxx = kimax(adatoklista);
				System.out.println("6. feladat Leghosszabb út: "+ kimaxx.km + " személy " + kimaxx.szemelyi);*/
				
				//7. feladatott nem tudom hogy fogjak hozzá
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
