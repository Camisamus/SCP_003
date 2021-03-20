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

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_2\"]")
    WebElement TXTcampo1;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_3\"]")
    WebElement TXTmail;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_4\"]")
    WebElement TXTcampo3;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_5\"]")
    WebElement DATEELEMENTfecha;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_6\"]")
    WebElement SELECTcampolista;



    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_0\"]")
    WebElement opcion1CHECKcampoopcionmultiple;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_1\"]")
    WebElement opcion2CHECKcampoopcionmultiple;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_7_2\"]")
    WebElement opcion3CHECKcampoopcionmultiple;

    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_0\"]")
    WebElement Opcion1RADIOBTN;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_1\"]")
    WebElement Opcion2RADIOBTN;
    @FindBy(xpath = "//*[@id=\"imObjectForm_1_8_2\"]")
    WebElement Opcion3RADIOBTN;



    public void LoggearMAL(){
        TXTUsuario.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Usuario"));
        BTNLogin.click();
    }
    public void LoggearBien(){
        TXTUsuario.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Usuario"));
        TXTContrasena.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("Clave"));
        BTNLogin.click();
    }
    public void LlenarFormulario(){
        TXTcampo1.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTcampo1"));
        TXTmail.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTmail"));
        TXTcampo3.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("TXTcampo3"));
        DATEELEMENTfecha.sendKeys(ReadProperties.readFromConfig("Propiedades.properties").getProperty("DATEELEMENTfecha"));
        Select campolista = new Select(SELECTcampolista);
        switch (ReadProperties.readFromConfig("Propiedades.properties").getProperty("SELECTcampolista")){
            case "1":
                campolista.selectByIndex(1);
                break;
            case "2":
                campolista.selectByIndex(2);
                break;
            case "3":
                campolista.selectByIndex(3);
                break;
            default:
                campolista.selectByIndex(0);
                break;
        }
        if(ReadProperties.readFromConfig("Propiedades.properties").getProperty("opcion1CHECKcampoopcionmultiple").equals("True")){
            opcion1CHECKcampoopcionmultiple.click();
        }
        if(ReadProperties.readFromConfig("Propiedades.properties").getProperty("opcion2CHECKcampoopcionmultiple").equals("True")){
            opcion2CHECKcampoopcionmultiple.click();
        }
        if(ReadProperties.readFromConfig("Propiedades.properties").getProperty("opcion3CHECKcampoopcionmultiple").equals("True")){
            opcion3CHECKcampoopcionmultiple.click();
        }
        switch (ReadProperties.readFromConfig("Propiedades.properties").getProperty("OpcionRADIOBTN")){
            case "1":
                Opcion1RADIOBTN.click();
                break;
            case "2":
                Opcion2RADIOBTN.click();
                break;
            case "3":
                Opcion3RADIOBTN.click();
                break;
        }
        System.out.println("se lleno el formulario");
    }

    public WebElement getERRMSG() {
        return ERRMSG;
    }
}
