import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
		//int megtettkm = 0;
		int azonosito = adatoklista.get(0).szemelyi;
		//int veglegmegtett = 0;
		List<Integer> maxkm = new ArrayList<Integer>();
		//int[] vissza = new int[2];
		for (int i = 0; i < adatoklista.size(); i++){
			azonosito = adatoklista.get(i).szemelyi;
			if (azonosito == adatoklista.get(i).szemelyi && adatoklista.get(i).kibe == 0) {
				elsoindex = i;
				
				for (int j = i+1; j < adatoklista.size(); j++){
					//if (azonosito == adatoklista.get(j).szemelyi && adatoklista.get(j).kibe == 1 && megtettkm > adatoklista.get(j).km - adatoklista.get(elsoindex).km) {
					if (azonosito == adatoklista.get(j).szemelyi && adatoklista.get(j).kibe == 1) {	
						maxkm.add(  Math.abs(adatoklista.get(i).km - adatoklista.get(j).km));
						//vissza[1] = i;
						
			}
			}
			
			}}
		return max(maxkm);
		
		
	}
	
	public static void rendszamok(List<Adatok> adrendsz) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		List<Integer> eredeti = new ArrayList<Integer>();
		for (int i = 0; i < adrendsz.size(); i++) {
			Adatok adat = adrendsz.get(i);
			if (map.get(adrendsz.get(i).rendszam)== null) {
				eredeti.add(adrendsz.get(i).km);
				map.put(adat.rendszam, adat.km);
				}
			else {
				map.put(adat.rendszam, adat.km);
			}
		}
		
		int i = 0;
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			
			System.out.println(entry.getKey()+" " + Math.abs(entry.getValue() - eredeti.get(i++))+ " km");
		}
		
	}
	
	public static int max(List<Integer> maxkm) {
		int b = 0;
		for(Integer elem: maxkm) {
			if (elem > b) {
				b = elem;
			}
		}
		
		return b;
	}
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
			//autok = new File("C:\\Users\\Család\\Desktop\\Java\\Cegesautok\\src\\autok.txt");
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
				
				
				
				/*String[] rendszamok = {"CEG300","CEG301","CEG302","CEG303","CEG304","CEG305","CEG306","CEG307","CEG308","CEG309"};
				int osszkm = 0;
				for (int i = 0; i < adatoklista.size(); i++) {
					if (rendszamok[i] == adatoklista.get(i).rendszam) { //itt elakad mert a több határin kívül esik az érték asszem
						for (int j = 0; j <  adatoklista.size(); j++) {
							osszkm += adatoklista.get(i).km;
						}
					}
				}*/
				Adatok adatok = maximum(adatoklista);
				System.out.println(adatok.nap + "nap rendszám " + adatok.rendszam);
				Scanner sc = new Scanner(System.in);
				System.out.println("Kérek egy napot ");
				List<Adatok> napadatok= napok(adatoklista,Integer.parseInt(sc.nextLine()));
				for(int i = 0; i < napadatok.size(); i++) {
					
					System.out.println(napadatok.get(i).ora + " " + napadatok.get(i).rendszam + " " + napadatok.get(i).szemelyi + (napadatok.get(i).kibe == 0?"Ki":"Be"));
				}
				System.out.println("Hónap végén " + darabszam(adatoklista) + " autót nem hoztak vissza");
				
				rendszamok(adatoklista);

				
				System.out.println("6. feladat "+leghoszzut(adatoklista));
				

				Scanner sc2 = new Scanner(System.in);
				System.out.println("Kérek egy rendszámot ");
				String rendsz = sc2.nextLine();
				FileWriter iro = new FileWriter(rendsz +"_menetlevel.txt");
				for (int i = 0; i < adatoklista.size(); i++) {
					
					if (rendsz == adatoklista.get(i).rendszam ) {
						iro.write(adatoklista.get(i).szemelyi+" "+ adatoklista.get(i).nap+ " " + adatoklista.get(i).rendszam);
						iro.close();
						if (adatoklista.get(i).kibe == 1) {
							iro.write("\t" + adatoklista.get(i).szemelyi+" "+ adatoklista.get(i).nap+ " " + adatoklista.get(i).rendszam);
						}
						System.out.println(adatoklista.get(i).szemelyi+" "+ adatoklista.get(i).nap+ " " + adatoklista.get(i).rendszam );
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}


	}


