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
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			File autok = new File("C:\\Users\\Család\\Desktop\\Java\\Cegesautok\\src\\autok.txt");
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
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}
