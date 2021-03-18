package TestSuite;

import TestClases.Ingresar;
import Utils.DriverContext;
import constants.Navegador;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class RecuperarInformacion {
    ChromeDriver Driver;
    String Ruta = "http://www.qanovagroup.com/piloto/";
    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome, Ruta);
    }
    @Test
    public void test()throws InterruptedException{
        Ingresar inicio = new Ingresar();
        inicio.LoginNoValido();
    }
    @AfterTest
    public void end(){
        DriverContext.closeDriver();
    }
}
