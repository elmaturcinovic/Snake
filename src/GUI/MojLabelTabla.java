package GUI;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Klasa cija instanca ce prestavljati jedno polje na tabli za igranje.
 */
public class MojLabelTabla extends JLabel{

	private static final long serialVersionUID = 7946005323738081893L;
	
	/**
	 * Koordinata x polja na tabli.
	 */
	private int x;
	
	/**
	 * Koordinata y polja na tabli.
	 */
	private int y;
	
	/**
	 * Vrijednost odgovarajuceg polja u instanci klase Tabla iz logike, na osnovu kojeg cemo
	 * dodijeliti boju polju table za igranje u GUI.
	 */
	private char znak;
	
	/**
	 * Getter za x.
	 * @return x	Koordinata x polja na tabli.
	 */
	public int dajX() {
		return x;
	}
	
	
	/**
	 * Getter za y.
	 * @return y	Koordinata y polja na tabli.
	 */
	public int dajY() {
		return y;
	}

	
	/**
	 * Getter za znak.
	 * @return znak 	Vrijednost odgovarajuceg polja u instanci klase Tabla iz logike, na osnovu kojeg cemo
	 * 					dodijeliti boju polju table za igranje u GUI.
	 */
	public char dajZnak() {
		return znak;
	}
	
	/**
	 * Setter za znak.
	 * @param znak 	Vrijednost odgovarajuceg polja u instanci klase Tabla iz logike, na osnovu kojeg cemo
	 * 				dodijeliti boju polju table za igranje u GUI.
	 */
	public void postaviZnak(char znak) {
		this.znak = znak;
	}
	
	/**
	 * Konstruktor sa tri parametra:
	 * @param x 	x koordinata polja
	 * @param y 	y koordinata polja
	 * @param znak 	znak koji odgovara tipu polja
	 */
	public MojLabelTabla(int x, int y, char znak) {
		this.x = x;
		this.y = y;
		this.znak = znak;
		this.oboji(znak);
		this.setOpaque(true);
		this.setMaximumSize(new Dimension(25,25));
		this.setMinimumSize(new Dimension(25,25));
		this.setPreferredSize(new Dimension(25,25));
		this.setVisible(true);
		
	}
	
	/**
	 * Metoda koja na osnovu odgovatajuceg znaka iz instance klase Tabla iz Logike dodjeljuje 
	 * odgovarajucu boju nasem JLabelu.
	 * @param znak  	Znak koji nam predstavlja vrijednost odgovarajuceg polja iz instance 
	 * 					klase Tabla nase igre, a u zavisnosti od vije vrijednosti se dodjeljuje boja
	 * 					JLabelu nad kojim je pozvana metoda
	 */
	public void oboji(char znak) {
		switch(znak) {
		case '.':
			this.setBackground(new Color(255, 241, 201));
			break;
		case '#':
			this.setBackground(new Color(50,50,50));
			break;
		case 'o':
			this.setBackground(new Color(114, 184, 2));
			break;
		case 'O':
			this.setBackground(new Color(69, 112, 0));
			break;
		case '*':
			this.setBackground(new Color(255,0,0));
			break;
		}
	}
	
	
}
