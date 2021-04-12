package TestSuite;

import TestClases.Ingresar;
import TestClases.pagedescarga;
import Utils.Constants.Navegador;
import Utils.DriverContext;
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
     @Test
    public void prueba002(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.LlenarValido();
    }
    @Test
    public void prueba003(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.Buscarregistrosfiltrados();
    }
    @Test
    public void prueba004(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.Subearchivo();
    }
    @Test
    public void prueba005(){
        DriverContext.closeDriver();
        DriverContext.setUp( Navegador.Chrome2, (ReadProperties.readFromConfig("Propiedades.properties").getProperty("RutaDescarga")));
        pagedescarga DCG = new pagedescarga();
        DCG.confirmarPreviaDescarga();
        DCG.descargarsomefile();
        DCG.confirmarDescarga();
    }
    @Test
    public void prueba006(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.LlenarDate();
    }
    @Test
    public void prueba007(){
        Ingresar inicio = new Ingresar();
        inicio.LoginValido();
        inicio.LlenarValido();
        inicio.LlenarDate();
        inicio.enviaform();
        inicio.Buscarregistrosfiltra2();
    }
}
