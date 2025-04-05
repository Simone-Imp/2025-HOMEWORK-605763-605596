import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest 
{
	Labirinto labirinto ;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() 
	{
		labirinto  = new Labirinto();
		labirinto.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}

	@Test
	public void testGetStanzaVincente() 
	{
		assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
	}

	@Test
	public void testGetStanzaCorrente() 
	{
		assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() 
	{
		labirinto.setStanzaCorrente(DS1);
		assertEquals(DS1, labirinto.getStanzaCorrente());
	}
}