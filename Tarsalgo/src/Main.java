import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		//File adatok = new File("C:\\Users\\Család\\Desktop\\Java\\Tarsalgo\\src\\ajto.txt");
		File adatok = new File("C:\\Users\\korad\\Desktop\\test2\\Tarsalgo\\src\\ajto.txt");

		try {
			Scanner olvaso = new Scanner(adatok);
			List<Adatok> adatoklista = new ArrayList<Adatok>();
			while (olvaso.hasNextLine()) {
				String[] tomb = olvaso.nextLine().split(" ");
				Adatok adatok1 = new Adatok();
				adatok1.setOra(Integer.parseInt( tomb[0]));
				adatok1.setPerc(Integer.parseInt(tomb[1]));
				adatok1.setAzonosito(Integer.parseInt(tomb[2]));
				adatok1.setKibe(tomb[3].equals("be")?true:false);
				adatok1.setIdo(adatok1.getOra()*60+adatok1.getPerc());
				adatoklista.add(adatok1);
			}
			for (int i = adatoklista.size()-1; i > 0; i--) {
				if (adatoklista.get(i).isKibe()== false) {
					System.out.println(adatoklista.get(0).getAzonosito() +"\n"+ adatoklista.get(i).getAzonosito());
					break;
				}
			}
			Map<Integer,Integer> map = new HashMap();

			for (int i = 0; i < adatoklista.size(); i++) {
				map.put(adatoklista.get(i).getAzonosito(),
						map.containsKey(adatoklista.get(i).getAzonosito())?
								map.get(adatoklista.get(i).getAzonosito())+1:
									0);			
			}
			FileWriter iro = new FileWriter("athaladas.txt");
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				iro.write(entry.getKey()+" "+ entry.getValue()+"\n");
			}
			iro.close();
			//4. feladat ehhez puskáznom kellett a megoldásból de a c++ban írva de valahogy így kéne megoldani
			/*for (Map.Entry<Integer, Integer> entry : map.entrySet() ) {
				if (entry.getValue()%2==1) {
					System.out.println(entry.getKey());
				}
			}*/
			//5.feladat
			int letszam =0,mikor = 0, maxletszam =0;
			for (int i = 0; i < adatoklista.size(); i++) {
				if (adatoklista.get(i).isKibe() == true) {
					letszam++;
				}else {
					letszam--;
				}
				if (letszam> maxletszam) {
					maxletszam = letszam;
					mikor=i;
				}
				}
			System.out.println(adatoklista.get(mikor).getOra()+ " " + adatoklista.get(mikor).getPerc());
			//6.feladat
			Scanner az = new Scanner(System.in);
			System.out.println("Kérek egy azonosítót: ");
			String azon = az.nextLine();
			for (int i = 0; i < adatoklista.size(); i++) {
				if (Integer.parseInt(azon) == adatoklista.get(i).getAzonosito() && adatoklista.get(i).isKibe() == true) {
					System.out.print(adatoklista.get(i).getOra()+ ":"+adatoklista.get(i).getPerc());
					for (int j = 0; j < adatoklista.size(); j++) {
						if (Integer.parseInt(azon) == adatoklista.get(j).getAzonosito() && adatoklista.get(j).isKibe() == false) {
							System.out.println("-"+  adatoklista.get(j).getOra() +":"+adatoklista.get(j).getPerc());							
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
