package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class Giocatore 
{
	static final private int CFU_INIZIALI = 20;
	int cfu;
	
	private Borsa borsa;
	
	private Attrezzo borsaAttrezzi[];
	
	public Giocatore()
	{
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();		
	}
}
