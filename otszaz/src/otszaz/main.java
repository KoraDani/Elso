package otszaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		//File adat = new File("C:\\Users\\korad\\Desktop\\test2\\otszaz\\src\\otszaz\\penztar.txt");
		File adat = new File("C:\\Users\\Csal�d\\Documents\\�j git\\otszaz\\src\\otszaz\\penztar.txt");
		
		List<adatok> lista = new ArrayList<adatok>();
		try {
			Scanner olvas = new Scanner(adat);
			while (olvas.hasNextLine()) {
				String[] tomb = olvas.nextLine().split(" ");
				adatok adatlista = new adatok();
				adatlista.setVasarlo(tomb[0]);
				lista.add(adatlista);
			}
			int VasarlasSzam = 0;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getVasarlo().equals("F")) {
					VasarlasSzam++;
				}
			}
			System.out.println("2. feladat:\nA fizet�sek sz�ma: "+ VasarlasSzam);
			
			int ElsoVasarlo = 0;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getVasarlo().equals("F")) {
					ElsoVasarlo = i;
					break;
				}
			}
			System.out.println("\n3. feladat \nAz els� v�s�rl� " +ElsoVasarlo+ " darab �rucikket v�s�rolt.");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("\n4. feladat\n");
			System.out.print("Adja meg egy v�s�rl�s sorsz�m�t! ");
			String VasarSorsz = sc.nextLine();
			System.out.print("Adja meg egy �rucikk nev�t! ");
			String AruCikk = sc.nextLine();
			System.out.print("Adja meg a v�s�rolt darabsz�mot! ");
			String DarabSzam = sc.nextLine();
			//5. feladat
			int szamolo = 0;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getVasarlo().equals("F")) {
					szamolo++;
					if (lista.get(i).getVasarlo() == AruCikk) {
						System.out.println(szamolo+1);
						break;
					}
				}
			}
			/*for (int i = lista.size(); i > 0; i--) {
				if (lista.get(i).getVasarlo().equals(AruCikk)) {
					System.out.print("Az az utols� v�s�rl�s sorsz�ma "+i);
					break;
				}
			}*/
			int VasarolDB = 0;
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getVasarlo().equals(AruCikk)) {
					VasarolDB++;
				}
			}
			//ki�rja csak hib�san
			System.out.print(VasarolDB);
			
			//6. feladat
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
