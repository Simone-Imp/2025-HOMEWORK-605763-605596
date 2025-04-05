import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Attrezzotest 
{
	Attrezzo AttrezzoA;
	Attrezzo AttrezzoB;
	
	@Before
	public void setUp() 
	{
		 AttrezzoA = new Attrezzo ("righello", 1);
		 AttrezzoB = new Attrezzo ("temperino", 1);
	}
	
	@Test
	public void testGetNome()
	{
		assertEquals("righello", AttrezzoA.getNome());
	}
	
	@Test
	public void testGetPeso()
	{
		assertEquals(AttrezzoB.getPeso(), AttrezzoA.getPeso());
	}
}