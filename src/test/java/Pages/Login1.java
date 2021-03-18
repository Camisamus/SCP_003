package Pages;

import Utils.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login1 {
    @FindBy(xpath = "//*[@id=\"imUname\"]")
    private WebElement TXTUsuario;
    @FindBy(xpath = "//*[@id=\"imPwd\"]")
    private WebElement TXTContrasena;
    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    private WebElement BTNLogin;
    @FindBy(xpath = "//*[@id=\"imLoginPage\"]/div[3]/div")
    private WebElement ERRMSG;

    public void Login1(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void LoggearMAL(){
        BTNLogin.click();
    }

    public WebElement getERRMSG() {
        return ERRMSG;
    }
}
