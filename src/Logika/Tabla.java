package Logika;

import java.util.ArrayList;

/**
 * 
 * @author Elma Turcinovic
 *
 */

/**
 * Glavna klasa logike igre cija instanca daje tablu na kojoj se igra odvija. Sadrzi podatke o velicini table,
 * tipu igre, pozicijama nekih objekata na tabli i dr.
 */
public class Tabla {
	/**
	 * Sirina table za igranje.
	 */
	private int sirinaTable;
	
	/**
	 * Visina table za igranje.
	 */
	private int visinaTable;
	
	/**
	 * Tip table za igranje:  1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	private int tip;
	
	/**
	 * Matrica polja table.
	 */
	private char[][] tabla; // '.' - prazna tabla, '#' - zid, 'O' - glava, 'o' - tijelo, '*' - hrana
	
	/**
	 * Rezultat igre.
	 */
	private int rezultat;
	
	/**
	 * Koordinata i polja na kojem se nalazi hrana.
	 */
	private int iHrana;
	
	/**
	 * Koordinata j polja na kojem se nalazi hrana.
	 */
	private int jHrana;
	
	/**
	 * Smjer kretanja zmije.
	 */
	private char smjer;
	
	/**
	 * Lista koja cuva koordinate polja koja cine tijelo zmije.
	 */
	private ArrayList<Cvor> zmija; 
	
	/**
	 * Konstruktor sa jednim parametrom tip koji odredjuje tip table i kreira praznu tablu dimenzija 20x20.
	 * @param tip 	odredjuje tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public Tabla(int tip) {
		this.sirinaTable = 20;
		this.visinaTable = 20;
		this.tip = tip;
		this.tabla = new char[20][20];
		for (int i = 0; i < this.visinaTable;i++) {
			for (int j = 0; j < this.sirinaTable;j++) {
				tabla[i][j] = '.';
			}
		}
		rezultat = 0;
		zmija = new ArrayList<Cvor>();
		
		if (tip == 2) {
			this.dodajZidove();
		}
		else if(tip == 3) {
			this.dodajPrepreke1();
		}
		else if(tip == 4) {
			this.dodajPrepreke2();
		}
		this.dodajZmijuPocetak();
		this.dodajHranu();
		this.smjer = 'd';
	}
	
	/**
	 * Konstruktor sa tri parametra sirina, visina i tip kreira praznu tablu dimenzija sirina x visina, 
	 * pri cemu je tabla proslijedjenog tipa.
	 * @param sirina 	sirina table za igranje. 
	 * @param visina 	visina table za igranje.
	 * @param tip 		odredjuje tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public Tabla(int sirina, int visina, int tip) {
		this.sirinaTable = sirina;
		this.visinaTable = visina;
		this.tip = tip;
		this.tabla = new char[sirina][visina];
		for (int i = 0; i < this.visinaTable;i++) {
			for (int j = 0; j < this.sirinaTable;j++) {
				tabla[i][j] = '.';
			}
		}
		rezultat = 0;
		zmija = new ArrayList<Cvor>();
		if (tip == 2) {
			this.dodajZidove();
		}
		this.dodajZmijuPocetak();
		this.dodajHranu();
		this.smjer = 'd';
	}
	
	/**
	 * Getter za visinu table.
	 * @return visinaTable		Visina table za igranje (broj redova).
	 */
	public int getVisinaTable() {
		return this.visinaTable;
	}
	
	/**
	 * Getter za sirinu table.
	 * @return sirinaTable		Sirina table za igranje (broj kolona).
	 */
	public int getSirinaTable() {
		return this.sirinaTable;
	}
	
	/**
	 * Getter za tip igre.
	 * @return tip		 	Tip igre: 1 - bez zidova, 2 - sa zidovima, 3 - sa preprekama I, 4 - sa preprekama II.
	 */
	public int getTip() {
		return tip;
	}

	/**
	 * Getter za matricu znakova koja predstavlja tablu za igranje.
	 * @return tabla 		Matrica znakova koja prestavlja tablu.
	 */
	public char[][] getTabla() {
		return this.tabla;
	}
	
	/**
	 * Getter za rezultat.
	 * @return rezultat		Rezultat igre.
	 */
	public int getRezultat() {
		return this.rezultat;
	}
	
