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
				//while ciklussal megoldjam kit�r�ltem az els� sort a f�jlb�l �s �gy m�r m�k�d�tt
				adatok adatok1 = new  adatok();
				String sor = olvaso.nextLine();
				String[] soradatok = sor.split(";");
				adatok1.ora = Integer.parseInt(soradatok[0]);
				adatok1.perc = Integer.parseInt(soradatok[1]);
				adatok1.db = Integer.parseInt(soradatok[2]);
				adatok1.nev = soradatok[3];
				
				adatoklist.add(adatok1);
			}
		
			System.out.println("3. feladat: Bejegyz�sek sz�ma " + adatoklist.size());
			//4.feladat
			boolean van = false;
			for (int i = 0; i < adatoklist.size(); i++) {
				if (adatoklist.get(i).db == 4) {
					van = true;
				}
			}
			if (van = true) {
				System.out.println("4. feladat: Volt n�gy ad�st ind�t� sof�r");
			}
			else {
				System.out.println("4. feladat: Nem volt n�gy ad�st ind�t� sof�r");
			}
			//5.feladat
			Scanner sc = new Scanner(System.in);
			System.out.print("5. feladat: K�rek egy nevet ");
			String neve = sc.nextLine();
			int osszh=0;
			for (int i = 0; i < adatoklist.size(); i++) {
				if (neve == adatoklist.get(i).nev) {
					osszh += adatoklist.get(i).db;
				}
			}
			System.out.println(neve+ " " + osszh + "x ind�tott h�v�st");
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
			//nem j� de valahogy �gy szeretn�m megoldani
			System.out.println("8. feladat: Sof�r�k sz�ma " + sofszam);
			//9.feladat
			//itt van megold�som ami j� lehet de a 8. feladatott meg k�ne oldani hozz�
			//8. feladatban kigy�jtj�k a neveket �s azt a t�mb�t felhaszn�lva adjuk hozz� a ad�sok sz�m�t �s �gy kiv�lassztva a maximumot
			//feladatlap http://dload.oktatas.educatio.hu/erettsegi/feladatok_2019osz_kozep/k_infoism_19okt_fl.pdf
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
