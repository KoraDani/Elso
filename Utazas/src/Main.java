import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// 2019 okt emelt
public class Main {

	public static void main(String[] args) {
		
		//File adat = new File("C:\\Users\\korad\\Desktop\\test2\\Utazas\\src\\utasadat.txt");
		File adat = new File("C:\\Users\\Család\\Documents\\Új git\\Utazas\\src\\utasadat.txt");

		
		
		try {
			List<adatok> adatoklista = new ArrayList<adatok>();
			Scanner olvas = new Scanner(adat);
			while (olvas.hasNextLine()) {
				String[] tomb = olvas.nextLine().split(" ");
				adatok adat1 = new adatok();
				adat1.setMegsorszam(Integer.parseInt(tomb[0]));
				adat1.setFelszdate(tomb[1]);
				adat1.setKartyaaz(Integer.parseInt(tomb[2]));
				adat1.setJegytipus(tomb[3]);
				adat1.setErvenyido(Integer.parseInt(tomb[4]));
				adatoklista.add(adat1);
			}
			System.out.println("2. feladat \n A buszra " + adatoklista.size()+ " utas akart felszállni ");
			int nemszalfel= 0;
			for (int i = 0; i < adatoklista.size(); i++) {
				if (//Integer.parseInt(adatoklista.get(i).getFelszdate().substring(0,7)) > adatoklista.get(i).getErvenyido() ||// 
						adatoklista.get(i).getErvenyido() == 0) {
					nemszalfel++;
				}
			}
			System.out.println("3. feladat \n A buszra " + nemszalfel + " utas nem szállhatott fel.");
			Map<Integer, Integer> map = new HashMap<Integer,Integer>();
			int szamlalo = 0;
			for (Map.Entry<Integer, Integer> asd : map.entrySet()) {
				if (map.keySet() == null) {
					map.put(((adatok) adatoklista).getMegsorszam(), szamlalo++);
				}
			}
			//4.feladatott nem tudom hogy kell megoldani
			for (adatok i : adatoklista) {
				
			}	
			//5.feladat nem mûködik 
			int ingyenutaz = 0;
			for (int i = 0; i < adatoklista.size(); i++) {
				if (adatoklista.get(i).getJegytipus() == "RVS" || adatoklista.get(i).getJegytipus() == "GYK") {
					ingyenutaz++;
				}
			}
			System.out.println(ingyenutaz);
			
			
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
