import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest 
{
	Borsa borsa = new Borsa();
	Attrezzo attrezzo1;
	Attrezzo attrezzo2;
	
	@Before
	public void setUp() {
		attrezzo1 = new Attrezzo("sega", 3);
		attrezzo2 = new Attrezzo("martello", 18);
	}

	@Test
	public void testAddAttrezzoPesoMinoreMax() 
	{
		assertTrue(borsa.addAttrezzo(attrezzo1));
	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreMax() 
	{
		assertFalse(borsa.addAttrezzo(attrezzo2));

	}
	
	@Test
	public void testGetPeso() 
	{
		borsa.addAttrezzo(attrezzo1);
		assertEquals(attrezzo1, borsa.getAttrezzo("sega"));

	}
}
