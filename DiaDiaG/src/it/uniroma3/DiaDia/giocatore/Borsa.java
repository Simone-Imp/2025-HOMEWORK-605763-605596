package it.uniroma3.DiaDia.giocatore;

import it.uniroma3.DiaDia.attrezzi.Attrezzo;
import it.uniroma3.DiaDia.ambienti.Stanza;

public class Borsa 
{
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezziborsa;
	private int numeroAttrezzi;
	private int pesoMax;
	
	public Borsa() 
	{
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) 
	{
		this.pesoMax = pesoMax;
		this.attrezziborsa = new Attrezzo[10];
		this.numeroAttrezzi = 0;
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) 
	{
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezziborsa[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() 
	{
		return pesoMax;
	}
	
	public Attrezzo getAttrezzoBorsa(String nomeAttrezzo) 
	{
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (attrezziborsa[i].getNome().equals(nomeAttrezzo))
				a = attrezziborsa[i];

		return a;
	}
	
	public int getPeso() 
	{
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezziborsa[i].getPeso();

		return peso;
	}
	
	public boolean isEmpty() 
	{
		return this.numeroAttrezzi == 0;
	}
	
	public boolean hasAttrezzo(String nomeAttrezzo) 
	{
		return this.getAttrezzoBorsa(nomeAttrezzo)!=null;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) 
	{
		Attrezzo a = null;
			if(nomeAttrezzo!=null)
			{
				for(int i=0; i<this.numeroAttrezzi; i++)
				{
					if(this.attrezziborsa[i]!=null)
					{	
						if(this.attrezziborsa[i].getNome().equals(nomeAttrezzo))
						{
							this.attrezziborsa[i] = a;
							this.numeroAttrezzi = this.numeroAttrezzi-1;
						}
					}
				}

			}
		return a;
	}
	
	public String toString() 
	{
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) 
		{
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezziborsa[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}