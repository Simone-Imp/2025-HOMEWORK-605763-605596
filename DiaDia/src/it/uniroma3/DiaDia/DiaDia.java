package it.uniroma3.DiaDia;

import java.util.Scanner;

import it.uniroma3.DiaDia.ambienti.Stanza;
import it.uniroma3.DiaDia.ambienti.labirinto;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

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

	public DiaDia() {
		this.partita = new Partita();
		this.lab=partita.lab;
		this.lab.creaStanze();
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
	

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private void processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome().equals("fine") ) {
			this.fine(); 
		
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			System.out.println("Comando sconosciuto");
		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			
		}
		else if(partita.isFinita()) {
			System.out.println("Hai perso");
		}
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	public void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		else {
			Stanza prossimaStanza= this.lab.getStanzaCorrente().getStanzaAdiacente(direzione);
			
			if ("null".equals(prossimaStanza.getNome()))
				System.out.println("Direzione inesistente");
			else {
				this.lab.setStanzaCorrente(prossimaStanza);
				
				int cfu = this.partita.getCfu();
				cfu=cfu-5;//diminuzione cfu
				this.partita.setCfu(cfu);
				System.out.println("cfu correnti: " +this.partita.getCfu());
				System.out.println(this.lab.getStanzaCorrente().getDescrizione());
				}
		}
		
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}