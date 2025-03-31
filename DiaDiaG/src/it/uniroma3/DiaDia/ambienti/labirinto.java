package it.uniroma3.DiaDia.ambienti;
import it.uniroma3.DiaDia.attrezzi.Attrezzo;

public class labirinto {
	public Stanza stanzaCorrente;
	public Stanza stanzaVincente;
	private Attrezzo lanterna;
	private Attrezzo osso;
	private Stanza atrio;
	private Stanza aulaN11;
	private Stanza aulaN10;
	private Stanza laboratorio;
	private Stanza biblioteca;
	
	
	public labirinto() {
		/* crea gli attrezzi */  
    	lanterna = new Attrezzo("lanterna",3);
		osso = new Attrezzo("osso",1);
    	
		/* crea stanze del labirinto */
		atrio = new Stanza("Atrio");
		aulaN11 = new Stanza("Aula N11");
		aulaN10 = new Stanza("Aula N10");
		laboratorio = new Stanza("Laboratorio Campus");
	    biblioteca = new Stanza("Biblioteca");
		
	 // il gioco comincia nell'atrio
	    this.stanzaCorrente = this.atrio;  
		this.stanzaVincente = this.biblioteca;
	 
		
	}
	  public void creaStanze() 
	  {
			this.atrio.impostaStanzaAdiacente("nord", biblioteca);
			this.atrio.impostaStanzaAdiacente("est", aulaN11);
			this.atrio.impostaStanzaAdiacente("sud", aulaN10);
			this.atrio.impostaStanzaAdiacente("ovest", laboratorio);
			this.aulaN11.impostaStanzaAdiacente("est", laboratorio);
			this.aulaN11.impostaStanzaAdiacente("ovest", atrio);
			this.aulaN10.impostaStanzaAdiacente("nord", atrio);
			this.aulaN10.impostaStanzaAdiacente("est", aulaN11);
			this.aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
			this.laboratorio.impostaStanzaAdiacente("est", atrio);
			this.laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
			this.biblioteca.impostaStanzaAdiacente("sud", atrio);

			this.aulaN10.addAttrezzo(lanterna);
			this.atrio.addAttrezzo(osso);
	    }

		public Stanza getStanzaVincente() {
			return stanzaVincente;
		}
		public void setStanzaCorrente(Stanza stanzaCorrente) {
			this.stanzaCorrente = stanzaCorrente;
		}
		public Stanza getStanzaCorrente() {
			return this.stanzaCorrente;
		}
}
