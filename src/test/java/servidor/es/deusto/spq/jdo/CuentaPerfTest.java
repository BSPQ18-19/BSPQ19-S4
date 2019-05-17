package servidor.es.deusto.spq.jdo;

import static org.junit.Assert.assertEquals;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;

@PerfTest(invocations = 50)
@Required(max = 20, average = 1)
public class CuentaPerfTest {
	private Cuenta cuenta;

	@Before
	public void setUp() {
		cuenta = new Cuenta("test@test.test", "test", "test", "test", 0, 0);
	}

	@Rule
	public ContiPerfRule rule = new ContiPerfRule();

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(CuentaPerfTest.class);
	}

	@Test
	@PerfTest(invocations = 1000, threads = 20)
	@Required(max = 50, average = 10)
	public void testGetNombre() {
		assertEquals("test", cuenta.getNombre());
	}

	@Test
	@PerfTest(invocations = 1000, threads = 30)
	@Required(max = 8, average = 1)
	public void testGetCorreo() {
		assertEquals("test@test.test", cuenta.getCorreo());
	}

	@Test
	@PerfTest(invocations = 1000, threads = 30)
	@Required(max = 80, average = 12)
	public void testGetContrasenna() {
		assertEquals("test", cuenta.getContrasenna());
	}

	@Test
	@PerfTest(invocations = 1000, threads = 15)
	@Required(max = 30, average = 5)
	public void testGetPaypal() {
		assertEquals("test", cuenta.getPaypal());
	}

	@Test
	@PerfTest(invocations = 10000, threads = 30)
	@Required(max = 30, average = 10)
	public void testGetPrivilegio() {
		assertEquals(0, cuenta.getPrivilegio());
	}

	@Test
	@PerfTest(invocations = 2000, threads = 30)
	@Required(max = 80, average = 10)
	public void testGetGasto() {
		assertEquals(0, cuenta.getGasto(), 0);
	}

	@Test
	@PerfTest(invocations = 6000, threads = 60)
	@Required(max = 20, average = 10)
	public void testsetCorreo() {
		cuenta.setCorreo("correo@correo.correo");
		String actual = cuenta.getCorreo();
		assertEquals("correo@correo.correo", actual);
	}

	@PerfTest(invocations = 6000, threads = 50)
	@Required(max = 10, average = 10)
	@Test
	public void testsetNombre() {
		cuenta.setNombre("koldo");
		String actual = cuenta.getNombre();
		assertEquals("koldo", actual);
	}

	@PerfTest(invocations = 1000, threads = 8)
	@Required(max = 10, average = 10)
	@Test
	public void testsetContrasenna() {
		cuenta.setContrasenna("contrasenna");
		String actual = cuenta.getContrasenna();
		assertEquals("contrasenna", actual);
	}

	@PerfTest(invocations = 10000, threads = 200)
	@Required(max = 50, average = 10)
	@Test
	public void testsetPaypal() {
		cuenta.setPaypal("Paypal");
		String actual = cuenta.getPaypal();
		assertEquals("Paypal", actual);
	}

	@PerfTest(invocations = 5000, threads = 20)
	@Required(max = 30, average = 1)
	@Test
	public void testsetPrivilegio() {
		cuenta.setPrivilegio(0);
		int actual = cuenta.getPrivilegio();
		assertEquals(0, actual);
	}

	@PerfTest(invocations = 5000, threads = 20)
	@Required(max = 15, average = 5)
	@Test
	public void testsetGasto() {
		double gasto = 5.3;
		cuenta.setGasto(gasto);
		double actual = cuenta.getGasto();
		assertEquals(5.3, actual, 0.0000);
	}

	@Test
	@PerfTest(invocations = 5000, threads = 1)
	@Required(max = 20, average = 5)
	public void testtoString() {
		String actual = cuenta.toString();
		assertEquals("Usuario [correo=test@test.test, nombre=test, contrasenna=test, paypal=test, privilegio=0, gasto=0.0]",
				actual);
	}

}
