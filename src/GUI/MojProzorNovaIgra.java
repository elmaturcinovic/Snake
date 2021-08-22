package GUI;

import java.awt.Color;
import java.awt.Dimension;
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
 * Klasa ciji je objekat pocetni prozor koji nam daje cetiri opcije za tip nove igre.
 */
public class MojProzorNovaIgra extends JFrame{
	
	private static final long serialVersionUID = -8770630289120070177L;
	/**
	 * Panel u koji smjestamo sadrzaj prozora
	 */
	JPanel panel;
	
	/**
	 * Dugme za prvi tip igre
	 */
	JButton dugme1;
	
	/**
	 * Dugme za drugi tip igre
	 */
	JButton dugme2;
	
	/**
	 * Dugme za treci tip igre
	 */
	JButton dugme3;
	
	/**
	 * Dugme za cetvrti tip igre
	 */
	JButton dugme4;
	
	/**
	 * Label u koji ispisujemo tekst: "Odaberi igru:"
	 */
	JLabel poruka;
	
	/**
	 * Tip igre
	 */
	int tip;
	
	
	/**
	 * Metoda pomocu koje konstruisemo sadrzaj pocetnog prozora
	 */
	private void build() {
		this.setVisible(true);
		this.setSize(400,300);
		this.setTitle("Nova igra");
		this.getContentPane().setBackground(new Color(255, 241, 201));		

		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		poruka = new JLabel("Odaberite igru: ");
		poruka.setBackground(null);
		poruka.setForeground(Color.DARK_GRAY);
		poruka.setHorizontalAlignment(SwingConstants.CENTER);
		poruka.setMinimumSize(new Dimension(400,150));;
		poruka.setPreferredSize(new Dimension(400,150));
		poruka.setMaximumSize(new Dimension(400,150));
		
		
		dugme1 = new JButton("Bez zidova");
		dugme1.setBackground(Color.DARK_GRAY);
		dugme1.setForeground(Color.WHITE);
		dugme1.setMargin(new Insets(10, 10, 10, 10));
		
		dugme2 = new JButton("Sa zidovima");
		dugme2.setBackground(Color.DARK_GRAY);
		dugme2.setForeground(Color.WHITE);
		dugme2.setMargin(new Insets(10, 10, 10, 10));
		
		dugme3 = new JButton("Sa preprekama I");
		dugme3.setBackground(Color.DARK_GRAY);
		dugme3.setForeground(Color.WHITE);
		dugme3.setMargin(new Insets(10, 10, 10, 10));
		
		dugme4 = new JButton("Sa preprekama II");
		dugme4.setBackground(Color.DARK_GRAY);
		dugme4.setForeground(Color.WHITE);
		dugme4.setMargin(new Insets(10, 10, 10, 10));
		
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
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(dugme1, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(dugme2,c);
		

		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(dugme3, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		
		panel.add(dugme4,c);
		
		add(panel);
		this.setLocationRelativeTo(null);
		
	}
	
	/**
	 * Getter za prvo dugme.
	 * @return dugme1   JButton koji ce nam kasnije, na njegov klik, pokretati igru tipa 1.
	 */
	public JButton getDugme1() {
		return this.dugme1;
	}
	
	/**
	 * Getter za drugo dugme.
	 * @return dugme2	JButton koji ce nam kasnije, na njegov klik, pokretati igru tipa 2.
	 */
	public JButton getDugme2() {
		return this.dugme2;
	}
	
	/**
	 * Getter za trece dugme.
	 * @return dugme3	JButton koji ce nam kasnije, na njegov klik, pokretati igru tipa 3.
	 */
	public JButton getDugme3() {
		return this.dugme3;
	}
	
	/**
	 * Getter za cetvrto dugme.
	 * @return dugme4 	JButton koji ce nam kasnije, na njegov klik, pokretati igru tipa 4.
	 */
	public JButton getDugme4() {
		return this.dugme4;
	}
	
	/**
	 * Getter za tip igre.
	 * @return tip 		Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public int getTip() {
		return this.tip;
	}
	
	/**
	 * Konstruktor za prozor kojim kreiramo prozor za novu igru.
	 */
	public MojProzorNovaIgra() {
		this.build();
	}
	
}
