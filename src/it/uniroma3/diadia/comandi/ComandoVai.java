package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando 
{
	private String direzione;
	private IO io;
	private final static String NOME = "vai";
	
	@Override
	public void esegui(Partita partita) 
	{
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.direzione == null) 
		{
			this.io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}

		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		if (prossimaStanza == null) 
		{
			this.io.mostraMessaggio("Direzione inesistente");
			return;
		}
		
		Giocatore giocatore = partita.getGiocatore();
		
		if(partita.getStanzaCorrente() != stanzaCorrente.getStanzaAdiacente(this.direzione))
		{
			giocatore.setCfu(giocatore.getCfu() - 1);
		}		
		partita.setStanzaCorrente(prossimaStanza);
		this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());	
	}
		
	@Override
	public void setParametro(String parametro) 
	{
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() 
	{
		return this.direzione;
	}

	@Override
	public void setIo(IO io) 
	{
		this.io = io;	
	}
	
	@Override
	public String getNome() 
	{
		return NOME;
	}
}