package TestSuite;

import TestClases.Ingresar;
import Utils.DriverContext;
import Utils.Navegador;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class RecuperarInformacion {

    String Ruta = "http://www.qanovagroup.com/piloto/";

    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome, Ruta);
    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }

    @Test
    public void prueba(){
        Ingresar inicio = new Ingresar();
        inicio.LoginNoValido();
    }
}