	/**
	 * Getter za i koordinatu pozicije hrane na tabli. Ovo nam, zajedno sa j koordinatom
	 * omogućava uklanjanje hrane sa ploce.
	 * @return iHrana	i koordinata pozicije hrane na tabli.
	 */
	public int getIHrana() {
		return this.iHrana;
	}
	
	/**
	 * Getter za j koordinatu pozicije hrane na tabli. Ovo nam, zajedno sa j koordinatom
	 * omogućava uklanjanje hrane sa ploce.
	 * @return jHrana	j koordinata pozicije hrane na tabli.
	 */
	public int getJHrana() {
		return this.jHrana;
	}
	
	/**
	 * Getter za smjer.
	 * @return smjer	Znak koji odredjuje trenutni smjer kretanja zmije na tabli: 
	 * 					'w'- gore, 'a' - lijevo, 's' - dole, 'd' - desno.
	 */
	public char getSmjer() {
		return this.smjer;
	}

	/**
	 * Setter za smjer.
	 * @param c 		Znak kojim mozemo vrsiti promjenu smjera kretanja zmije:
	 * 					'w'- gore, 'a' - lijevo, 's' - dole, 'd' - desno.
	 */
	public void setSmjer(char c) {
		this.smjer = c;
	}
	

	/**
	 * Metoda koja omogućava dodavanje zidova. Ona se poziva samo kada je tip igre jednak 2.
	 */
	public void dodajZidove() {
		for (int i = 0; i < this.visinaTable;i++) {
			for (int j = 0; j < this.sirinaTable;j++) {
				if ((i==0)||(j==0)||(i==this.visinaTable - 1)||(j==this.sirinaTable-1)){
					this.tabla[i][j] = '#';
				}
			}
		}
	}
	
	/**
	 * Metoda koja omogućava dodavanje prepreka. Ona se poziva samo kada je tip igre jednak 3.
	 */
	public void dodajPrepreke1(){
		for (int i = 0; i < this.visinaTable;i++) {
			for (int j = 0; j < this.sirinaTable;j++) {
				if ((((i==3)||(i==this.visinaTable - 4)) && (((j>=3)&&(j<=6))||
						((j<=this.sirinaTable-4)&&(j>=this.sirinaTable-7))))
					||(((j==3)||(j==this.sirinaTable - 4)) && (((i>=3)&&(i<=6))||
							((i<=this.visinaTable-4)&&(i>=this.visinaTable-7))))){
					this.tabla[i][j] = '#';
				}
			}
		}
	}
	
	/**
	 * Metoda koja omogućava dodavanje prepreka. Ona se poziva samo kada je tip igre jednak 4.
	 */
	public void dodajPrepreke2() {
		for (int i = 0; i < this.visinaTable;i++) {
			for (int j = 0; j < this.sirinaTable;j++) {
				if ((i==j)&&((i>=0)&&(i<5)||((i>=this.visinaTable-5)&&(i<=this.visinaTable-1)))
					||(i+j==this.visinaTable-1)&&((i>=0)&&(i<5)||((i>=this.visinaTable-5)&&(i<=this.visinaTable-1)))
					||((i>=this.visinaTable/2 - 2)&&(i<=this.visinaTable/2 + 1)
						&&(j>=this.sirinaTable/2 - 2)&&(j<=this.sirinaTable/2 + 1))){
					this.tabla[i][j] = '#';
				}
			}
		}
	}
	
	/**
	 * Metoda koja postavlja zmiju na plocu u njen pocetni polozaj. Poziva se samo pri inicijalizaciji igre.
	 */
	public void dodajZmijuPocetak() {
		this.zmija.add(new Cvor(1,4));
		this.zmija.add(new Cvor(1,3));
		this.zmija.add(new Cvor(1,2));
		
		int i = this.zmija.get(0).i;
		int j = this.zmija.get(0).j;
		this.tabla[i][j] = 'O';
		
		for (int k = 1; k < this.zmija.size(); k++) {
			i = this.zmija.get(k).i;
			j = this.zmija.get(k).j;
			this.tabla[i][j] = 'o';
		}	
	}
	
	
	/**
	 * Metoda koja dodaje zmiju na plocu u zavisnosti od vrijednosti argumenta klase zmija, koji cuva
	 * koordinate polja u kojima se zmija trenutno nalazi.
	 * Postavlja polje table u kojem se nalazi glava zmije na 'O', dok na pozicijama koje odgovaraju
	 * ostatku tijela zmije postavlja vrijednost na 'o'.
	 */
	public void dodajZmiju() {
		
		int i = this.zmija.get(0).i;
		int j = this.zmija.get(0).j;
		this.tabla[i][j] = 'O';
		
		for (int k = 1; k < this.zmija.size(); k++) {
			i = this.zmija.get(k).i;
			j = this.zmija.get(k).j;
			this.tabla[i][j] = 'o';
		}	
	}
	
	
	
