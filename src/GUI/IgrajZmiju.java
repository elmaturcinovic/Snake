package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Klasa pomocu koje pokrecemo GUI verziju igre zmija.
 */
public class IgrajZmiju {

	/**
	 * Main funkcija koja nam pokreće igru.
	 * @param args
	 */
	public static void main(String[] args) {
		IgrajNovuIgru();
	}
	
	/**
	 * Funkcija koja nam kreira prozor za novu igru, te definira radnje koje se odvijaju
	 * kada se klikne na pojedino od cetiri dugmeta tog prozora.
	 */
	public static void IgrajNovuIgru() {
		final MojProzorNovaIgra novaIgra = new MojProzorNovaIgra();
		
		JButton dugme1 = novaIgra.getDugme1();
		JButton dugme2 = novaIgra.getDugme2();
		JButton dugme3 = novaIgra.getDugme3();
		JButton dugme4 = novaIgra.getDugme4();
		
		dugme1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaIgra.dispose();
				zapocniIgru(1);
			}
		});
		
		dugme2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaIgra.dispose();
				zapocniIgru(2);
			}
		});
		
		dugme3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaIgra.dispose();
				zapocniIgru(3);
			}
		});
		
		dugme4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novaIgra.dispose();
				zapocniIgru(4);
			}
		});
	}
	
	/**
	 * Funkcija koja nam inicijalizira igru na osnovu proslijedjenog tipa igre,
	 * a koji je dobijen klikom na zeljeno dugme u prozoru za novu igru.
	 * @param tip	Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	private static void zapocniIgru(int tip) {
		new MojProzorIgra(tip);	
	}
}

