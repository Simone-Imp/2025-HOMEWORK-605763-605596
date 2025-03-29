package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;

public class Partita 
{

	private Labirinto labirinto;
	private boolean finita;
	private int cfu;
	
	public Partita()
	{
		labirinto = new Labirinto();
		labirinto.creaStanze();
		this.finita = false;

	}
	
	public Labirinto getLabirinto()
	{
		return this.labirinto;
	}
	
	public boolean vinta() 
	{
		return labirinto.getStanzaCorrente() == labirinto.getStanzaVincente();
	}
	
	public boolean isFinita() 
	{
		return finita || vinta() || (cfu == 0);
	}

	public void setFinita() 
	{
		this.finita = true;
	}

	public int getCfu() 
	{
		return this.cfu;
	}

	public void setCfu(int cfu) 
	{
		this.cfu = cfu;		
	}	
}
