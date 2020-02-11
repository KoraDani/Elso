import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			File exped = new File("C:\\Users\\korad\\Desktop\\test2\\Expedicio\\src\\veetel.txt");
			try {
				Scanner olvaso = new Scanner(exped);
				List<adatok> adatoklista = new ArrayList<adatok>();
				for (int i = 0; i < args.length; i+=2) {
					adatok adat = new adatok();
					String[] sor = olvaso.nextLine().split("\n"); 
					adat.setElso(Integer.parseInt(sor[0]));
					adat.setMasodik(sor[1]);
					adatoklista.add(adat);
				}
				for (int i = 0; i < adatoklista.size(); i++) {
					System.out.println(adatoklista.get(i).getElso());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
