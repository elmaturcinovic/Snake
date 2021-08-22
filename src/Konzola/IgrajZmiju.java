package Konzola;
import java.util.Scanner;

import Logika.Tabla;
/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Klasa pomocu koje korisniku dozvoljavamo da igra igricu kroz konzolu.
 */
public class IgrajZmiju {
	
	/**
	 * Main funkcija koja nam pokrece igru u konzoli.
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ulaz = new Scanner(System.in);
		char novaIgra = 'y';
		
		while ((novaIgra == 'y')||(novaIgra=='Y')){
			System.out.println("Izaberite tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II");
			int tip = ulaz.nextInt();
			
			Tabla tab;
			while ((tip != 1)&&(tip != 2)&&(tip!=3)&&(tip!=4)) {
				System.out.println("Doslo je do greske. Unesite ponovo tip igre.");
				tip = ulaz.nextInt();
			}
				
			if (tip==1) {
				tab = new Tabla(1);
			}
			else if (tip==2) {
				tab = new Tabla(2);
			}
			else if (tip==3) {
				tab = new Tabla(3);
			}
			else {
				tab = new Tabla(4);
			}
			
			ispisiTablu(tab);
			
			boolean kraj = true;
			
			while(kraj == true) {
				System.out.println("Unesi smjer: ");
				char smjer = ulaz.next().charAt(0);
				while ((smjer!='a') && (smjer!='s') && (smjer!='d') && (smjer!='w')) {
					System.out.println("Nemoguc potez");
					System.out.println("Unesi smjer: ");
					smjer = ulaz.next().charAt(0);
				}
				
				if (tab.igrajPotez(smjer)) {
					ispisiTablu(tab);
				}
				else {
					kraj = false;
					novaIgra = krajIgre(tab);
				}
			}
			
		}
		ulaz.close();

	}

	/**
	 * Funkcija koja nam ispisuje stanje table igre u konzolu, te trenutni rezultat.
	 * @param tab 	Tabla igre, instanca klase Tabla.
	 */
	public static void ispisiTablu(Tabla tab) {
		for (int i=0; i < tab.getVisinaTable(); i++) {
			for(int j=0; j < tab.getSirinaTable(); j++) {
				System.out.print(tab.getTabla()[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("Rezultat: " + tab.getRezultat());
		System.out.println();
	}
	
	/**
	 * Funkcija koja se poziva kada smo dosli do kraja igre.
	 * @param tab 	Tabla igre, instanca klase Tabla.
	 * @return 		Znak koji nam daje informaciju o tome da li igrac zeli igrati igru ponovo.
	 * 				Vrijednosti 'y', 'Y' - nova igra.
	 */
	public static char krajIgre(Tabla tab) {
		System.out.println("Igra je zavrsena");
		System.out.println("Rezultat: " + tab.getRezultat());
		System.out.println("Da li zelite igrati ponovo?(Y/N)");
		Scanner ulaz = new Scanner(System.in);
		char novaIgra = ulaz.next().charAt(0);
		return novaIgra;
	}

}

