package it.uniroma3.DiaDia;

import java.util.Scanner;

import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.ambienti.labirinto;

import it.uniroma3.DiaDia.attrezzi.Attrezzo;

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

	public Partita partita;
	public labirinto lab;

	public DiaDia() 
	{
		this.partita = new Partita();
		this.lab=partita.lab;
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do {	
			istruzione = scannerDiLinee.nextLine();
			this.processaIstruzione(istruzione);}
		while (!partita.isFinita());
	}   
	
	private void processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome().equals("fine") ) 
		{
			this.fine(); 
		
		} 
		
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa (comandoDaEseguire.getParametro());
		
		else
			System.out.println("Comando sconosciuto");
		
		if (this.partita.vinta()) 
		{
			System.out.println("Hai vinto!");
			
		}
		else if(partita.isFinita()) 
		{
			System.out.println("Hai perso");
		}
	}   

	private void aiuto() 
	{
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	public void vai(String direzione) 
	{
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		else 
		{
			Stanza prossimaStanza= this.lab.getStanzaCorrente().getStanzaAdiacente(direzione);
			
			
			if ("null".equals(prossimaStanza.getNome()))
				System.out.println("Direzione inesistente");
			
			else 
			{
				this.lab.setStanzaCorrente(prossimaStanza);
				
				int cfu = this.partita.getCfu();
				cfu=cfu-5;
				this.partita.setCfu(cfu);
				System.out.println("cfu correnti: " +this.partita.getCfu());
				System.out.println(this.lab.getStanzaCorrente().getDescrizione());
			}
		}
	}
		
		private void prendi(String nomeAttrezzo) 
		{			
			Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			
			this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		}

		private void posa(String nomeAttrezzo) 
		{
			Attrezzo a = this.partita.getGiocatore().getBorsa().getAttrezzoBorsa(nomeAttrezzo);
			
			this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			
			this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);	
		}

	private void fine() 
	{
		System.out.println("Grazie di aver giocato!");  
	}

	public static void main(String[] argc) 
	{
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}