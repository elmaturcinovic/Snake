package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Logika.Tabla;

/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Klasa cija je instanca glavni prozor u kojem ce se igra odvijati.
 */
public class MojProzorIgra extends JFrame {
	
	private static final long serialVersionUID = 976083092921425396L;
	/**
	 * Tip Igre.
	 */
	private int tip;
	
	/**
	 * Rezultat igre.
	 */
	private int rezultat;
	
	/**
	 * Instanca klase panelTabla koji ce nam biti tabla za igranje.
	 */
	private MojPanelTabla panelTabla;
	
	/**
	 * Panel u koji cemo ispisati rezultat.
	 */
	private JPanel panelRezultat;
	
	/**
	 * Label za rezultat.
	 */
	private JLabel labelRezultat;
	
	/**
	 * Tekstualno polje za rezultat.
	 */
	private JTextField  poljeRezultat;
	
	
	/**
	 * Getter za tip igre.
	 * @return tip			Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public int getTip() {
		return tip;
	}
	
	/**
	 * Getter za rezultat igre;
	 * @return rezultat		Rezultat igre.
	 */
	public int getRezultat() {
		return rezultat;
	}
	
	/**
	 * Getter za tablu igre.
	 * @return panelTabla	 	JPanel koji predstavlja tablu igre.
	 */
	public MojPanelTabla getPanelTabla() {
		return panelTabla;
	}
	
	/**
	 * Getter za panel za rezultat.
	 * @return panelRezultat	JPanel u kome ce biti prikazan rezultat.
	 */
	public JPanel getPanelRezultat() {
		return panelRezultat;
	}
	
	/**
	 * Getter za label za rezultat.
	 * @return labelRezultat 	JLabel za tekst iz panelRezultat.
	 */
	public JLabel getLabelRezultat() {
		return labelRezultat;
	}
	
	/**
	 * Getter ta tekstualno polje u koje se ispisuje rezultat.
	 * @return poljeRezultat	TextField u kome će se ispisivati trenutni rezultat.
	 */
	public JTextField getPoljeRezultat() {
		return poljeRezultat;
	}

	
	/**
	 * Metoda pomocu koje vrsimo konstrukciju prozotra za igru.
	 * @param tip 	Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	private void build(int tip) {
		this.tip = tip; 
		this.setVisible(true);
		this.setTitle("Zmija");
		this.getContentPane().setBackground(new Color(159, 181, 123));		
		this.setMinimumSize(new Dimension(505,700));
		this.setMaximumSize(new Dimension(505,700));
		this.setPreferredSize(new Dimension(505,700));
		
		this.setFocusable(true);
		this.setResizable(false);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		this.panelTabla = new MojPanelTabla(tip);
		this.rezultat = this.panelTabla.getTabla().getRezultat();

		
		panelTabla.setMinimumSize(new Dimension(500,500));
		panelTabla.setMaximumSize(new Dimension(500,500));
		panelTabla.setPreferredSize(new Dimension(500,500));
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		Border compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		panelTabla.setBorder(BorderFactory.createCompoundBorder(compound, new EmptyBorder(10, 10, 15, 15)));
		panelTabla.setOpaque(false);

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.BOTH;
		
		this.add(panelTabla,c);
		
		this.panelRezultat = new JPanel();
		konstruisiPomocni(panelRezultat);
		panelRezultat.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelRezultat.setOpaque(false);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		
		this.add(panelRezultat, c);
		
		this.validate();
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Metoda koja konstruise pomocni panel (panel u kojem ce se ispisivati rezultat).
	 * @param panel 	 JPanel u koji ce se smjestiti label i tekstualno polje za rezultat.
	 */
	public void konstruisiPomocni(JPanel panel) {
		
		this.labelRezultat = new JLabel("Rezultat: ");
		int rezultat = this.getPanelTabla().getTabla().getRezultat();
		this.poljeRezultat = new JTextField(Integer.toString(rezultat));
		this.poljeRezultat.setEditable(false);
		
		panel.setLayout(new GridLayout(2,1));
		panel.setMinimumSize(new Dimension(500,100));
		panel.setMaximumSize(new Dimension(500,100));
		panel.setPreferredSize(new Dimension(500,100));

		panel.add(labelRezultat);
		panel.add(poljeRezultat);
		panel.validate();
				 
	}
	
	/**
	 * Kostruktor koji kao parametar prima tip igre, te kreira prozor igre proslijedjenog tipa.
	 * Unutar njega, dodajemo i key listener, kao i timere i timer evente.
	 * @param tip 		Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public MojProzorIgra(int tip) {
		this.build(tip);
		this.addKeyListener(new MojKeyListener(this));
		
		
		MojTimerTask1 mtt = new MojTimerTask1();
		Timer timer = new Timer(true);
		timer.schedule(mtt, 30000, 30000);
		
		
		MojTimerTask2 mtt2 = new MojTimerTask2();
		Timer timer2 = new Timer(true);
		timer2.schedule(mtt2, 500 , 500);
		

		
	}
	
	/**
	 * Metoda koja se poziva kada je igra zavrsena. Ona zatvara prozor igre, kreira prozor 
	 * za kraj igre na kome se ispisuje rezultat, te se igrac pita da li zeli igrati novu igru.
	 */
	public void krajIgre() {
		int rezultat = this.getPanelTabla().getTabla().getRezultat();
		final MojProzorKrajIgre krajIgre = new MojProzorKrajIgre(rezultat);
		
		JButton dugmeDa = krajIgre.getDugmeDa();
		JButton dugmeNe = krajIgre.getDugmeNe();
		
		dugmeDa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				krajIgre.dispose();
				IgrajZmiju.IgrajNovuIgru();
			}
		});
		
		dugmeNe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				krajIgre.dispose();
			}
		});
		
		this.dispose();


	}
	
	/**
	 * Klasa koja definira timer task koji nam nakon odredjenog vremena u kojem hrana nije 
	 * pokupljena, uklanja hranu sa table i generise novu.
	 */
	class MojTimerTask1 extends TimerTask {

		@Override
		public void run() {
			panelTabla.getTabla().ukloniHranu();
			panelTabla.getTabla().dodajHranu();
			panelTabla.osvjeziStanjeTable();
			rezultat = panelTabla.getTabla().getRezultat();
		}
		
	}
	
	/**
	 * Klasa koja definira timer koji nam omogucava neprekidno kretanje zmije po tabli.
	 */
	class MojTimerTask2 extends TimerTask {

		@Override
		public void run() {
			Tabla tabla = panelTabla.getTabla();
			if (tabla.igrajPotez(tabla.getSmjer())){
				panelTabla.osvjeziStanjeTable();
				int rezultat = tabla.getRezultat();
				getPoljeRezultat().setText(Integer.toString(rezultat));
			}
			else {
				krajIgre();
				cancel();
				
			}
			
		}
		
	}	
	
}
