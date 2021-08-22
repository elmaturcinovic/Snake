package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import Logika.Tabla;
/**
 * 
 * @author Elma Turcinovic
 *
 */


/**
 * Klasa cija instanca ce predstavljati tablu za igranje.
 */
public class MojPanelTabla extends JPanel{
	
	private static final long serialVersionUID = 5928374620636386226L;
	
	/**
	 * Instanca igre iz klase Tabla iz logike.
	 */
	private Tabla tabla;
	
	/**
	 * Sirina table.
	 */
	private int sirina;
	
	/**
	 * Visina table.
	 */
	private int visina;
	
	/**
	 * Tip igre.
	 */
	private int tip;
	
	/**
	 * Rezultat igre.
	 */
	private int rezultat;
	
	/**
	 * Matrica objekata klase MojLabelTabla koja ćc nam predstavljati tablu
	 */
	private MojLabelTabla[][] tablaLabela;
	
	
	/**
	 * Getter za tablu.
	 * @return tabla 	Instanca klase Tabla iz Logike.
	 */
	public Tabla getTabla() {
		return tabla;
	}
	
	/**
	 * Getter za sirinu table.
	 * @return sirina		Sirina table.
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Getter za visinu table.
	 * @return visina		Visina table.
	 */
	public int getVisina() {
		return visina;
	}
	
	/**
	 * Getter za tip igre.
	 * @return tip		Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public int getTip() {
		return tip;
	}
	
	/**
	 * Getter za rezultat igre.
	 * @return rezultat		Rezultat igre
	 */
	public int getRezultat() {
		return rezultat;
	}
	
	/**
	 * Getter za tablu labela.
	 * @return tablaLabela  Matrica labela koja ce nam predstavljati tablu	za igranje
	 */
	public MojLabelTabla[][] getTablaLabela() {
		return tablaLabela;
	}
	
	/**
	 * Metoda koja nam kreira panel tablu za igranje.
	 * @param tip  	Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	private void build(int tip) {
	    this.setVisible(true);
        this.setFocusable(true);

	    this.tip = tip;
	    this.tabla = new Tabla(tip);
	    this.visina = tabla.getVisinaTable();
	    this.sirina = tabla.getSirinaTable();
	    this.tablaLabela = new MojLabelTabla[visina][sirina];
	    
		
	    this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		MojLabelTabla label;

		for (int i = 0; i < this.visina; i++) {
			for (int j = 0; j < this.sirina; j++) {
				char znak = this.tabla.getTabla()[i][j];
				label = new MojLabelTabla(i,j, znak);
				this.tablaLabela[i][j] = label;
				c.gridx = j;
				c.gridy = i;
				c.weightx = 1.0;
				c.weighty = 1.0;
				c.fill = GridBagConstraints.BOTH;
				this.add(label,c);	
			}
		}
		
		this.validate();
	}	
	
	/**
	 * Konstruktor sa jednim parametrom tip koji nam konstruise novi panel koji predstavlja tablu igre 
	 * proslijedjenog tipa.
	 * @param tip 	 Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public MojPanelTabla(int tip) {
		this.build(tip);
	}
	
	/**
	 * Metoda koja na osnovu stanja table iz Logike, osvjezava stanje table u GUI instanci igre.
	 */
	public void osvjeziStanjeTable() {
		for (int i = 0; i < this.visina; i++) {
			for (int j = 0; j < this.sirina; j++) {
				char znak = this.tabla.getTabla()[i][j];
				//label = new MojLabelTabla(i,j, znak);
				this.tablaLabela[i][j].postaviZnak(znak);;
				this.tablaLabela[i][j].oboji(znak);
			}
		}
		this.rezultat = this.tabla.getRezultat();
		
		this.repaint();
	}
	
	

	

}
