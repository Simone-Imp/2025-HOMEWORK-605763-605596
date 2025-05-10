package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza 
{
	public String direzioneBloccata;
	private String attrezzoSbloccante;

	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzoSbloccante) 
	{
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.attrezzoSbloccante = attrezzoSbloccante;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) 
	{
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzoSbloccante)) 
		{
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() 
	{		
		
		String bloccata = "\nStanza bloccata nella direzione: "+ direzioneBloccata+"\nPrendi il " + attrezzoSbloccante + " e posalo nella stanza";
		
		StringBuilder appoggio = new StringBuilder();
		
		appoggio.append(this.nome);
		appoggio.append("\nUscite:");
		for (String direzione : this.direzioni)
			if (direzione!=null)
				appoggio.append(" " + direzione);
		
		appoggio.append(" "+ bloccata);

		if(!this.hasAttrezzo(attrezzoSbloccante))
			return appoggio.toString();
		return super.getDescrizione();
	}
}