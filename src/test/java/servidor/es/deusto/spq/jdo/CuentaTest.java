package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import servidor.es.deusto.spq.jdo.Cuenta;

public class CuentaTest {
    private Cuenta cuenta;

    @Before
    public void setUp(){
        cuenta = new Cuenta("a@a.a", "nombre", "pass", "paypal", 1, 2);
    }


    @Test
    public void testgetCorreo(){
        String actual = cuenta.getCorreo();
        assertEquals("a@a.a", actual);
    }

    @Test
    public void testgetNombre() {
        String actual = cuenta.getNombre();
        assertEquals("nombre", actual);
    }
    
    @Test
    public void testgetContrasenna() {
        String actual = cuenta.getContrasenna();
        assertEquals("pass", actual);
    }
    @Test
    public void testgetPaypal(){
        String actual = cuenta.getPaypal();
        assertEquals("paypal", actual);
    }
    @Test
    public void testgetPrivilegio(){
        int actual = cuenta.getPrivilegio();
        assertEquals(1, actual);
    }
    
    @Test
    public void testgetGasto() {
        double actual = cuenta.getGasto();
        assertEquals(2, actual, 0.0000);
    }

    @Test
    public void testsetCorreo() {
        cuenta.setCorreo("correo@correo.correo");
        String actual = cuenta.getCorreo();
        assertEquals("correo@correo.correo", actual);
    }

    @Test
    public void testsetNombre() {
        cuenta.setNombre("koldo");
        String actual = cuenta.getNombre();
        assertEquals("koldo", actual);
    }

    @Test
    public void testsetContrasenna() {
        cuenta.setContrasenna("contrasenna");
        String actual = cuenta.getContrasenna();
        assertEquals("contrasenna", actual);
    }

    @Test
    public void testsetPaypal() {
        cuenta.setPaypal("Paypal");
        String actual = cuenta.getPaypal();
        assertEquals("Paypal", actual);
    }

    @Test
    public void testsetPrivilegio() {
        cuenta.setPrivilegio(0);
        int actual = cuenta.getPrivilegio();
        assertEquals(0, actual);
    }

    @Test
    public void testsetGasto() {
        double gasto = 5.3;
        cuenta.setGasto(gasto);
        double actual = cuenta.getGasto();
        assertEquals(5.3, actual, 0.0000);
    }

    @Test
    public void testtoString(){
        String actual = cuenta.toString();
        assertEquals("Usuario [correo=a@a.a, nombre=nombre, contrasenna=pass, paypal=paypal, privilegio=1, gasto=2.0]", actual);
    }
}

