package TestClases;

import Pages.Login1;
import org.openqa.selenium.WebElement;

public class Ingresar {
    public void LoginNoValido(){
        Login1 lg = new Login1();
        lg.LoggearMAL();
        WebElement mensajeerror = lg.getERRMSG();
        System.out.println(mensajeerror.getCssValue("color"));
    }
}
