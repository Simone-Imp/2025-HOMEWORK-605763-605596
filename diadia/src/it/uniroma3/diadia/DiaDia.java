package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import java.util.Scanner;

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};

	private Partita partita;
	private Labirinto labirinto;

	public DiaDia() 
	{
		this.partita = new Partita();
		this.labirinto = new Labirinto();
	}

	public void gioca() 
	{
		String istruzione; 
		Scanner scannerDiLinee;
		labirinto.creaStanze();

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) 
	{
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.getNome().equals("fine"))
			this.fine();
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		
		else
			System.out.println("Comando sconosciuto");

		
		if (this.partita.vinta()) 
		{
			System.out.println("Hai vinto!");
			return true;
		} 
		else
			return false;
	}   

	private void aiuto() 
	{
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	private void vai(String direzione) 
	{
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		
		Stanza prossimaStanza = null;
		prossimaStanza = this.labirinto.getStanzaCorrente().getStanzaAdiacente(direzione);
		
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else 
		{
			labirinto.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getCfu();
			this.partita.setCfu(0);
		}
		System.out.println(labirinto.getStanzaCorrente().getDescrizione());
	}

	private boolean fine() 
	{
		System.out.println("Grazie di aver giocato!");
		return true;
	}

	public static void main(String[] argc) 
	{
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}