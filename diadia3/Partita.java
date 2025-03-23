package diadia3;

public class Partita 														//classe che modella una partita nel gioco
{
	static final private int CFU_INIZIALI = 20;								//variabile arbitraria valorizzata

	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;											//variabili arbitrarie
	private boolean finita;
	private int cfu;
	
	public Partita()														
	{
		creaStanze();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
	}

    private void creaStanze() 
    {

    	Attrezzo lanterna = new Attrezzo("lanterna",3);					//creazione di attrezzi con un nome e un peso
		Attrezzo osso = new Attrezzo("osso",1);
    	
		Stanza atrio = new Stanza("Atrio");								//creazione di stanze vuote con solo un nome
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
			
		atrio.impostaStanzaAdiacente("nord", biblioteca);				//valorizzazione dei parametri stanze adiacenti delle stanze e conseguente creazione ...
		atrio.impostaStanzaAdiacente("est", aulaN11);					//... dell'archiettura statica del labirinto
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

		aulaN10.addAttrezzo(lanterna);									//valorizzazione del paramentro attrezzo dei due stanze
		atrio.addAttrezzo(osso);

        stanzaCorrente = atrio;  										//valorizzazione arbitraria del punto di inizio e del punto di fine
		stanzaVincente = biblioteca;
    }

	public Stanza getStanzaVincente() 									//comando che restisce la stanza salvata nel parametro stanzaVincente
	{
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) 				//comando che valorizza la stanza modifica la stanza corrente
	{
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() 									//comando che restisce la stanza salvata nel parametro stanzaCorrente (quello dichiarato in cima)
	{
		return this.stanzaCorrente;
	}
	
	public boolean vinta() 												
	{
		return this.getStanzaCorrente()== this.getStanzaVincente();		//la variabile booleana vinta è equiparata all'equivalenza tra la stanza corrente e quella vincente
	}																	//dopodiche viene restituita

	public boolean isFinita() 											//???? COSA RESTITUISCE? FINITA VITTORIA O CFU==0???
	{
		return finita || vinta() || (cfu == 0);
	}

	public void setFinita() 											//comando che imposta la variabile booleana finita come true
	{
		this.finita = true;
	}

	public int getCfu() 												//comando che restituisce il numero di cfu 
	{	
		return this.cfu;
	}

	public void setCfu(int cfu) 										//comando che imposta/valorizza il numero di cfu 
	{
		this.cfu = cfu;		
	}	
}
