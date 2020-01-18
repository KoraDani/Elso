		import java.io.File;
		import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
		// a feladat linkej https://bit.ly/368bFCQ
public class Helsinki1 {

	public static void hely(List<Helsinkiadatok> adatoklist){
		//4.feladat
		/*itt els�nek egy list�ba akartam volna bele rakni �gy hogy az 
		0. index lett volna az arany �rmese sz�ma 1. indexen az ez�st stb.
		de ez nem j�tt �ssze*/
		int arany =0,ezust =0 ,bronz =0;
		for (int i = 0; i < adatoklist.size(); i++) {
			if (1 == adatoklist.get(i).helyezes) {
				arany++;
			}			
			if (2 == adatoklist.get(i).helyezes) {
				ezust++;
			}			
			if (3 == adatoklist.get(i).helyezes) {
				bronz++;
			}
		}
		System.out.println("4. feladat \n Arany " + arany + "\n Ez�st " + ezust + "\n Bronz " + bronz + "\n �sszesen " + (arany +ezust+bronz));
	} 
	public static void pontszam(List<Helsinkiadatok> adatoklist){
		int osszpont = 0;
		//int hely =1;
		for (int i = 0; i < adatoklist.size(); ++i) {
			switch (adatoklist.get(i).helyezes)
            {
                case 1: adatoklist.get(i).psz = 7; break;
                case 2: adatoklist.get(i).psz = 5; break;
                case 3: adatoklist.get(i).psz = 4; break;
                case 4: adatoklist.get(i).psz = 3; break;
                case 5: adatoklist.get(i).psz = 2; break;
                case 6: adatoklist.get(i).psz = 1; break;
            }
            osszpont += adatoklist.get(i).psz;
		}
			
		System.out.println("5. feladat\n Olimpiai pontok sz�ma: " + osszpont);
	}
	
	public static void sportag(List<Helsinkiadatok> adatoklist) {
		//itt valami nem stimmel
		int torna = 0, uszas = 0;
		for (int i = 0; i < adatoklist.size(); i++) {
			if (adatoklist.get(i).kategoria == "torna") {
				torna++;
			}if (adatoklist.get(i).kategoria == "uszas") {
				uszas++;
			}
		}
		if (torna> uszas) {
			System.out.println("Torna sport�gban szereztek t�bb �rmet");
		}if (torna < uszas) {
			System.out.println("�sz�s sport�gban szereztek t�bb �rmet");
		} else{
			System.out.println("Egyenl� volt az �rmek sz�ma");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				File helsinki = new File("C:\\Users\\korad\\Desktop\\test2\\Hlesinki1\\src\\helsinki.txt");
				try {
					Scanner olvaso = new Scanner(helsinki);
					List<Helsinkiadatok> adatoklist = new ArrayList< Helsinkiadatok>();
					while (olvaso.hasNextLine()) {
						 Helsinkiadatok adatok = new  Helsinkiadatok();
						String sor = olvaso.nextLine();
						String[] soradatok = sor.split(" ");
						adatok.helyezes = Integer.parseInt(soradatok[0]);
						adatok.sportoloszam = Integer.parseInt(soradatok[1]);
						adatok.kategoria = soradatok[2];
						adatok.versenyszam = soradatok[3];
						adatoklist.add(adatok);
					}
					System.out.println("3. feladat: \n Pontszerz� helyez�sek sz�ma: " + adatoklist.size());
					
					hely(adatoklist);

					pontszam(adatoklist);
					
					sportag(adatoklist);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}

		}

