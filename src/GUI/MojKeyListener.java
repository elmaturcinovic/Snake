package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Logika.Tabla;

/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Klasa koja implementira KeyListener kako bismo na pritisak na tipki strelica gore, dole,
 * lijevo i desno na tastaturi mogli pomjerati zmiju po tabli.
 */
public class MojKeyListener implements KeyListener {
	private MojPanelTabla panelTabla;
	
	/**
	 * Konstruktor koji kao parametar prima prozor na koji se primjenjuje KeyListener
	 * @param prozorIgra 	Prozor na koji primjenjujemo KeyListener
	 */
	public MojKeyListener(MojProzorIgra prozorIgra) {
		this.panelTabla = prozorIgra.getPanelTabla();

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Metoda koja nam definise akciju na pritisak neke od strelica gore, dole, lijevo ili desno
	 */
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getExtendedKeyCode();
		
		Tabla tabla = panelTabla.getTabla();
		
		if ((keyCode==37)||(keyCode==38)||(keyCode==39)||(keyCode==40)) {
			if (keyCode == 38) {
				tabla.setSmjer('w');
			}
			else if(keyCode == 37){
				tabla.setSmjer('a');
			}
			else if(keyCode == 40){
				tabla.setSmjer('s');
			}
			else if(keyCode == 39){
				tabla.setSmjer('d');
			}
			else {
				tabla.setSmjer(tabla.getSmjer());
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}	
}
