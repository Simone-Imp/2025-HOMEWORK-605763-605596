package it.uniroma3.DiaDia.ambienti;

import it.uniroma3.DiaDia.attrezzi.Attrezzo;

public class Stanza {
	
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;
    
    private Stanza[] stanzeAdiacenti;
    private int numeroStanzeAdiacenti;
    
	private String[] direzioni;

    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    }

	public int getnumeroAttrezzi() 
	{
		return this.numeroAttrezzi;
	}
    
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) 
    {
        boolean aggiornato = false;
    	for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) 
        	{
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) 
    		{
    			this.direzioni[numeroStanzeAdiacenti] = direzione;
    			this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
    		    this.numeroStanzeAdiacenti++;
    		}
    }

	public Stanza getStanzaAdiacente(String direzione) 
	{
        Stanza stanza = new Stanza("null");
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
        	if (this.direzioni[i].equals(direzione))
        		stanza = this.stanzeAdiacenti[i];
        return stanza;
	}

    public String getNome() 
    {
        return this.nome;
    }

    public String getDescrizione() 
    {
        return this.toString();
    }

    public Attrezzo[] getAttrezzi() 
    {
        return this.attrezzi;
    }

    public boolean addAttrezzo(Attrezzo attrezzo) 
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
    	boolean attrezzo_presente=false;
    	
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.nome);
    	risultato.append("\nUscite: ");
    	for (String direzione : this.direzioni)
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	risultato.append("\nAttrezzi nella stanza: ");
    	for(int i=0; i<numeroAttrezzi; i++) //for (Attrezzo attrezzo : this.attrezzi) 
    	{
    		if(attrezzi[i]!=null) 
    		{
    			risultato.append(attrezzi[i].toString()+" ");
    			attrezzo_presente=true;
    		}
    	}
    	
    	if(attrezzo_presente==false) 
    	{
    		
    			risultato.append("in questa stanza non vi sono attrezzi ");
  
    	}
    	return risultato.toString();
    }

	public boolean hasAttrezzo(String nomeAttrezzo) 
	{
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if (attrezzo.getNome().equals(nomeAttrezzo))
				trovato = true;
		}
		return trovato;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) 
	{
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if (attrezzo.getNome().equals(nomeAttrezzo))
				attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	public boolean removeAttrezzo(Attrezzo attrezzo) 
	{
		// TODO da implementare
		return false;
	}


	public String[] getDirezioni() {
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
	    for(int i=0; i<this.numeroStanzeAdiacenti; i++)
	    	direzioni[i] = this.direzioni[i];
	    return direzioni;
    }

}