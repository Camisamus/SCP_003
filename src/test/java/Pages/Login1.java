package Pages;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        BTNLogin.click();
    }

    public WebElement getERRMSG() {
        return ERRMSG;
    }
}
