package it.uniroma3.DiaDia;

import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.ambienti.labirinto;
import it.uniroma3.DiaDia.giocatore.Giocatore;
import it.uniroma3.DiaDia.ambienti.labirinto;

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

	public boolean vinta() 
	{
		return this.lab.getStanzaCorrente()== this.lab.getStanzaVincente();	
	}

	public boolean isFinita() 
	{
		return finita || vinta() || (giocatore.cfu== 0);
	}

	public void setFinita() 
	{
		this.finita = true;
	}

	public int getCfu() 
	{
		return this.giocatore.cfu;
	}

	public void setCfu(int cfu) 
	{
		this.giocatore.cfu= cfu;		
	}	
	
	public labirinto getLabirinto()
	{
		return lab;
	}
	
	public Giocatore getGiocatore() 
	{
		return giocatore;
	}
}
