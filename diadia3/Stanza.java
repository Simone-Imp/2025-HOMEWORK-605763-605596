package diadia3;																

public class Stanza 															//classe stanza, la stanza ha uscite ed entrate che portano ad altre stanze				
{	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;						//parametro arbitrario stanza
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;						//parametro arbitrario stanza
	
	private String nome;														//dichiarazione di vari parametri della stanza
																				 
    private Attrezzo[] attrezzi;												 
    private int numeroAttrezzi;													 
    																			 
    private Stanza[] stanzeAdiacenti;											 
    private int numeroStanzeAdiacenti;											 
    																			 
	private String[] direzioni;													

    public Stanza(String nome) 													//comando che crea una stanza vuota senza connessioni o attrezzi
    {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];					//le direzioni sono un array di dimensione = 4
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];			//le stanze adiacenti sono un array di dimensione = 4
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];					//gli attrezzi sono un array di dimensione = 4
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanza) 		//comando che imposta le stanze adiacenti alla stanza con la quale dichiari il comando o valorizza le direzioni
    {
        boolean aggiornato = false;												//variabile di controllo										
    	for(int i=0; i<this.direzioni.length; i++)								//for che fa 1 ciclo per direzione (4 direzioni)
        	if (direzione.equals(this.direzioni[i])) 							//e quando trova quella che hai inserito...
        	{
        		this.stanzeAdiacenti[i] = stanza;								//...imposta la stanza che hai inserito come stanza adiacente a (direzione) della
        		aggiornato = true;												//modifica la variabile di controllo
        	}
    	
    	if (!aggiornato)														//se la variabile di controllo non viene modificata e...
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) 			//... se il numero di staza adiacenti è inferiore alle direzioni possibile
    		{	
    			this.direzioni[numeroStanzeAdiacenti] = direzione;				//questo if imposta le 4 direzioni dell'array direzioni della stanza...	
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;			//... così le direzioni sono valorizzate nord,est,sud,ovest
    		    this.numeroStanzeAdiacenti++;
    		}
    }
    
	public Stanza getStanzaAdiacente(String direzione)							//comando che crea un riferimento stanza vuoto che poi riempie con la stanza								
	{																			//adiancete a quella con cui dichiari il comando nella direzioni messa tra parentesi
        Stanza stanza = new Stanza("null");							
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
        	if (this.direzioni[i].equals(direzione))
        		stanza = this.stanzeAdiacenti[i];
        return stanza;
	}

    public String getNome() 													//comando che restituisce il nome di una stanza
    {
        return this.nome;
    }

    public String getDescrizione() 												//??? NON HO CAPITO CHE FA QUESTO COMANDO
    {
        return this.toString();
    }

    public Attrezzo[] getAttrezzi() 											//comando che restituisce gli
    {
        return this.attrezzi;													//comando che restituisce nome e peso degli oggetti "attrezzi" nell'array attrezzi	
    }


    public boolean addAttrezzo(Attrezzo attrezzo) 								//comando che aggiunge un attrezzo in fondo allìarray degli attrezzi della stanza con cui dichiari il comando
    {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) 
        {
        	this.attrezzi[numeroAttrezzi] = attrezzo;
        	this.numeroAttrezzi++;												
        	return true;
        }
        else 
        {
        	return false;
        }
    }

    public String toString() 
    {
    	boolean attrezzo_presente=false;										//variabile di comando
    	
    	StringBuilder risultato = new StringBuilder();							
    	risultato.append(this.nome);											//stampa il nome della stanza
    	risultato.append("\nUscite: ");											//dopo essere andato a capo (\n) stampa "Uscite:" e ...
    	for (String direzione : this.direzioni)
    		if (direzione!=null)												//...,dopo aver controllato quali direzioni non sono null,...
    			risultato.append(" " + direzione);								//... la lista delle direzioni con l'entrata di una stanza adiacente
    	risultato.append("\nAttrezzi nella stanza: ");
    	for (Attrezzo attrezzo : this.attrezzi) 								//ciclo con la stessa funzione di prima ma per gli attrezzi
    	{
    		if(attrezzo!=null) 													//se l'attrezzo elemento dell'array attrezzo non è null
    		{
    			risultato.append(attrezzo.toString()+" ");						//stampa il nome ed il peso dell'attrezzo
    			attrezzo_presente=true;											//e imposta la variabile di comando su true (lo fa anche se era già true)
    		}
    	}
    	
    	if(attrezzo_presente==false) 											//se la variabile di comando è false
    	{
    			risultato.append("in questa stanza non vi sono attrezzi ");		//stampa che nella stanza non ci sono attrezzi
    	}
    	return risultato.toString();
    }

	public boolean hasAttrezzo(String nomeAttrezzo) 							//comando che scorre l'array di attrezzi presenti nella stanza
	{																			//e se trova quello che cerchi restirtuisce un boolean true (false se non lo trova)
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) 							//comando che crea un attrezzo di classe attrezzo fittizio = null e dopo che ha scorso tuttol'array attrezzi...
	{																			//...della stanza se trova l'attrezzo inserito nel comando lo copia e poi restiruisce l'attrezzo
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	public boolean removeAttrezzo(Attrezzo attrezzo) 							//??? NON PENSO QUESTO COMANDO FUNZIONI, NON è MAI RICHIAMATO
	{
		return false;
	}


	public String[] getDirezioni() 												//comando che crea una array di stringe che contengono le direzioni possibili che puoi percorrere
	{																			//dopo che sei entrato in una stanza
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

}