	/**
	 * Metoda pomocu koje dodajemo tablu na plocu generisuci nasumicno koordinate polja, vodeci racuna da se
	 * na toj poziciji vec ne nalazi zmija, zid ili prepreka, tj. da je dato polje slobodno.
	 */
	public void dodajHranu() {
		//int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		
		int i = (int)Math.floor(Math.random()*(this.visinaTable-2+1)+1);
		int j = (int)Math.floor(Math.random()*(this.sirinaTable-2+1)+1);
		
		while(this.tabla[i][j] != '.') {
			i = (int)Math.floor(Math.random()*(this.visinaTable-2+1)+1);
			j = (int)Math.floor(Math.random()*(this.sirinaTable-2+1)+1);
		}
		
		this.tabla[i][j] = '*';
		this.iHrana = i;
		this.jHrana = j;
	}
	
	/**
	 * Metoda pomocu koje uklanjamo hranu sa ploce.
	 */
	public void ukloniHranu() {
		this.tabla[iHrana][jHrana] = '.';		
	}
	
	/**
	 * Privatna metoda koja nam, ukoliko zmija pri izvrsenom potezu nailazi na hranu, pomjeri zmiju na ploci
	 * na proslijedjeno polje i poveca joj velicinu za jedan
	 * @param i			Broj koji predstavlja i koordinatu polja na kojem zmija nailazi na hranu
	 * @param j			Broj koji predstavlja j koordinatu polja na kojem zmija nailazi na hranu
	 */
	private void pojedi (int i, int j) {
		rezultat++;
		this.zmija.add(0, new Cvor(i,j));
		this.dodajZmiju();
		this.dodajHranu();
	}
	
	/**
	 * Privatna metoda koja nam pomjera zmiju na ploci na proslijeđeno polje
	 * @param i			Broj koji predstavlja i koordinatu polja na koje pomjeramo zmiju
	 * @param j			Broj koji predstavlja j koordinatu polja na koje pomjeramo zmiju
	 */
	private void pomjeri(int i, int j) {
		this.zmija.add(0, new Cvor(i,j));
		
		int irep = this.zmija.get(this.zmija.size()-1).i;
		int jrep = this.zmija.get(this.zmija.size()-1).j;
		this.tabla[irep][jrep] = '.';
		
		this.zmija.remove(this.zmija.size()-1);
		this.dodajZmiju();
	}
	
	
	
	/**
	 * Metoda koja nam, ukoliko je to moguce, pomjera zmiju u desno.
	 * @return boolean 		true - ako se potez uspjesno izvrsio, 
	 * 						false - ukoliko je bi takvim potezom zmija dosla do zida ili ugrizla samu sebe.
	 */
	
