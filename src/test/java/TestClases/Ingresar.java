package TestClases;

import Pages.Login1;
import Utils.Espera;
import org.openqa.selenium.WebElement;

public class Ingresar {

    public void LoginNoValido(){
        Espera.esperar("//*[@id=\"imLogin\"]/form/div[3]/input");
        Login1 lg = new Login1();
        lg.LoggearMAL();
        WebElement mensajeerror = lg.getERRMSG();
        System.out.println(mensajeerror.getCssValue("color"));
    }
}
