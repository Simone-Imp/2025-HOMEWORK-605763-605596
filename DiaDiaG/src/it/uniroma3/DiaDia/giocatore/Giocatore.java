package it.uniroma3.DiaDia.giocatore;

import it.uniroma3.DiaDia.attrezzi.Attrezzo;

public class Giocatore 
{
	static final private int CFU_INIZIALI = 20;
	public int cfu;
	
	private Borsa borsa;	
	private Attrezzo borsaAttrezzi[];
	
	public Giocatore()
	{
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();		
	}
	
	public int getCfu() 
	{
		return this.cfu;
	}

	public void setCfu(int cfu) 
	{
		this.cfu = cfu;		
	}

	public Borsa getBorsa() 
	{
		return borsa;
	}

	public void setBorsa(Borsa borsa) 
	{
		this.borsa = borsa;
	}		
}