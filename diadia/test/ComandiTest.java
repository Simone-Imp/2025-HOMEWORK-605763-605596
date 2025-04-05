import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Comando;

public class ComandiTest 
{	
	Comando Comando1;
	Comando Comando2;
	
	@Before
	public void setUp() 
	{
		Comando1 = new Comando ("Comanda");
		Comando2 = new Comando ("Comanda"+" "+"Oggetto");
	}
	
	@Test
	public void testGetNome()
	{
		assertEquals(Comando1.getNome(), Comando2.getNome());
	}

	@Test
	public void testGetParametroNullo()
	{
		assertNull(Comando1.getParametro());
	}
	
	@Test
	public void testGetParametroNonNullo()
	{
		assertEquals("Oggetto", Comando2.getParametro());
	}
}
