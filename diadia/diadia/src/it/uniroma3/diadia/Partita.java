package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import it.uniroma3.diadia.giocatore.Giocatore;

public class Partita 
{

	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;

	public Partita()
	{
		labirinto = new Labirinto();
		giocatore = new Giocatore();
		labirinto.creaStanze();
		this.finita = false;
	}

	public Labirinto getLabirinto()
	{
		return labirinto;
	}

	public void setLabirinto(Labirinto labirinto) 
	{
		this.labirinto = labirinto;
	}

	public Giocatore getGiocatore() 
	{
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) 
	{
		this.giocatore = giocatore;
	}

	public boolean vinta() 
	{
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	public boolean isFinita() 
	{
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	public void setFinita() 
	{
		this.finita = true;
	}

}
