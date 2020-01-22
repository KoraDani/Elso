import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cbradio {

	public static int AtszamolPercre (int ora, int perc) {
		int ossz = (ora * 60) + perc;
		return ossz;
	}
	public static void main(String[] args) {
		File olvas = new File("C:\\Users\\korad\\Desktop\\test2\\cbradio1\\cb.txt");

		try {
			Scanner olvaso = new Scanner(olvas);
			List<adatok> adatoklist = new ArrayList<adatok>();
			while(olvaso.hasNextLine()) {
				//while ciklussal megoldjam kitöröltem az elsõ sort a fájlból és úgy már mûködött
				adatok adatok1 = new  adatok();
				String sor = olvaso.nextLine();
				String[] soradatok = sor.split(";");
				adatok1.ora = Integer.parseInt(soradatok[0]);
				adatok1.perc = Integer.parseInt(soradatok[1]);
				adatok1.db = Integer.parseInt(soradatok[2]);
				adatok1.nev = soradatok[3];
				
				adatoklist.add(adatok1);
			}
		
			System.out.println("3. feladat: Bejegyzések száma " + adatoklist.size());
			//4.feladat
			boolean van = false;
			for (int i = 0; i < adatoklist.size(); i++) {
				if (adatoklist.get(i).db == 4) {
					van = true;
				}
			}
			if (van = true) {
				System.out.println("4. feladat: Volt négy adást indító sofõr");
			}
			else {
				System.out.println("4. feladat: Nem volt négy adást indító sofõr");
			}
			//5.feladat
			Scanner sc = new Scanner(System.in);
			System.out.print("5. feladat: Kérek egy nevet ");
			String neve = sc.nextLine();
			int osszh=0;
			for (int i = 0; i < adatoklist.size(); i++) {
				if (neve == adatoklist.get(i).nev) {
					osszh += adatoklist.get(i).db;
				}
			}
			System.out.println(neve+ " " + osszh + "x indított hívást");
			int a = 0 ;
			for (int i = 0; i < adatoklist.size(); i++) {
				a = AtszamolPercre(adatoklist.get(i).ora ,adatoklist.get(i).perc);
			}
			//7.feladat
			FileWriter iro = new FileWriter("cb2.txt");
			for (int i = 0; i < adatoklist.size(); i++) {
				iro.write(AtszamolPercre(adatoklist.get(i).ora ,adatoklist.get(i).perc)+";"+ adatoklist.get(i).nev+";"+adatoklist.get(i).db+"\n" );
			}
			iro.close();
			//8.feladat
			String[] nevek = new String[adatoklist.size()];
			int sofszam =0;
			for (int i = 0; i < adatoklist.size(); i++) {
				if (nevek[i] != adatoklist.get(i).nev) {
					nevek[i] = adatoklist.get(i).nev;
					sofszam++;
				}
			}
			//nem jó de valahogy így szeretném megoldani
			System.out.println("8. feladat: Sofõrõk száma " + sofszam);
			//9.feladat
			//itt van megoldásom ami jó lehet de a 8. feladatott meg kéne oldani hozzá
			//8. feladatban kigyûjtjük a neveket és azt a tömböt felhasználva adjuk hozzá a adások számát ás úgy kiválassztva a maximumot
			//feladatlap http://dload.oktatas.educatio.hu/erettsegi/feladatok_2019osz_kozep/k_infoism_19okt_fl.pdf
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
