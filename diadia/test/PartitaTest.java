import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

	Partita partita = new Partita();
	Stanza stanza = new Stanza("Stanza");
	
	@Test
	public void testGetStanzaVincente() 
	{
		assertEquals("Biblioteca", partita.getLabirinto().getStanzaVincente().getNome());
	}

	@Test
	public void testIsFinita() 
	{		
		assertFalse(partita.isFinita());
	}

	@Test
	public void testGetStanzaIniziale() 
	{
		assertEquals("Atrio", partita.getLabirinto().getStanzaCorrente().getNome());
	}
}