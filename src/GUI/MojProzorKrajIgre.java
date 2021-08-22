package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Klasa cija instanca predstavlja prozor koji se prikazuje nakon sto je igra zavrsena.
 *
 */
public class MojProzorKrajIgre extends JFrame{
	
	private static final long serialVersionUID = -7512837886803035860L;
	/**
	  * Panel u koji cemo smjestiti sadrzaj prozora.
	  */
	JPanel panel;
	
	/**
	 * Label u koji ispisujemo poruku igracu da je igra zavrsena.
	 */
	JLabel poruka;
	
	/**
	 * Label u koji ispisujemo rezultat.
	 */
	JLabel rezultatLabel;
	
	/**
	 * Rezultat igre.
	 */
	int rezultat;
	
	/**
	 * Label u kojem pitamo korisnika da li zeli igratui novu igru.
	 */
	JLabel novaIgra;
	
	/**
	 * Dugme za novu igru.
	 */
	private JButton dugmeDa;
	
	/**
	 * Dugme za kraj.
	 */
	private JButton dugmeNe;
	
	/**
	 * Getter za dugmeDa.
	 * @return dugmeDa 		JButton koji će da oznacava da igrac zeli igrati novu igru.
	 */
	JButton getDugmeDa() {
		return this.dugmeDa;
	}
	
	/**
	 * Getter za dugmeNe.
	 * @return dugmeNe 		JButton koji će da oznacava da igrac ne zeli igrati novu igru.
	 */
	JButton getDugmeNe() {
		return this.dugmeNe;
	}
	
	/**
	 * Metoda kojom kreiramo prozor koji se prikazuje kada je igra zavrsena.
	 * Prima jedan parametar:
	 * @param rezultat 		Rezlutat igre koji ce biti prikazan u prozoru.
	 */
	private void build(int rezultat) {
		this.rezultat = rezultat;
		this.setVisible(true);
		this.setSize(400, 400);
		this.getContentPane().setBackground(new Color(255, 241, 201));		

		this.setTitle("Zmija");
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		
		
		poruka = new JLabel("Igra je završena.");
		poruka.setHorizontalAlignment(SwingConstants.CENTER);
		poruka.setVerticalAlignment(SwingConstants.BOTTOM);
		
		rezultatLabel = new JLabel("Vas rezultat iznosi: " + rezultat);
		rezultatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rezultatLabel.setVerticalAlignment(SwingConstants.TOP);
		
		novaIgra = new JLabel("Želite li igrati ponovo?");
		novaIgra.setHorizontalAlignment(SwingConstants.CENTER);
		
		dugmeDa = new JButton("DA");
		dugmeDa.setBackground(Color.DARK_GRAY);
		dugmeDa.setForeground(Color.WHITE);
		dugmeDa.setMargin(new Insets(10, 10, 10, 10));
		
		dugmeNe = new JButton("NE");
		dugmeNe.setBackground(Color.DARK_GRAY);
		dugmeNe.setForeground(Color.WHITE);
		dugmeNe.setMargin(new Insets(10, 10, 10, 10));
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(poruka,c);
		

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(rezultatLabel,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 2;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(novaIgra,c);
		
		
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		panel.add(dugmeDa, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		panel.add(dugmeNe,c);
		
		add(panel);
		this.setLocationRelativeTo(null);
		
	}
	
	/**
	 * Konstruktor sa jednim parametrom rezultat koji kreira prozor koji se prikazuje kada je igra zavrsena,
	 * prikazuje igracu postignuti rezultat, te ga pita da li zeli igrati novu igru.
	 * @param rezultat - Rezultat igre
	 */
	public MojProzorKrajIgre(int rezultat) {
		this.build(rezultat);
	}
	
	
}
