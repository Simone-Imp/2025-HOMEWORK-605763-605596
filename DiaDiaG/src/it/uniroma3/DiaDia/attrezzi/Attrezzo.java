package it.uniroma3.DiaDia.attrezzi;

import it.uniroma3.DiaDia.ambienti.Stanza;

public class Attrezzo {

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) 
	{
		this.peso = peso;
		this.nome = nome;
	}

	public String getNome() 
	{
		return this.nome;
	}

	public int getPeso() 
	{
		return this.peso;
	}

	public String toString() 
	{
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

}