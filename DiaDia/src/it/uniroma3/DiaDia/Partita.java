
package it.uniroma3.DiaDia;


import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.ambienti.labirinto;
import it.uniroma3.DiaDia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	
	public labirinto lab;
	public Giocatore giocatore;
	private boolean finita;
	public Partita()														
	{
		this.lab=new labirinto();
		this.lab.creaStanze();
		this.giocatore=new Giocatore(); 
		this.finita = false;  
		
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {

		return this.lab.getStanzaCorrente()== this.lab.getStanzaVincente();
		
		
		
	}


	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.cfu== 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public int getCfu() {
		return this.giocatore.cfu;
	}

	public void setCfu(int cfu) {
		this.giocatore.cfu= cfu;		
	}	
}