	public boolean potezDesno() {
		//koordinate glave
		int i = this.zmija.get(0).i;
		int j = this.zmija.get(0).j;
		
		this.smjer ='d';
		
		if (j+1 < this.sirinaTable) {
			if ((this.tabla[i][j+1] == '#')||(this.tabla[i][j+1] == 'o')) 
				return false;
			else if (this.tabla[i][j+1] == '*') 
				this.pojedi(i, j+1);
			else 
				this.pomjeri(i, j+1);
	
		}
		else if (j+1 == this.sirinaTable) {
			if ((this.tabla[i][0] == '#')||(this.tabla[i][0] == 'o')) 
				return false;
			else if (this.tabla[i][0] == '*') 
				this.pojedi(i, 0);
			else 
				this.pomjeri(i, 0);
		}
		return true;
			
	}
	
	
	/**
	 * Metoda koja nam, ukoliko je to moguce, pomjera zmiju u lijevo.
	 * @return boolean 			true - ako se potez uspjesno izvrsio, 
	 * 							false - ukoliko je bi takvim potezom zmija dosla do zida ili ugrizla samu sebe.
	 */
	public boolean potezLijevo() {
		//koordinate glave
		int i = this.zmija.get(0).i;
		int j = this.zmija.get(0).j;
		
		this.smjer='a';
		
		if (j-1 >= 0) {
			if ((this.tabla[i][j-1] == '#')||(this.tabla[i][j-1] == 'o'))
				return false;
			else if (this.tabla[i][j-1] == '*') 
				this.pojedi(i, j-1);
			else 
				this.pomjeri(i, j-1);
		}
		else if (j-1 < 0 ) {
			if ((this.tabla[i][this.sirinaTable-1] == '#')||(this.tabla[i][this.sirinaTable-1] == 'o')) 
				return false;
			else if (this.tabla[i][this.sirinaTable-1] == '*') 
				this.pojedi(i, this.sirinaTable-1);
			else 
				this.pomjeri(i, this.sirinaTable-1);
		}
		return true;
	}
	
	
	/**
	 * Metoda koja nam, ukoliko je to moguce, pomjera zmiju ka gore.
	 * @return boolean 			true - ako se potez uspjesno izvrsio, 
	 * 							false - ukoliko je bi takvim potezom zmija dosla do zida ili ugrizla samu sebe.
	 */
	public boolean potezGore() {
		//koordinate glave
		int i = this.zmija.get(0).i;
		int j = this.zmija.get(0).j;
		
		this.smjer='w';
		
		if (i-1 >= 0) {
			if ((this.tabla[i-1][j] == '#')||(this.tabla[i-1][j] == 'o')) 
				return false;
			else if (this.tabla[i-1][j] == '*')
				this.pojedi(i-1, j);
			else 
				this.pomjeri(i-1, j);
		}
		else if (i-1 < 0 ) {
			if ((this.tabla[this.visinaTable-1][j] == '#')||(this.tabla[this.visinaTable-1][j] == 'o')) 
				return false;
			else if (this.tabla[this.visinaTable-1][j] == '*') 
				this.pojedi(this.visinaTable-1, j);
			else 
				this.pomjeri(this.visinaTable-1, j);
		}
		return true;
	}
	
	
	/**
	 * Metoda koja nam, ukoliko je to moguce, pomjera zmiju ka dole.
	 * @return boolean 			true - ako se potez uspjesno izvrsio, 
	 * 							false - ukoliko je bi takvim potezom zmija dosla do zida ili ugrizla samu sebe.
	 */
	public boolean potezDole() {
		//koordinate glave
		int i = this.zmija.get(0).i;
		int j = this.zmija.get(0).j;
		
		this.smjer ='s';
		
		if (i+1 < this.visinaTable) {
			if ((this.tabla[i+1][j] == '#')||(this.tabla[i+1][j] == 'o')) {
				return false;
			}
			else if (this.tabla[i+1][j] == '*') {
				
				this.pojedi(i+1, j);
			}
			else {
				
				this.pomjeri(i+1, j);

			}
		}
		else if (i+1 == this.visinaTable) {
			if ((this.tabla[0][j] == '#')||(this.tabla[0][j] == 'o'))
				return false;
			else if (this.tabla[0][j] == '*')
				this.pojedi(0, j);
			else
				this.pomjeri(0, j);
		}	
		return true;
	}
	
	/**
	 * Metoda koja nam izvrsava potez u slucaju kada je to moguce i vraca vrijednost true,
	 * ili u suprotnom vraća vrijednost false.
	 * @param smjer			Znak koji predstavlja smjer u kojem cemo odraditi potez ukoliko bude moguce
	 *  					'w'- gore, 'a' - lijevo, 's' - dole, 'd' - desno.
	 * @return boolean		Vrijednost koja odredjuje da li se potez uspio izvrsiti:
	 * 						true - za uspjesno izvrsen potez, 
	 * 						false - za nemoguc potez
	 */
	public boolean igrajPotez(char smjer) {
		switch(smjer) {
		case 'a':
			return this.potezLijevo();
		case 'd':
			return this.potezDesno();
		case 'w':
			return this.potezGore();
		case 's':
			return this.potezDole();
		default:
			return false;
		}
	}
}
