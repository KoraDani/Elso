package utca;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utca {
//2018 okt�ber emelt "Ker�t�s"
	public static void main(String[] args) {
		File beolvas = new File("C:\\Users\\korad\\Desktop\\test2\\utca\\src\\utca\\kerites.txt");
		
		List<adatok> adatoklista = new ArrayList<adatok>();
		Scanner olvaso;
		try {
			olvaso = new Scanner(beolvas);
			while(olvaso.hasNextLine()) {
				String[] egysor = olvaso.nextLine().split(" ");
				adatok adat = new adatok();
				adat.setParosparatlan(Integer.parseInt(egysor[0]));
				adat.setHossz(Integer.parseInt(egysor[1]));
				adat.setAllapot(egysor[0]);
				adatoklista.add(adat);
			}
			
			System.out.println("2. feladat\nAz eladott telkek sz�ma: "+adatoklista.size()+"\n");
			int paros = 0,paratlan = 1;
			for (int i = 0; i < adatoklista.size(); i++) {
				if (adatoklista.get(i).getParosparatlan() == 0) {
					paros+=2;
				}
				if (adatoklista.get(i).getParosparatlan() == 1) {
					paratlan+=2;
				}
			}
			if (adatoklista.get(adatoklista.size()-1).getParosparatlan() == 0) {
				System.out.println("3. feladat\nA p�ros oldalon adt�k el az utols� telket\nAz utols� telek h�zsz�ma: " + paros+"\n");
			}else {
				System.out.println("3. feladat\nA p�ratlan oldalon adt�k el az utols� telket\nAz utols� telek h�zsz�ma: " + paratlan+"\n");
			}
			//4.feladat
			/*boolean van = false;
			int hazszam = 0;
			for (int i = 0; i < adatoklista.size(); i++) {
				if (adatoklista.get(i).getAllapot().equals(adatoklista.get(i+1).getAllapot()) 
						&& adatoklista.get(i).getParosparatlan()==adatoklista.get(i+1).getParosparatlan()
						&& adatoklista.get(i).getAllapot() == "P") {
					van = true;
					hazszam=i;
					break;
				}
			}
			if (van) {
				System.out.println("4. feladat\nA szomsz�dossal egyezik a kerit�s sz�ma " + hazszam);
			}*/
			//ez sem j�
			/*
			for (int i = 0; i < adatoklista.size(); i++) {
				for (int j = 0; j < adatoklista.size(); j++) {
					if (adatoklista.get(i).getAllapot().equals(adatoklista.get(j).getAllapot()) 
							&& adatoklista.get(i).getParosparatlan()==adatoklista.get(j).getParosparatlan()
							&& adatoklista.get(i).getAllapot() == "P" && adatoklista.get(j).getAllapot() == "P") {
						
						System.out.println("4. feladat\nA szomsz�dossal egyezik a kerit�s sz�ma " + i);
					}
				}
			}
			*/
			//ez sem j�, nem azt �rja bele f�jlba amit k�ne
			System.out.println("5. feladat\nAdjon meg egy h�zsz�mot!");
			Scanner hazszam = new Scanner(System.in);
			int asd = hazszam.nextInt();
			System.out.println("A ker�t�s sz�ne / �llapota! " + adatoklista.get(asd).getAllapot());
			//5. feladata b r�sz�t nem tudom hogyan k�ne megoldani
			try {
				FileWriter iro = new FileWriter("utcakep.txt");
				for (int i = 0; i < adatoklista.size(); i++) {
					if (adatoklista.get(i).getParosparatlan() == 1) {
						for (int j = adatoklista.get(i).getHossz(); j < adatoklista.size(); j++) {
							iro.write(adatoklista.get(i).getAllapot());
						}
					}
				}
				iro.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
