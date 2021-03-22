package Pages;

import Utils.DriverContext;
import Utils.ReadProperties;
import Utils.Espera;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.internal.Utils;

public class Login1 {
    public Login1(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"imUname\"]")
    WebElement TXTUsuario;

    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    WebElement TXTContrasena;

    @FindBy(xpath = "//*[@id=\"imLogin\"]/form/div[3]/input")
    WebElement BTNLogin;

    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    WebElement ERRMSG;



    public void LoggearMAL(){
        TXTUsuario.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Usuario"));
        BTNLogin.click();
    }
    public void LoggearBien(){
        TXTUsuario.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Usuario"));
        TXTContrasena.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Clave"));
        BTNLogin.click();
    }

    public WebElement getERRMSG() {
        return ERRMSG;
    }
}
