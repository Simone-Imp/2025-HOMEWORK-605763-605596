import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {	

	Attrezzo attrezzo = new Attrezzo("martello", 18);
	Stanza stanza1 = new Stanza("stanza1");
	Stanza stanza2= new Stanza("stanza2");
	
	@Test
	public void testGetStanzaAdiacente() 
	{
		assertNull(stanza1.getStanzaAdiacente("sud"));
	}
		
	@Test
	public void testAddAttrezzo() 
	{		
		assertTrue(stanza1.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testImpostaStanzaAdiacente() 
	{
		stanza1.impostaStanzaAdiacente("ovest", stanza2);
		assertEquals(stanza2, stanza1.getStanzaAdiacente("ovest"));
	}
}