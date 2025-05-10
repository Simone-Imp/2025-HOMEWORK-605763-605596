package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Stanza 
{
	public Stanza[] getStanzeAdiacenti() 
	{
		return stanzeAdiacenti;
	}

	public void setStanzeAdiacenti(Stanza[] stanzeAdiacenti) 
	{
		this.stanzeAdiacenti = stanzeAdiacenti;
	}

	public int getNumeroStanzeAdiacenti() 
	{
		return numeroStanzeAdiacenti;
	}

	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) 
	{
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}

	public void setDirezioni(String[] direzioni) 
	{
		this.direzioni = direzioni;
	}

	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	private static final int NUMERO_MASSIMO_ATTREZZI = 10;

	protected String nome;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;

	public int getNumeroAttrezziPossibili() 
	{
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}

	private Stanza[] stanzeAdiacenti;
	private int numeroStanzeAdiacenti;
	protected String[] direzioni;

	public Stanza(String nome) 
	{
		this.nome = nome;
		this.numeroStanzeAdiacenti = 0;
		this.numeroAttrezzi = 0;
		this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
		this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
		this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
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
		Stanza stanza = null;
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
		else {
			return false;
		}
	}

	public String toString() 
	{
		StringBuilder risultato = new StringBuilder();
		risultato.append(this.nome);
		risultato.append("\nUscite: ");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				risultato.append(" " + direzione);
		risultato.append("\nAttrezzi nella stanza: ");
		for (Attrezzo attrezzo : this.attrezzi) {
			if(attrezzo!=null)
				risultato.append(attrezzo.toString()+" ");
		}
		return risultato.toString();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) 
	{
		boolean trovato;
		trovato = false;
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if(attrezzo != null) {
				if (attrezzo.getNome().equals(nomeAttrezzo))
					trovato = true;
			}
		}
		return trovato;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) 
	{
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		for (Attrezzo attrezzo : this.attrezzi) 
		{
			if(attrezzo != null)
				if (attrezzo.getNome().equals(nomeAttrezzo))
					attrezzoCercato = attrezzo;
		}
		return attrezzoCercato;	
	}

	public boolean removeAttrezzo(Attrezzo attrezzo) 
	{
		if(attrezzo!=null)
		{
			int i = 0;
			for(Attrezzo a : this.attrezzi) 
			{
				if(a != null) {
					if(a.getNome().equals(attrezzo.getNome())) 
					{
						this.attrezzi[i] = null;
						this.numeroAttrezzi--;
					}
				}
				i++;
			}
			return true;
		}
		else
			return false;
	}

	public String[] getDirezioni() 
	{
		String[] direzioni = new String[this.numeroStanzeAdiacenti];
		for(int i=0; i<this.numeroStanzeAdiacenti; i++)
			direzioni[i] = this.direzioni[i];
		return direzioni;
	}
}