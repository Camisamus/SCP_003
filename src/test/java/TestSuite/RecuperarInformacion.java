package TestSuite;

import TestClases.Ingresar;
import Utils.DriverContext;
import Utils.DriverManager;
import Utils.Navegador;
import Utils.ReadProperties;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class RecuperarInformacion {


    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome,(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Ruta")));
    }

    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }

    @Test
    public void prueba001(){
        Ingresar inicio = new Ingresar();
        inicio.LoginNoValido();
    }
   // @Test
    public void prueba002(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
    }
}
