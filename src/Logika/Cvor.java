package Logika;

/**
 * 
 * @author Elma Turcinovic
 *
 */


/**
 * 
 * Klasa koja nam sluzi za evidenciju pozicija na kojima se nalazi zmija
 *
 */
public class Cvor {
	int i;
	int j;
	
	
	/**
	 * Konstruktor sa dva parametra i i j koji predstavljaju koordinate cvora na tabli igre
	 * 
	 * @param i		i koordinata cvora na tabli
	 * @param j		j koordinata cvora na tabli
	 */
	public Cvor(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
