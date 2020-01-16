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
	//6. feladat ebben sem stimmel valami
	public static int  leghoszzut (List<Adatok> adatoklista) {
		int elsoindex = 0;
		int megtettkm = 0;
		int azonosito = adatoklista.get(0).szemelyi;
		int veglegmegtett = 0;
		//int[] vissza = new int[2];
		for (int i = 0; i < 500; i++){
			if (azonosito == adatoklista.get(i).szemelyi && adatoklista.get(i).kibe == 0) {
				elsoindex = i;
				azonosito = adatoklista.get(i).szemelyi;
				
			}
			if (azonosito == adatoklista.get(i).szemelyi && adatoklista.get(i).kibe == 1) {
			for (int j = 2; j < 500; j++){
				//if (azonosito == adatoklista.get(j).szemelyi && adatoklista.get(j).kibe == 1 && megtettkm > adatoklista.get(j).km - adatoklista.get(elsoindex).km) {
					
					veglegmegtett = Math.abs(adatoklista.get(elsoindex).km - adatoklista.get(j).km);
					//vissza[1] = i;
					return veglegmegtett;
		}}}
		return veglegmegtett;
		
		
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
					//5. feladat

				}
				String[] rendszamok = {"CEG300","CEG301","CEG302","CEG303","CEG304","CEG305","CEG306","CEG307","CEG308","CEG309"};
				int osszkm = 0;
				for (int i = 0; i < adatoklista.size(); i++) {
					if (rendszamok[i] == adatoklista.get(i).rendszam) { //itt elakad mert a több határin kívül esik az érték asszem
						for (int j = 0; j <  adatoklista.size(); j++) {
							osszkm += adatoklista.get(i).km;
						}
					}
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
				
				
				for (int i = 0; i < 4; i++) {
					System.out.println(osszkm);
				}
				System.out.println("6. feladat "+leghoszzut(adatoklista));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


	}


