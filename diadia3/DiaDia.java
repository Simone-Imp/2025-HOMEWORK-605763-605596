package diadia3;

import java.util.Scanner;

public class DiaDia 																					//classe principale del gioco
{

	static final private String MESSAGGIO_BENVENUTO = ""+												//messaggio di benvenuto
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};								//definizione immutabile dei 3 (nomi dei) comandi del gioco

	private Partita partita;																			//si definisce una partita

	public DiaDia() 																					//si crea un meotdo DiaDia nella classe DiaDia
	{
		this.partita = new Partita();
	}

	public void gioca() 																				//metodo gioca
	{
		String istruzione; 																				//creazione della stringa dove verranno salvati i parametri dei comandi
		Scanner scannerDiLinee;																			//??? USATO PER LEGGERE LE STRINGE??? FORSE

		System.out.println(MESSAGGIO_BENVENUTO);														
		scannerDiLinee = new Scanner(System.in);														//??????
		do		
			istruzione = scannerDiLinee.nextLine();														
		while (!processaIstruzione(istruzione));
	}   

	private boolean processaIstruzione(String istruzione) 
	{
		Comando comandoDaEseguire = new Comando(istruzione);											//crea un comando chimato comandoDaEseguire e lo valorizza come una stringa
																										//inserita in processaIstruzione
		if (comandoDaEseguire.getNome().equals("fine") ) 												//istruioni correlate ai comandi
		{
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());													//questo comando necessita di un parametro oltre che al nome
		
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		
		else
			System.out.println("Comando sconosciuto");
		
		if (this.partita.vinta()) 																		//schermata di fine partita
		{
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   

	private void aiuto() 																				//il comando aiuto stampa i 3 comandi dle gioco
	{
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}
	
	private void vai(String direzione) 																	//la direzione + una stringa presa con getParametro
	{
		if(direzione==null)																				//se la stringa è null chiede di reinserire il comando con il parametro
			System.out.println("Dove vuoi andare ?");
		else 
		{	
			Stanza prossimaStanza= this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);		//sposta il player
			
			if ("null".equals(prossimaStanza.getNome()))
				System.out.println("Direzione inesistente");
			else 
			{
				this.partita.setStanzaCorrente(prossimaStanza);
				int cfu = this.partita.getCfu();
				this.partita.setCfu(cfu);
				cfu=cfu-5;
				System.out.println(partita.getStanzaCorrente().getDescrizione());
			}
		}		
	}

	private void fine() 																				//altra schermata di fine partita
	{
		System.out.println("Grazie di aver giocato!");
	}

	public static void main(String[] argc) 
	{
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}