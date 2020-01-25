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
		File adatok = new File("C:\\Users\\Család\\Desktop\\Java\\Tarsalgo\\src\\ajto.txt");
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
				adatoklista.add(adatok1);
			}
			for (int i = adatoklista.size()-1; i > 0; i--) {
				if (adatoklista.get(i).isKibe()== false) {
					System.out.println(adatoklista.get(0).getAzonosito() +"\n"+ adatoklista.get(i).getAzonosito());
					break;
				}
			}
			Map<Integer,Integer> map = new HashMap();
			int szamlalo = 0;
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
