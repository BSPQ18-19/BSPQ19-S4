package servidor.es.deusto.spq.jdo;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

public class CuentaPerfTest {
	private Cuenta cuenta;
	
	@Before
	public void setUp() {
		cuenta = new Cuenta("test@test.test", "test", "test", "test", 0, 0);
	}
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	public static junit.framework.Test suite(){
		return new JUnit4TestAdapter(CuentaPerfTest.class);
	}
	
	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 50, average = 10)
	public void testGetNombre() {
		assertEquals("test", cuenta.getNombre());
	}
}
